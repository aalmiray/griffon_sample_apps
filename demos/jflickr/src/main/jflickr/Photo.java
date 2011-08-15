package jflickr;

import java.net.MalformedURLException;
import java.net.URL;

public class Photo {
    private final URL url;
    private final String tooltip;
    
    public Photo(String title, String url) throws MalformedURLException {
        this.url = new URL(url);
        tooltip = "<html>" + title + "<br/>" + url + "</html>";
    }
       
    public URL getUrl() {
        return url;
    }
    
    public String getToolTip() {
        return tooltip;
    }
}