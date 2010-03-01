application(title:'swing-app',
  size:[320,480],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    vbox {
        label('Enter some text below')
        textField(text: bind(target: model, targetProperty: 'input'))
        button('Click me!', actionPerformed: controller.copyText)
        textField(text: bind{ model.output }, editable: false)
    }
}
