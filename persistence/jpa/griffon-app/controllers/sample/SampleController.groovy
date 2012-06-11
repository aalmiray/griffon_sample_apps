package sample

import javax.persistence.EntityManager
import javax.persistence.Query

class SampleController {
   def model

   def onStartupEnd = { app ->
      withJpa { String persistenceUnit, EntityManager em ->
         List<Person> tmpList = []
         tmpList.addAll em.createQuery('select p from Person p').resultList
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
