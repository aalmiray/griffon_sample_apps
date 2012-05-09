package sample

class SampleController {
    def model

    def onStartupEnd = { app ->
        withCql { dsName, sql ->
            def tmpList = []
            sql.eachRow('SELECT * FROM people') {
                tmpList << [id: it.KEY,
                    name: it.name,
                    lastname: it.lastname]
            }
            execInsideUIAsync { model.peopleList.addAll(tmpList) }
        }
    }
}
