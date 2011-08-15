package javatest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.beans.*;
import java.util.Map;

import griffon.swing.SwingGriffonApplication;
import griffon.swing.WindowManager;
import org.codehaus.griffon.runtime.core.AbstractGriffonView;

/**
 * Equivalent Groovy code:
 * <pre>
 * package javatest
 * 
 * application(title: 'java-test',
 *   pack: true,
 *   locationByPlatform:true,
 *   iconImage: imageIcon('/griffon-icon-48x48.png').image,
 *   iconImages: [imageIcon('/griffon-icon-48x48.png').image,
 *                imageIcon('/griffon-icon-32x32.png').image,
 *                imageIcon('/griffon-icon-16x16.png').image]) {
 *     gridLayout(cols: 1, rows: 3)
 *     textField columns: 20, text: bind('input', target: model)
 *     button 'Copy', actionPerformed: controller.copy
 *     textField columns: 20, editable: false, text: bind{ model.output }
 * }
 * </pre>
 */
public class JavaTestView extends AbstractGriffonView {
    private JavaTestController controller;
    private JavaTestModel model;

    public void setController(JavaTestController controller) {
        this.controller = controller;
    }

    public void setModel(JavaTestModel model) {
        this.model = model;
    }

    public void mvcGroupInit(Map<String, ?> args) {
        execSync(new Runnable() {
            public void run() {
                JFrame view = new JFrame("java-test");
                view.setIconImage(getImage("/griffon-icon-48x48.png"));
                view.setIconImages(java.util.Arrays.asList(
                    getImage("/griffon-icon-48x48.png"),
                    getImage("/griffon-icon-32x32.png"),
                    getImage("/griffon-icon-16x16.png")
                ));
                view.setLocationByPlatform(true);
                view.getContentPane().add(init());
                view.pack();
                ((SwingGriffonApplication) getApp()).getWindowManager().attach(view);
            }
        });
    }

    // build the UI
    private JComponent init() {
        final JTextField input = new JTextField(20);
        final JTextField output = new JTextField(20);
        output.setEditable(false);
        final JButton button = new JButton("Copy");

        input.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { model.setInput(input.getText()); }
            public void insertUpdate(DocumentEvent e) { model.setInput(input.getText()); }
            public void removeUpdate(DocumentEvent e) { model.setInput(input.getText()); }
        });
        model.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                output.setText(model.getOutput());
            }
        });
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.copy(e);
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(input);
        panel.add(button);
        panel.add(output);

        return panel;
    }

    private Image getImage(String path) {
        return Toolkit.getDefaultToolkit().getImage(JavaTestView.class.getResource(path));
    }
}
