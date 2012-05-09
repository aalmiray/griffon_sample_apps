package sample

class SampleController {
    def model

    def onStartupEnd = { app ->
        withOrientdb { String databaseName, orient ->
            def tmpList = orient.browseClass('Person').collect([]) { person ->
                new Person(
                    id:       person.id,
                    name:     person.name,
                    lastname: person.lastname
                )
            }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
