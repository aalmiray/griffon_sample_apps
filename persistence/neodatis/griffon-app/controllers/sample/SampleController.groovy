package sample

import org.neodatis.odb.ODB

class SampleController {
   def model

   def onStartupEnd = { app ->
      withOdb { String databaseName, ODB odb ->
         def tmpList = odb.query(Person).objects()
         execInsideUIAsync { model.people.addAll(tmpList) }
      }
   }
}
