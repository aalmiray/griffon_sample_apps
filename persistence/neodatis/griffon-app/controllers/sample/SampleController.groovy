package sample

import org.neodatis.odb.ODB

@griffon.plugins.neodatis.NeodatisAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withOdb { String databaseName, ODB odb ->
         def tmpList = odb.query(Person).objects()
         execInsideUIAsync { model.people.addAll(tmpList) }
      }
   }
}
