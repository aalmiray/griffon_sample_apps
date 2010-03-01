application {
    title='GtkApp'
    startupGroups = ['gtk-app']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "gtk-app"
    'gtk-app' {
        model = 'GtkAppModel'
        controller = 'GtkAppController'
        view = 'GtkAppView'
    }

}
