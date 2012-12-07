package login

import java.awt.Color

actions {
    action(loginAction, enabled: bind{ model.enabled })
}

application(title: 'Some title', pack:true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill')

    bannerPanel(constraints: 'span 2, growx, wrap',
      title: 'Login',
      subtitle: 'Please enter your credentials',
      titleIcon: imageIcon('/griffon-icon-48x48.png'),
      border: lineBorder(color: Color.BLACK, thickness: 1),
      subTitleColor: Color.WHITE,
      background: new Color(0,0,0,1),
      startColor: Color.WHITE,
      endColor: Color.BLACK,
      vertical: true)

    label 'Username:', constraints: 'left'
    textField columns: 20, text: bind('username', target: model), constraints: 'wrap'
    label 'Password:', constraints: 'left'
    passwordField columns: 20, text: bind('password', target: model), constraints: 'wrap'
    button loginAction, constraints: 'span 2, right'
}
