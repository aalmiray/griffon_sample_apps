package sample

import prefuse.data.Graph
import prefuse.data.io.GraphMLReader

class SampleController {
    def view

    void onReadyEnd(GriffonApplication app) {
        Graph socialNetwork = new GraphMLReader().readGraph('/socialnet.xml')
        view.visualization.with {
            removeGroup 'graph'
            add 'graph', socialNetwork
            run 'color'
            run 'layout'
        }
    }
}
