package jflickr;

import griffon.swing.BindUtils;
import griffon.transitions.TransitionLayout;
import griffon.util.CallableWithArgs;
import griffon.util.GriffonNameUtils;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import org.codehaus.griffon.runtime.core.AbstractGriffonView;

public class JflickrView extends AbstractGriffonView {
    public static final String ID_SEARCH_ACTION = "searchAction";
    public static final String ID_PREVIOUS_ACTION = "previousAction";
    public static final String ID_NEXT_ACTION = "nextAction";
    public static final String ID_PHOTOS = "photos";
    public static final String ID_BUSY = "busy";
    public static final String ID_SEARCH_FIELD = "searchField";
    
    private JflickrController controller;
    private JflickrModel model;
    
    public void setController(JflickrController controller) {
        this.controller = controller;
    }
    
    public void setModel(JflickrModel model) {
        this.model = model;
    }
    
    public void mvcGroupInit(Map<String, ?> args) {
        setupActions();
        
        buildViewFromXml(args);
        
        BindUtils.binding()
                 .withSource(getBuilder().getVariable(ID_SEARCH_FIELD))
                 .withSourceProperty("text").withTarget(model)
                 .withTargetProperty(JflickrModel.PROP_TAG)
                 .make(getBuilder());
        
        BindUtils.binding()
                 .withTarget(getBuilder().getVariable(ID_BUSY))
                 .withSource(model)
                 .withSourceProperty(JflickrModel.PROP_BUSY)
                 .make(getBuilder());
        
        BindUtils.binding()
                 .withTarget(getBuilder().getVariable(ID_SEARCH_ACTION))
                 .withTargetProperty("enabled")
                 .withSource(model)
                 .withSourceProperty(JflickrModel.PROP_TAG).withConverter(new CallableWithArgs<Boolean>() {
                     public Boolean call() throws Exception {
                         Object[] args = getArgs();
                         return args.length > 0 ? !GriffonNameUtils.isBlank(String.valueOf(args[0])) : Boolean.FALSE;
                     }
                 })
                 .make(getBuilder());
    }
    
    public void createImages(List<Photo> photos) {
        final List<JComponent> images = new ArrayList<JComponent>();
        for (Photo photo : photos) {
            JLabel image = new JLabel(new ImageIcon(photo.getUrl()));
            image.setToolTipText(photo.getToolTip());
            images.add(new JScrollPane(image));
        }
        
        execAsync(new Runnable() {
            public void run() {
                photos().removeAll();
                int i = 0;
                for (JComponent image : images) {
                    photos().add("image-" + (i++), image);
                }
            }
        });
    }
    
    private void setupActions() {
        getBuilder().setVariable(ID_SEARCH_ACTION, new NamedAction("Search") {
            public void actionPerformed(ActionEvent event) {
                model.setBusy(true);
                try {
                    controller.searchAction(event);
                } finally {
                    getApp().execAsync(new Runnable() {
                        public void run() {
                            model.setBusy(false);
                        }
                    });
                }
            }
        });
        getBuilder().setVariable(ID_PREVIOUS_ACTION, new NamedAction("<<") {
            public void actionPerformed(ActionEvent event) {
                ((TransitionLayout)photos().getLayout()).previous(photos());
            }
        });
        getBuilder().setVariable(ID_NEXT_ACTION, new NamedAction(">>") {
            public void actionPerformed(ActionEvent event) {
                ((TransitionLayout)photos().getLayout()).next(photos());
            }
        });
    }
    
    private JComponent photos() {
        return (JComponent)getBuilder().getVariable(ID_PHOTOS);
    }
    
    private static abstract class NamedAction extends AbstractAction {
        public NamedAction(String name) {
            putValue(Action.NAME, name);
        }
    }
}
