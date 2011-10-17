import redis.clients.jedis.Jedis
import sample.Person

class BootstrapRedis {
    def init = { String datasourceName, Jedis jedis -> 
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             jedis.set(data.id.toString(), Person.toJSON(new Person(data)))
        }
    }

    def destroy = { String datasourceName, Jedis jedis ->
        jedis.del( *([1, 2, 3, 4, 5, 6, 7]*.toString()))
    }
} 
