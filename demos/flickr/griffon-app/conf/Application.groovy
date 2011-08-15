application {
    title = 'Flickr'
    startupGroups = ['flickr']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "flickr"
    'flickr' {
        model = 'flickr.FlickrModel'
        controller = 'flickr.FlickrController'
        view = 'flickr.FlickrView'
    }

}
