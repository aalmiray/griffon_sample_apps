import static flickr.FlickrService.FLICKR_API_KEY

onBootstrapEnd = { app ->
    app.config[FLICKR_API_KEY] = app.class.classLoader.getResource('flickr.key').text.trim()
}