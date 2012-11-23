package sample

import org.infinispan.manager.EmbeddedCacheManager
import org.infinispan.Cache

class SampleController {
    def model

    def onStartupEnd = { app ->
        withInfinispan { String cacheManagerName, EmbeddedCacheManager cacheManager ->
            Cache people = cacheManager.getCache('people')
            List tmpList = people.keySet().sort().collect([]) { key -> people.get(key) }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
