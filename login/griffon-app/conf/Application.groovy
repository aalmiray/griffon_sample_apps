application {
    title = 'Login'
    startupGroups = ['login']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "login"
    'login' {
        model = 'login.LoginModel'
        controller = 'login.LoginController'
        view = 'login.LoginView'
    }

}
