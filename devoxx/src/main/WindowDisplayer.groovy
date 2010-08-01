import java.awt.Window
import griffon.swing.SwingUtils
import griffon.swing.DefaultWindowDisplayHandler
import griffon.core.GriffonApplication
import griffon.effects.Effects

class WindowDisplayer extends DefaultWindowDisplayHandler {
    void show(Window window, GriffonApplication app) {
        SwingUtils.centerOnScreen(window)
        app.execOutside {
            Effects.appear(window, duration: 2000, wait: true)
        }
    }

/*
    void hide(Window window, GriffonApplication app) {
        app.execOutside {
            Effects.dropOut(window, wait: true)
        }
    }
*/
}
