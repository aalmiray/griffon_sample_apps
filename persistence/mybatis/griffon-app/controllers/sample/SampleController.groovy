package sample

import org.apache.ibatis.session.SqlSession
import sample.mappers.PersonMapper

class SampleController {
   def model

   def onStartupEnd = { app ->
      withSqlSession { String dataSourceName, SqlSession session ->
         PersonMapper personMapper = session.getMapper(PersonMapper)
         List<Person> tmpList = []
         tmpList.addAll personMapper.list()
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
