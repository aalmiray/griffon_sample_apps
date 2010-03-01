application {
    title='SwingApp'
    startupGroups = ['swing-app']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "swing-app"
    'swing-app' {
        model = 'SwingAppModel'
        controller = 'SwingAppController'
        view = 'SwingAppView'
    }

}
