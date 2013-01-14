package sample

@griffon.plugins.hibernate3.Hibernate3Aware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withHibernate3 { String dataSourceName, session ->
         List<Person> tmpList = []
         tmpList.addAll session.createQuery('from Person').list() 
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
