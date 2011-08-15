application {
    title='N'
    startupGroups = ['n']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "n"
    'n' {
        model = 'NModel'
        controller = 'NController'
        view = 'NView'
    }

}

griffon.neo4j.injectInto = ['controller']
