application {
    title = 'Jzy3d'
    startupGroups = ['jzy3d']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "jzy3d"
    'jzy3d' {
        model = 'jzy3d.Jzy3dModel'
        controller = 'jzy3d.Jzy3dController'
        chart3d = 'jzy3d.SampleChart3D'
        view = 'jzy3d.Jzy3dView'
    }
}
