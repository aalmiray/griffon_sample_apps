package sample

@griffon.plugins.hibernate4.Hibernate4Aware
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
