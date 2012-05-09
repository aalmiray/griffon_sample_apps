package sample

import com.basho.riak.client.RiakClient

class SampleController {
   def model

   def onStartupEnd = { app ->
      withRiak { String clientName, RiakClient riak ->
         List<Person> tmpList = []
         riak.listBucket('people').bucketInfo.keys.each { key ->
             tmpList << Person.fromJSON(riak.fetch('people', key).object.value)
         }     
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
