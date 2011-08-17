package sample

application(title: 'JEuclid',
  preferredSize: [400, 400],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    tabbedPane(id: 'tabs', tabPlacement: JTabbedPane.TOP)
}
