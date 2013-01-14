package sample

import com.avaje.ebean.EbeanServer

@griffon.plugins.ebean.EbeanAware
class SampleController {
   def model

   def onStartupEnd = { app ->
      withEbean { String dataSourceName, EbeanServer ebeanServer ->
         List<Person> tmpList = []
         tmpList.addAll ebeanServer.find(Person).findList()     
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
