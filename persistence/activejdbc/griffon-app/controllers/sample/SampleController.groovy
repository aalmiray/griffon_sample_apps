package sample

@griffon.plugins.activejdbc.ActivejdbcAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withActivejdbc { String dataSourceName ->
         List<Person> tmpList = []
         tmpList.addAll(Person.findAll())       
         execInsideUIAsync { model.people.addAll(tmpList) }
      }
   }
}
