application {
    title = 'Bomb'
    startupGroups = ['bomb']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "dialog"
    'dialog' {
        model = 'bomb.DialogModel'
        controller = 'bomb.DialogController'
        view = 'bomb.DialogView'
    }

    // MVC Group for "bomb"
    'bomb' {
        model = 'bomb.BombModel'
        controller = 'bomb.BombController'
        view = 'bomb.BombView'
    }

}
