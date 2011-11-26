package sample

import prefuse.Constants
import prefuse.action.*
import prefuse.action.assignment.*
import prefuse.action.layout.graph.*
import prefuse.activity.Activity
import prefuse.render.DefaultRendererFactory
import prefuse.util.ColorLib
import prefuse.visual.VisualItem

application(title: 'Prefuse + Griffon',
  preferredSize: [720, 520],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    pfdisplay(size: [720, 500], drag: true, pan: true, zoom: true) {
        pfvisualization(id: 'visualization') {
            pfgraph(id: 'graph') {
                current.addColumn 'name', String
                current.addColumn 'gender', String
            }
        }
        
        noparent {
            def palette = [ColorLib.rgb(255,180,180), ColorLib.rgb(190,190,255)] as int[]
            ActionList color = new ActionList()
            color.add new DataColorAction('graph.nodes', 'gender',
                    Constants.NOMINAL, VisualItem.FILLCOLOR, palette)
            color.add new ColorAction('graph.nodes',
                    VisualItem.TEXTCOLOR, ColorLib.gray(0))
            color.add new ColorAction('graph.edges',
                    VisualItem.STROKECOLOR, ColorLib.gray(200))
        
            def layout = new ActionList(Activity.INFINITY)
            layout.add new ForceDirectedLayout('graph')
            layout.add new RepaintAction()            
            
            def lr = pflabelRenderer(textField: 'name')
            lr.setRoundedCorner(8i, 8i)
            
            visualization.with {
                setInteractive 'graph.edges', null, false
                setRendererFactory new DefaultRendererFactory(lr)
                putAction 'color', color
                putAction 'layout', layout
            }
        }
    }
}
