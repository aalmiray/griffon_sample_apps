package sample

import com.tinkerpop.blueprints.Graph

class SampleController {
   def model

   def onStartupEnd = { app ->
      withBlueprints { String databaseName, Graph graph ->
         List<Person> tmpList = []
         graph.vertices.each { vertex ->
             if (!vertex.hasProperty('id')) return
             tmpList << new Person(
                 id: vertex.id as int,
                 name: vertex.getProperty('name'),
                 lastname: vertex.getProperty('lastname')
             )
         }     
         execInsideUIAsync { model.people.addAll tmpList }
      }
   }
}
