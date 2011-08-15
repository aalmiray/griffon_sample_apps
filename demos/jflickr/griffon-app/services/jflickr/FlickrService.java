package jflickr;

import groovy.util.slurpersupport.Node;
import groovy.util.slurpersupport.NodeChild;
import groovyx.net.http.HttpResponseDecorator;
import groovyx.net.http.RESTClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.griffon.runtime.core.AbstractGriffonService;

public class FlickrService extends AbstractGriffonService {
    public static final String FLICKR_API_KEY = "flickr.api.key";
    private static final String FLICKR_URI = "http://api.flickr.com/services/";
    private static final Object LOCK = new Object();
    
    private RESTClient rest;
    
    public List<Photo> search(String tag) {
        List<Photo> photos = new ArrayList<Photo>();
        
        try {
            fetchPhotos(tag, photos);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        return photos;
    }
    
    private void fetchPhotos(final String tag, List<Photo> photos) throws ClientProtocolException, IOException, URISyntaxException {
        HttpResponseDecorator response = (HttpResponseDecorator) rest().get(asMap(
                new Object[]{"path", "rest"},
                new Object[]{"query", asMap(
                        new Object[]{"api_key", getConfigValueAsString(FLICKR_API_KEY)},
                        new Object[]{"method", "flickr.photos.search"},
                        new Object[]{"tags", tag}
                )}
        ));
        NodeChild root = (NodeChild)response.getData();
        NodeChild photosNode = (NodeChild)root.children().getAt(0);
        
        int i = 0;
        for (Iterator<Node> children = photosNode.childNodes(); i < 3 && children.hasNext(); i++) {
            Node photo = children.next();
            Map<String, Object> attributes = photo.attributes();
            
            photos.add(
                new Photo(attributes.get("title").toString(),    
                    new StringBuilder("http://farm")
                        .append(attributes.get("farm"))
                        .append(".static.flickr.com/")
                        .append(attributes.get("server"))
                        .append("/")
                        .append(attributes.get("id"))
                        .append("_")
                        .append(attributes.get("secret"))
                        .append(".jpg").toString()
            ));
        }
    }

    private RESTClient rest() throws URISyntaxException {
        synchronized (LOCK) {
            if (rest == null) {
                rest = new RESTClient();
                rest.setUri(FLICKR_URI);
            }
            return rest;
        }
    }
    
    private Map<String, Object> asMap(Object[]... keyValues) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        
        for (Object[] pair : keyValues) {
            map.put(String.valueOf(pair[0]), pair[1]);
        }
        
        return map;
    }
    
    private String getConfigValueAsString(String key) {
        return getApp().getConfig().get(key).toString();
    }
}
