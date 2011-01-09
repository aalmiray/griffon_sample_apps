package jzy3d

application(title: 'jzy3d',
  size: [600,600],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    widget(chart3d.chart.canvas, constraints: CENTER)
    panel(constraints: EAST) {
        gridLayout(cols: 1, rows: 10)
        (1..10).each { i-> button("Button $i") }
    }
}
