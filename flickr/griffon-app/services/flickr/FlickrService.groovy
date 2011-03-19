package flickr

class FlickrService {
    static final String FLICKR_API_KEY = 'flickr.api.key'
    static final String FLICKR_URI = 'http://api.flickr.com/services/'
    
    List search(String tag) {
        List photos = []
        withRest(id: 'flickr', uri: FLICKR_URI) {
            def response = get(path: 'rest', query: [api_key: app.config[FLICKR_API_KEY], 
                    method: 'flickr.photos.search',
                    tags: tag])
            int count = 0
            for(photo in response.data.photos.photo) {
                if(count++ == 10) break 
                def url = "http://farm${photo.@farm}.static.flickr.com/${photo.@server}/${photo.@id}_${photo.@secret}.jpg".toURL()
                photos << [
                    tooltip: "<html>${photo.@title}<br/>${url}</html>",
                    url: url
                ]
            }
            photos
        }
    }
}