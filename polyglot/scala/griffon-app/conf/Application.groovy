application {
    title = 'ScalaApp'
    startupGroups = ['scala_app']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "scala-test"
    'scala_app' {
        model = 'app.scala.ScalaModel'
        controller = 'app.scala.ScalaController'
        view = 'app.scala.ScalaView'
    }

}
