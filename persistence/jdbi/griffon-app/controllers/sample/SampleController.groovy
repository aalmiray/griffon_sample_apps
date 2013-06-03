package sample

import org.skife.jdbi.v2.DBI

@griffon.plugins.jdbi.JdbiAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withJdbi { String datasourceName, DBI dbi ->
         PersonDAO dao = dbi.open(PersonDAO)
         List tmpList = dao.list()
         execInsideUIAsync { model.peopleList.addAll(tmpList) }
      }
   }
}
