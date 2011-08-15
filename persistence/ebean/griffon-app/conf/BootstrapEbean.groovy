import com.avaje.ebean.EbeanServer
import sample.Person

class BootstrapEbean {
    def init = { String dataSourceName, EbeanServer ebeanServer ->
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
            ebeanServer.save(person)
        }
    }

    def destroy = { String dataSourceName, EbeanServer ebeanServer ->
    }
} 
