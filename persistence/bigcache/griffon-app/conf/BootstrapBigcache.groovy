import org.bigcache.BigCacheManager
import org.bigcache.BigCache
import sample.Person

class BootstrapBigcache {
    def init = { String bigcacheManagerName, BigCacheManager bcm ->
        List data = [
            [id: 1, name: 'Danno',     lastname: 'Ferrin'],
            [id: 2, name: 'Andres',    lastname: 'Almiray'],
            [id: 3, name: 'James',     lastname: 'Williams'],
            [id: 4, name: 'Guillaume', lastname: 'Laforge'],
            [id: 5, name: 'Jim',       lastname: 'Shingler'],
            [id: 6, name: 'Alexander', lastname: 'Klein'],
            [id: 7, name: 'Rene',      lastname: 'Groeschke']
        ]

        BigCache people = bcm.getCache('people')
        data.each { chunk ->
             people.put(chunk.id, new Person(chunk))
        }
        BigCache peopleIds = bcm.getCache('peopleIds')
        peopleIds.put('ids', data.id)
    }

    def destroy = { String bigcacheManagerName, BigCacheManager bcm ->
        bcm.getCache('people').evictAll()
        bcm.getCache('peopleIds').evictAll()
    }
} 