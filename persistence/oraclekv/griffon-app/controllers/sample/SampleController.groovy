package sample

import oracle.kv.*

class SampleController {
   def model

   def onStartupEnd = { app ->
      withOraclekv { String storeName, KVStore store ->
         List<Person> tmpList = store.storeIterator(Direction.UNORDERED, 7).collect([]) { kvv ->
             String json = new String(kvv.value.value)
             Person.fromJSON(json)
         }   
         execSync { model.people.addAll tmpList }
      }
   }
}
