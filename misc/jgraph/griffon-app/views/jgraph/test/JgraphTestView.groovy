package jgraph.test

application(title: 'jgraph-test',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    graphComponent {
        graph {
            applyGraphStyle('STAR')
            def v1 = insertVertex(defaultParent, null, 'Groovy', 20, 20, 80, 80, 'STAR')
            def v2 = insertVertex(defaultParent, null, 'cool!', 200, 150, 80, 30)
            insertEdge(defaultParent, null, 'is', v1, v2)
        }
    }
}
