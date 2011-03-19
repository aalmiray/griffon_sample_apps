package flickr

class FlickrController {
    def model
    def view
    def builder
    def flickrService

    def searchAction = {
        model.busy = true
        try {
            List photos = flickrService.search(model.tag)

            def images = photos.collect([]) { photo ->
                def image = builder.with {
                    return scrollPane {
                        label(icon: imageIcon(url: photo.url), toolTipText: photo.tooltip)
                    }
                }
            }
            execAsync {
                view.photos.removeAll()
                images.eachWithIndex { image, i ->
                    view.photos.add("image $i".toString(), image)
                }
            }
        } finally {
            execAsync { model.busy = false }
        }
    }
}