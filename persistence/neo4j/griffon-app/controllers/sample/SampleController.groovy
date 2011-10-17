package sample

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Transaction

class SampleController {
   def model

   def onStartupEnd = { app ->
      withNeo4j { String databaseName, GraphDatabaseService db, Transaction tx ->
         List<Person> tmpList = []
         db.allNodes.each { node ->
             if(!node.hasProperty('id')) return
             tmpList << new Person(
                 id: node.getProperty('id'),
                 name: node.getProperty('name'),
                 lastname: node.getProperty('lastname')
             )
         }     
         execSync { model.people.addAll tmpList }
      }
   }
}
