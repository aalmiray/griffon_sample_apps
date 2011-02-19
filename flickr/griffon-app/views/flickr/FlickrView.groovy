package flickr

actions {
   action(id: 'searchAction',
      name: 'Search',
      enabled: bind('tag', source: model, converter: {!GriffonNameUtils.isBlank(it)}),
      closure: controller.search)
   action(id: 'previousAction',
      name: '<<',
      closure: controller.showPrevious)
   action(id: 'nextAction',
      name: '>>',
      closure: controller.showNext)
}

application(title: 'flickr',
  pack: true, 
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
            imageIcon('/griffon-icon-32x32.png').image,
            imageIcon('/griffon-icon-16x16.png').image]) {
   busyComponent(busy: bind{model.busy}) {
      panel {
         migLayout(layoutConstraints: 'fill', rowConstraints: 'top')
         label 'Tag'
         textField columns: 30, constraints: 'growx', text: bind('tag', target: model)
         button(searchAction, constraints: 'right, wrap')
         panel(constraints: 'span 3, grow') {
            migLayout(layoutConstraints: 'fill', rowConstraints: 'top')
            button(previousAction, constraints: 'left')
            button(nextAction, constraints: 'right, wrap')
            panel(id: 'photos', constraints: 'span 2, grow') {
               transitionLayout()
            }
         }
      }
   }
   swingRepaintTimeline(photos, loop: true)
}
