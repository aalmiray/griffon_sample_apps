package sample

import terrastore.client.TerrastoreClient

class SampleController {
   def model

   def onStartupEnd = { app ->
      withTerrastore { String clientName, TerrastoreClient client ->
         List<Person> tmpList = []
         tmpList.addAll client.bucket('people').values().get(Person).values()
         execSync { model.people.addAll tmpList }
      }
   }
}
