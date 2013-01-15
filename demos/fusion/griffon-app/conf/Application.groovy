application {
    title = 'Fusion'
    startupGroups = ['fusion']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "fusion"
    'fusion' {
        model      = 'fusion.FusionModel'
        view       = 'fusion.FusionView'
        controller = 'fusion.FusionController'
    }
}