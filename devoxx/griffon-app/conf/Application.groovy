application {
    title = 'Devoxx'
    startupGroups = ['devoxx']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "schedule"
    'schedule' {
        model = 'devoxx.ScheduleModel'
        controller = 'devoxx.ScheduleController'
        view = 'devoxx.ScheduleView'
    }

    // MVC Group for "presentations"
    'presentations' {
        model = 'devoxx.PresentationsModel'
        controller = 'devoxx.PresentationsController'
        view = 'devoxx.PresentationsView'
    }

    // MVC Group for "speakers"
    'speakers' {
        model = 'devoxx.SpeakersModel'
        controller = 'devoxx.SpeakersController'
        view = 'devoxx.SpeakersView'
    }

    // MVC Group for "devoxx"
    'devoxx' {
        model = 'devoxx.DevoxxModel'
        controller = 'devoxx.DevoxxController'
        view = 'devoxx.DevoxxView'
    }

}
