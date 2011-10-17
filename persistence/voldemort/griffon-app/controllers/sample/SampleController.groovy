package sample

import voldemort.client.StoreClient

class SampleController {
   def model

   def onStartupEnd = { app ->
      withVoldemortStore('people') { String clientName, String storeName, StoreClient store ->
         List<Person> tmpList = []
         (1..7).toList()*.toString().each { key ->
            tmpList << new Person(store.get(key).value[-1])
         }
         execSync { model.people.addAll tmpList }
      }
   }
}
