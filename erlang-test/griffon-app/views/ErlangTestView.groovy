application(title:'erlang-test',
  pack:true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    gridLayout(cols: 2, rows: 5)
    label('Server:')
    textField(columns: 20, text: bind(target: model, targetProperty: 'server'), editable: bind{model.serverEnabled})
    label('Num1:')
    textField(columns: 20, text: bind(target: model, targetProperty: 'num1'))
    label('Num2:')
    textField(columns: 20, text: bind(target: model, targetProperty: 'num2'))
    label('Result:')
    label(text: bind{model.result})
    button('Calculate', enabled: bind{model.enabled}, actionPerformed: controller.calculate)
}
