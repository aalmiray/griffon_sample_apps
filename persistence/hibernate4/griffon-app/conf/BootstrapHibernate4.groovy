import org.hibernate.Session
import sample.Person

class BootstrapHibernate4 {
    def init = { String dataSourceName, Session session ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
            session.save(new Person(data))
        }
    }

    def destroy = { String dataSourceName, Session session ->
    }
} 
