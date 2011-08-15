application {
    title='Stardust'
    startupGroups = ['stardust']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "stardust"
    'stardust' {
        model = 'StardustModel'
        controller = 'StardustController'
        view = 'StardustView'
    }

}
