import com.gmongo.GMongo

class BootstrapMongodb {
    def init = { String databaseName, GMongo mongo ->
        def db = mongo.getDB('sample')
        db.people.drop()
        
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             db.people << data
        }
    }

    def destroy = { String databaseName, GMongo mongo ->
    }
} 
