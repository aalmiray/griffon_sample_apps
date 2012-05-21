package sample

class SampleController {
   def model

   def onStartupEnd = { app ->
      withHibernate4 { String dataSourceName, session ->
         List<Person> tmpList = []
         tmpList.addAll session.createQuery('from Person').list() 
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
