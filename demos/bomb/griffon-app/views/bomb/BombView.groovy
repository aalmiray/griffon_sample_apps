package bomb

actions {
    action(id: 'action1',
        name: "There's a hidden bug in this app...",
        smallIcon: nuvolaIcon('bug', category: 'apps'),
        closure: controller.buggyAction)
}

application(title: 'Exception Handler Test',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    button(action1)
}