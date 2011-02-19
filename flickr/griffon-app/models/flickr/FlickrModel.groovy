package flickr

import groovy.beans.Bindable

class FlickrModel {
    @Bindable String tag
    @Bindable boolean busy = false
}
