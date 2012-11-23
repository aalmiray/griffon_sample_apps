import org.infinispan.manager.EmbeddedCacheManager
import org.infinispan.Cache

class BootstrapInfinispan {
    def init = { String cacheManagerName, EmbeddedCacheManager cacheManager ->
        Cache people = cacheManager.getCache('people')
        [[id: '1', name: 'Danno',     lastname: 'Ferrin'],
         [id: '2', name: 'Andres',    lastname: 'Almiray'],
         [id: '3', name: 'James',     lastname: 'Williams'],
         [id: '4', name: 'Guillaume', lastname: 'Laforge'],
         [id: '5', name: 'Jim',       lastname: 'Shingler'],
         [id: '6', name: 'Alexander', lastname: 'Klein'],
         [id: '7', name: 'Rene',      lastname: 'Groeschke']].each { data ->
             people.put(data.id, data)
        }
    }

    def destroy = { String cacheManagerName, EmbeddedCacheManager cacheManager ->
    }
}