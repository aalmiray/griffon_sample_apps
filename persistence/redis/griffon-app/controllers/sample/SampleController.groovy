package sample

import redis.clients.jedis.Jedis

class SampleController {
   def model

   def onStartupEnd = { app ->
      withRedis { String dataSourceName, Jedis jedis ->
         List<Person> tmpList = []
         jedis.keys('*').each { key ->
             tmpList << Person.fromJSON(jedis.get(key))
         } 
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
