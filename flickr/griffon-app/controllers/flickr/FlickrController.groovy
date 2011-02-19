package flickr

class FlickrController {
    def model
    def view
    def builder
    private String apikey

    void mvcGroupInit(Map args) {
        apikey = app.class.classLoader.getResource('flickr.key').text.trim()
    }

    def search = {
        model.busy = true
        try {
            withRest(id: 'flickr', uri: 'http://api.flickr.com/services/') {
                def response = get(path: 'rest', query: [api_key: apikey, method: 'flickr.photos.search', tags: model.tag])
                int count = 0
                List urls = []
                for(photo in response.data.photos.photo) {
                    if(count++ == 10) break 
                    urls << "http://farm${photo.@farm}.static.flickr.com/${photo.@server}/${photo.@id}_${photo.@secret}.jpg".toURL()
                }

                def images = urls.collect([]) { url ->
                    println url
                    def image = builder.with {
                        return scrollPane {
                            label(icon: imageIcon(url: url), toolTipText: url)
                        }
                    }
                }
                execAsync {
                    view.photos.removeAll()
                    images.eachWithIndex { image, i ->
                        view.photos.add("image $i".toString(), image)
                    }
                }
            }
        } finally {
            execAsync { model.busy = false }
        }
    }

    @Threading(Threading.Policy.SKIP)
    def showPrevious = {
        view.photos.layout.previous(view.photos)
    }

    @Threading(Threading.Policy.SKIP)
    def showNext = {
        view.photos.layout.next(view.photos)
    }
}
