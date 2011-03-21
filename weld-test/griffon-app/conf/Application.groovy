application {
    title = 'Weld'
    startupGroups = ['weld']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "weld"
    'weld' {
        model = 'weld.WeldModel'
        controller = 'weld.WeldController'
        view = 'weld.WeldView'
    }

}
