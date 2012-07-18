package sample

import org.bigcache.BigCacheManager
import org.bigcache.BigCache

class SampleController {
   def model

   def onStartupEnd = { app ->
      withBigcache { String bcmName, BigCacheManager bcm ->
         BigCache people = bcm.getCache('people')
         List<Person> tmpList = bcm.getCache('peopleIds').get('ids').collect([]) { id ->
             people.get(id)
         }
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
