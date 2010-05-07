application {
    title='Babel'
    startupGroups = ['babel']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "calculator"
    'calculator' {
        model = 'CalculatorModel'
        controller = 'CalculatorController'
        view = 'CalculatorView'
    }

    // MVC Group for "babel"
    'babel' {
        model = 'BabelModel'
        view = 'BabelView'
        controller = 'BabelController'
    }

}

griffon.clojure.dynamicPropertyName = "clj"
griffon.clojure.injectInto = ["controller"]
