package sample

import com.gmongo.GMongo

class SampleController {
    def model

    def onStartupEnd = { app ->
        withMongodb { String databaseName, GMongo mongo ->
            def tmpList = []    
            def db = mongo.getDB('sample')
            def cursor = db.people.find()
            while(cursor.hasNext()) {
                def person = cursor.next()
                tmpList << [id: person.id, name: person.name, lastname: person.lastname]
            }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
