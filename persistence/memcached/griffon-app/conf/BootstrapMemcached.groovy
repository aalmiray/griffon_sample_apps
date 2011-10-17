import net.spy.memcached.MemcachedClient
import sample.Person

class BootstrapMemcached {
    def init = { String clientName, MemcachedClient client ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             String json = Person.toJSON(new Person(data))
             def r = client.set(data.id.toString(), 3600i, json)
        }
    }

    def destroy = { String clientName, MemcachedClient client ->
        (1..7).toList()*.toString().each { key ->
            client.delete(key)
        }
    }
} 
