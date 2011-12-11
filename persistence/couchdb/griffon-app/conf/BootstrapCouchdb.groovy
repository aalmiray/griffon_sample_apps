import org.jcouchdb.db.Database
import org.jcouchdb.document.*
import sample.Person

class BootstrapCouchdb {
    def init = { Database db, String databaseName -> 
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             db.createDocument data
        }
    }

    def destroy = { Database db, String databaseName ->
        ViewResult<Map> result = db.listDocuments(null, null)
        result.rows.each { row ->
            db.delete(row.id, row.value.rev)
        }
    }
} 
