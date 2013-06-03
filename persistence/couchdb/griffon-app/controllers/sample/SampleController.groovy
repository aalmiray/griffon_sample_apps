package sample

import org.jcouchdb.db.Database
import org.jcouchdb.document.*

@griffon.plugins.couchdb.CouchdbAware
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
            execInsideUIAsync { model.people.addAll tmpList }
        }
    }
}
