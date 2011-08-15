package sample

class SampleController {
   def model

   def onStartupEnd = { app ->
      withSql { dsName, sql ->
         def tmpList = []
         sql.eachRow('SELECT * FROM people') {
            tmpList << [id: it.id,
                        name: it.name,
                        lastname: it.lastname]
         }
         execSync { model.peopleList.addAll(tmpList) }
      }
   }
}
