package sample

import net.sf.ehcache.CacheManager
import net.sf.ehcache.Cache
import net.sf.ehcache.Element

@griffon.plugins.ehcache.EhcacheAware
class SampleController {
    def model

    def onStartupEnd = { app ->
        withEhcache { String cacheManagerName, CacheManager cacheManager ->
            Cache people = cacheManager.getCache('people')
            List tmpList = people.keys.collect([]) { key -> people.get(key).value }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
