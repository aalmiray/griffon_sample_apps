application {
    title='DemoConsole'
    startupGroups = ['DemoConsole']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "DemoConsole"
    'DemoConsole' {
        model = 'DemoConsoleModel'
        controller = 'DemoConsoleController'
        view = 'DemoConsoleView'
    }

}
