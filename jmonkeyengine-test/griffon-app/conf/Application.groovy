application {
    title='J'
    startupGroups = ['j']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "j"
    'j' {
        model = 'JModel'
        controller = 'JController'
//        view = 'JView'
    }

}

jme.simpleGameDelegate = "MySimpleGameDelegate"
