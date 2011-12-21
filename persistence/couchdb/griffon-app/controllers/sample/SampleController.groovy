package sample

import org.jcouchdb.db.Database
import org.jcouchdb.document.*

class SampleController {
    def model

    def onStartupEnd = { app ->
        withCouchdb { String databaseName, Database db ->
            List<Person> tmpList = []
            ViewResult<Map> result = db.listDocuments(null, null)
            result.rows.each { row ->
                Map json = db.getDocument(Map, row.id)

                tmpList << new Person(
                    id: json.id,
                    name: json.name,
                    lastname: json.lastname)
            }
            execSync { model.people.addAll tmpList }
        }
    }
}
