package sample

import com.sleepycat.persist.EntityStore
import com.sleepycat.persist.EntityCursor

class SampleController {
   def model

   def onStartupEnd = { app ->
      withEntityStore(id: 'person') { EntityStore store, txn ->
         Person.Accessor personAccessor = new Person.Accessor(store)
         List<Person> tmpList = []
         EntityCursor<Person> cursor = personAccessor.list()
         try {
             for(Iterator<Person> iterator = cursor.iterator(); iterator.hasNext(); ) {
                 tmpList << iterator.next()
             }
         } finally {
             cursor.close()
         }
         
         execSync { model.people.addAll tmpList }
      }
   }
}