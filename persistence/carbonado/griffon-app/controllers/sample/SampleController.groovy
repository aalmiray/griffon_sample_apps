package sample

import com.amazon.carbonado.Repository
import com.amazon.carbonado.Storage
import com.amazon.carbonado.Cursor

class SampleController {
   def model

   def onStartupEnd = { app ->
      withCarbonado { Repository repository ->
         List<Person> tmpList = []
         Storage<Person> people = repository.storageFor(Person)
         Cursor<Person> peopleCursor = people.query().fetch()
         while(peopleCursor.hasNext()) { tmpList << peopleCursor.next() }
         
         edt { model.people.addAll(tmpList) }
      }
   }
}
