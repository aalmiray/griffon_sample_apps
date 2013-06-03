import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex

class BootstrapBlueprints {
    def init = { String graphName = 'default', Graph graph ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             Vertex vertex = graph.addVertex(data.id)
             data.each { key, value -> if(key == 'id') return; vertex.setProperty(key, value) }
        }
    }

    def destroy = { String graphName = 'default', Graph graph ->
    }
}