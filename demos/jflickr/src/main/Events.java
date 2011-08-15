import griffon.core.GriffonApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jflickr.FlickrService;

public class Events {
    public void onBootstrapEnd(GriffonApplication app) {
        InputStream is = app.getClass().getClassLoader().getResourceAsStream("flickr.key");
        if(is!= null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            try {
                app.getConfig().put(FlickrService.FLICKR_API_KEY, reader.readLine());
            } catch (IOException e) {
                // bubble it up
                throw new IllegalStateException("Cannot locate flickr API key.",e);
            }
        }
    }
}