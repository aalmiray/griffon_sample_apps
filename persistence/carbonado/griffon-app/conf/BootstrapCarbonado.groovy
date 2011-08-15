import sample.Person
import com.amazon.carbonado.Repository
import com.amazon.carbonado.Storage

class BootstrapCarbonado {
    def init = { Repository repository ->
        Storage<Person> people = repository.storageFor(Person)
        [[id: 1, name: 'Danno',     lastName: 'Ferrin'],
         [id: 2, name: 'Andres',    lastName: 'Almiray'],
         [id: 3, name: 'James',     lastName: 'Williams'],
         [id: 4, name: 'Guillaume', lastName: 'Laforge'],
         [id: 5, name: 'Jim',       lastName: 'Shingler'],
         [id: 6, name: 'Josh',      lastName: 'Reed']].each { data ->
            Person person = people.prepare()
            data.each { propName, propValue ->
                person[propName] = propValue
            }
            person.insert()
        }
    }
    
    def destroy = { Repository repository ->
    }
} 
