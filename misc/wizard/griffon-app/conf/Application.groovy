application {
    title = 'Wizard'
    startupGroups = ['wizard']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "page3"
    'page3' {
        model      = 'wizard.Page3Model'
        view       = 'wizard.Page3View'
    }

    // MVC Group for "page2"
    'page2' {
        model      = 'wizard.Page2Model'
        view       = 'wizard.Page2View'
    }

    // MVC Group for "page1"
    'page1' {
        model      = 'wizard.Page1Model'
        view       = 'wizard.Page1View'
    }

    // MVC Group for "wizard"
    'wizard' {
        model      = 'wizard.WizardModel'
        view       = 'wizard.WizardView'
        controller = 'wizard.WizardController'
    }
}
