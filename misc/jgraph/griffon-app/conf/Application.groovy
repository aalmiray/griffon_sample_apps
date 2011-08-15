application {
    title = 'JgraphTest'
    startupGroups = ['jgraph-test']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "jgraph-test"
    'jgraph-test' {
        model = 'jgraph.test.JgraphTestModel'
        controller = 'jgraph.test.JgraphTestController'
        view = 'jgraph.test.JgraphTestView'
    }

}
