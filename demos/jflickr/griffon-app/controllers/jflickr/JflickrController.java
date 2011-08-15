package jflickr;

import java.awt.event.ActionEvent;

import org.codehaus.griffon.runtime.core.AbstractGriffonController;

public class JflickrController extends AbstractGriffonController {
    private JflickrModel model;
    private JflickrView view;
    private FlickrService flickrService;
    
    public void setModel(JflickrModel model) {
        this.model = model;
    }
    
    public void setView(JflickrView view) {
        this.view = view;
    }
    
    public void setFlickrService(FlickrService flickrService) {
        this.flickrService = flickrService;
    }
    
    public void searchAction(ActionEvent event) {
        view.createImages(flickrService.search(model.getTag()));        
    }
}