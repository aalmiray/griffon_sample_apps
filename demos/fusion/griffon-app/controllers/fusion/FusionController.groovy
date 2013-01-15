package fusion

import griffon.plugins.theme.ThemeManagerHolder
import static fusion.FusionModel.*

class FusionController {
    def changeTheme = {
        String currentTheme = ThemeManagerHolder.themeManager.currentTheme
        String nextTheme = currentTheme != BLACK_THEME ? BLACK_THEME : RED_THEME
        ThemeManagerHolder.themeManager.currentTheme = nextTheme
        execInsideUISync { app.windowManager.windows*.repaint() }
    }
}