package app.scala

application(title: 'scala-test',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    gridLayout(cols: 1, rows: 3)
    textField(columns: 20, text: bind('input', target: model))
    button('Copy', actionPerformed: controller.&copy)
    textField(columns: 20, editable: false, text: bind{model.output})
}
