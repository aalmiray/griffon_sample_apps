application {
    title = 'Jflickr'
    startupGroups = ['jflickr']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "jflickr"
    'jflickr' {
        model = 'jflickr.JflickrModel'
        controller = 'jflickr.JflickrController'
        view = 'jflickr.JflickrView'
    }

}
