import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Transaction
import org.neo4j.graphdb.Node

class BootstrapNeo4j {
    def init = { String databaseName, GraphDatabaseService db, Transaction tx -> 
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             Node node = db.createNode()
             data.each { key, value -> node.setProperty(key, value) }
        }
    }

    def destroy = { String databaseName, GraphDatabaseService db, Transaction tx ->
        db.allNodes.each { node -> node.delete() }
    }
} 
