package jflickr;

import org.codehaus.griffon.runtime.core.AbstractGriffonModel;

public class JflickrModel extends AbstractGriffonModel {
    private String tag;
    private boolean busy;
    
    public static final String PROP_TAG = "tag";
    public static final String PROP_BUSY = "busy";
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        firePropertyChange(PROP_TAG, this.tag, this.tag = tag);
    }
    
    public boolean isBusy() {
        return busy;
    }
    
    public void setBusy(boolean busy) {
        firePropertyChange(PROP_BUSY, this.busy, this.busy = busy);
    }    
}
