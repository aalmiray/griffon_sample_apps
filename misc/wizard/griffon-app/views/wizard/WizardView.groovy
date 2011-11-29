package wizard

actions {
    action(backAction,
        enabled: bind { model.backEnabled })
}

application(title: 'Wizard',
  preferredSize: [320, 240],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill')
    panel(id: 'wizardContainer', constraints: 'grow, span 2, wrap') {
        cardLayout()
    }
    button(backAction, constraints: 'left')
    button(nextAction, constraints: 'right')
    
    keyStrokeAction(component: current.rootPane,
        keyStroke: 'ESCAPE',
        condition: 'in focused window',
        action: backAction)
    keyStrokeAction(component: current.rootPane,
        keyStroke: 'ENTER',
        condition: 'in focused window',
        action: nextAction)
    keyStrokeAction(component: current.rootPane,
        keyStroke: 'SPACE',
        condition: 'in focused window',
        action: nextAction)
}
