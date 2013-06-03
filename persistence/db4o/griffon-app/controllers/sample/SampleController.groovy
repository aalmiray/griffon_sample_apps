package sample

@griffon.plugins.db4o.Db4oAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withDb4o { dataSourceName, db4o ->
         def tmpList = db4o.query(Person)
         execInsideUIAsync { model.people.addAll(tmpList) }
      }
   }
}
