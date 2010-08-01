package devoxx

class DevoxxController {
    def builder
    def model
    def view
    def devoxxService

    def onWindowShown = { window ->
        def loader = jxwithWorker(start: false) {
            onInit{}
            work {
                [catalogs: ['tracks', 'rooms', 'experiencelevels'],
                 speakers: null, presentations: null, schedule: null].each { type, values ->
                    def subject = values ?: [type]
                    subject.each { devoxxService."$it" }
                    publish type  
                }
            }
            onUpdate { chunks ->
                chunks.each { type ->
                    String category = Constants.TYPES[type].icon.category
                    String icon = Constants.TYPES[type].icon.name
                    model.loader[type] = builder.crystalIcon(size: 32, category: category, icon: icon)
                }
            }
            onDone {
                ['speakers', 'presentations', 'schedule'].each { type ->
                    app.models[type].update()
                }
                view.main.layout.next(view.main)
            }
        }

        // pause so that splash can be seen
        Thread.sleep 3000
        // display loader screen
        view.main.layout.next(view.main)
        // wait for transition to finish
        Thread.sleep 1500
        loader.execute()
    }
}
