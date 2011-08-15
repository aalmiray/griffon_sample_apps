application {
    title = 'Forkjoin'
    startupGroups = ['forkjoin']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "forkjoin"
    'forkjoin' {
        model = 'forkjoin.ForkjoinModel'
        controller = 'forkjoin.ForkjoinController'
        view = 'forkjoin.ForkjoinView'
    }

}
