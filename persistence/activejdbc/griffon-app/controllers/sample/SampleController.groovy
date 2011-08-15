package sample

class SampleController {
   def model

   def onStartupEnd = { app ->
      withActivejdbc { String dataSourceName ->
         List<Person> tmpList = []
         tmpList.addAll(Person.findAll())       
         execSync { model.people.addAll(tmpList) }
      }
   }
}
