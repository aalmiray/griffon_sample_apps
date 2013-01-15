package fusion

import static java.awt.FlowLayout.TRAILING
import griffon.plugins.theme.*

actions {
   action(id: 'changeToBlackAction',
      name: 'Black Theme',
      enabled: bind(ThemeManager.CURRENT_THEME_PROP,
                    source: ThemeManagerHolder.themeManager,
                    converter: { v -> v != FusionModel.BLACK_THEME }),
      closure: controller.changeTheme)
   action(id: 'changeToRedAction',
      name: 'Red Theme',
      enabled: bind(ThemeManager.CURRENT_THEME_PROP,
                    source: ThemeManagerHolder.themeManager,
                    converter: { v -> v != FusionModel.RED_THEME }),
      closure: controller.changeTheme)
}

application(title: 'Fusion',
  preferredSize: [400, 300],
  pack: true,
  resizable: false,
  locationByPlatform: true,
  iconImage:   imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    contentPanel(constraints: CENTER) {
        borderLayout()
        headerPanel(constraints: NORTH)
        titleLabel( constraints: CENTER, text: 'Griffon')
        footerPanel(constraints: SOUTH)
    }
    panel(constraints: SOUTH) {
        flowLayout(alignment: TRAILING)
        button(changeToBlackAction)
        button(changeToRedAction)
    }
}