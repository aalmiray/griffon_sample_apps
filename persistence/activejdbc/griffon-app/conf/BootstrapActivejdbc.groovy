import sample.Person

class BootstrapActivejdbc {
    def init = { String dataSourceName ->
        [[name: 'Danno',     lastname: 'Ferrin'],
         [name: 'Andres',    lastname: 'Almiray'],
         [name: 'James',     lastname: 'Williams'],
         [name: 'Guillaume', lastname: 'Laforge'],
         [name: 'Jim',       lastname: 'Shingler'],
         [name: 'Alexander', lastname: 'Klein'],
         [name: 'Rene',      lastname: 'Groeschke']].each { data ->
            Person person = new Person()
            data.each { propName, propValue ->
                person.set(propName, propValue)
            }
            person.saveIt()
        }
    }

    def destroy = { String dataSourceName ->
    }
} 
