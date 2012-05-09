package sample

import org.iq80.leveldb.DB

class SampleController {
    def model

    def onStartupEnd = { app ->
        withLeveldb { String databaseName, DB db ->
            def tmpList = db.collect([]) { entry ->
                Person.fromJSON(new String(entry.value))
            }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
