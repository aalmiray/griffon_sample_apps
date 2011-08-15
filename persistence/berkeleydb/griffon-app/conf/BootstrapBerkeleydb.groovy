import com.sleepycat.je.Environment
import sample.Person

class BootstrapBerkeleydb {
    def init = { Environment env ->
        env.withEntityStore(id: 'person') { store, txn ->
            Person.Accessor personAccesor = new Person.Accessor(store)
            [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
             [id: 2, name: 'Andres',    lastname: 'Almiray'],
             [id: 3, name: 'James',     lastname: 'Williams'],
             [id: 4, name: 'Guillaume', lastname: 'Laforge'],
             [id: 5, name: 'Jim',       lastname: 'Shingler'],
             [id: 6, name: 'Alexander', lastname: 'Klein'],
             [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
                Person person = new Person()
                data.each { propName, propValue ->
                    person[propName] = propValue
                }
                personAccesor.save(person)
            }
        }
    }

    def destroy = { Environment env ->
    }
} 
