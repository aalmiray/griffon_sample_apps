application {
    title='SwtApp'
    startupGroups = ['swt-app']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "swt-app"
    'swt-app' {
        model = 'SwtAppModel'
        controller = 'SwtAppController'
        view = 'SwtAppView'
    }

}
