import groovy.swing.SwingBuilder
import static griffon.util.GriffonApplicationUtils.*

SwingBuilder.lookAndFeel((isMacOSX ? 'system' : 'nimbus'), 'gtk', ['metal', [boldFonts: false]])
