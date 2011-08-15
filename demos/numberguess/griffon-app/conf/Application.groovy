application {
    title = 'NumberGuess'
    startupGroups = ['numberGuess']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "numberGuess"
    'numberGuess' {
        model      = 'org.jboss.weld.environment.se.example.numberguess.NumberGuessModel'
        controller = 'org.jboss.weld.environment.se.example.numberguess.NumberGuessController'
        view       = 'org.jboss.weld.environment.se.example.numberguess.NumberGuessView'
    }
}
