import com.orientechnologies.orient.core.record.impl.ODocument

class BootstrapOrientdb {
    def init = { String databaseName, orient ->
        def people = [
            [id: 1, name: 'Danno',     lastname: 'Ferrin'],
            [id: 2, name: 'Andres',    lastname: 'Almiray'],
            [id: 3, name: 'James',     lastname: 'Williams'],
            [id: 4, name: 'Guillaume', lastname: 'Laforge'],
            [id: 5, name: 'Jim',       lastname: 'Shingler'],
            [id: 6, name: 'Alexander', lastname: 'Klein'],
            [id: 7, name: 'Rene',      lastname: 'Groeschke']
        ].collect([]) { data ->
             ODocument person = new ODocument(orient, 'Person')
             data.each { key, value -> person[key] = value }
             person
        }
        orient.withTransaction { people*.save() }
    }

    def destroy = { String databaseName, orient ->
        orient.withTransaction {
            for(ODocument person : orient.browseClass('Person')) {
                person.delete()
            }
        }
    }
} 