package weld

application(title: 'Weld Example',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    vbox {
        button 'Click me!', actionPerformed: controller.clickAction
        textField columns: 20, editable: false, text: bind{model.action}
    }
}
