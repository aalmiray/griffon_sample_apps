application(title: 'Babel',
  size: [300, 200],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   borderLayout()
   tabbedPane id: 'tabGroup', constraints: CENTER
}
