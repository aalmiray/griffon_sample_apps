application {
    title='ErlangTest'
    startupGroups = ['erlang-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "erlang-test"
    'erlang-test' {
        model = 'ErlangTestModel'
        controller = 'ErlangTestController'
        view = 'ErlangTestView'
    }

}
