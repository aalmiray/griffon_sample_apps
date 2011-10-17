package sample

import net.spy.memcached.MemcachedClient

class SampleController {
   def model

   def onStartupEnd = { app ->
      withMemcached { String clientName, MemcachedClient client ->
         List<Person> tmpList = []
         Collection<String> keys = (1..7).toList()*.toString() 
         client.getBulk(keys).each { key, data ->
             tmpList << Person.fromJSON(data)
         }   
         execSync { model.people.addAll tmpList }
      }
   }
}
