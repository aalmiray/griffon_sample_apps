import net.sf.ehcache.CacheManager
import net.sf.ehcache.Cache
import net.sf.ehcache.Element

class BootstrapEhcache {
    def init = { String cacheManagerName, CacheManager cacheManager ->
        Cache people = cacheManager.getCache('people')
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             people.put(new Element(data.id, data))
        }
    }

    def destroy = { String cacheManagerName, CacheManager cacheManager ->
    }
}