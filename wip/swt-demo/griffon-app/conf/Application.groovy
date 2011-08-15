application {
    title='S'
    startupGroups = ['s']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "s"
    's' {
        model = 'SModel'
        controller = 'SController'
        view = 'SView'
    }

}
