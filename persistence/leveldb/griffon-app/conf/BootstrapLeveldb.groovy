import org.iq80.leveldb.DB

import sample.Person

class BootstrapLeveldb {
    def init = { String databaseName, DB db ->
        def people = [
            [id: 1, name: 'Danno',     lastname: 'Ferrin'],
            [id: 2, name: 'Andres',    lastname: 'Almiray'],
            [id: 3, name: 'James',     lastname: 'Williams'],
            [id: 4, name: 'Guillaume', lastname: 'Laforge'],
            [id: 5, name: 'Jim',       lastname: 'Shingler'],
            [id: 6, name: 'Alexander', lastname: 'Klein'],
            [id: 7, name: 'Rene',      lastname: 'Groeschke']
        ].collect([]) { data ->
             byte[] key = data.id.toString().bytes
             byte[] value = Person.toJSON(new Person(data)).bytes
             db.put(key, value)
        }
    }

    def destroy = { String databaseName, DB db ->
        (1..7).each { id ->
            byte[] key = id.toString().bytes
            db.delete(key)
        }
    }
} 
