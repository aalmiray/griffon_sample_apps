import groovy.swing.SwingBuilder
import griffon.util.GriffonPlatformHelper
import static griffon.util.GriffonApplicationUtils.*

GriffonPlatformHelper.tweakForNativePlatform(app)
SwingBuilder.lookAndFeel((isMacOSX ? 'system' : 'nimbus'), 'gtk', ['metal', [boldFonts: false]])