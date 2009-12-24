application {
    title='Pivot Demo'
    startupGroups = ['p']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "p"
    'p' {
        model = 'PModel'
        controller = 'PController'
        view = 'PView'
    }

}
