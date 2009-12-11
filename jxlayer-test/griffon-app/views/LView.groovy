import javax.swing.SwingConstants
import org.kordamp.jsilhouette.geom.*
import com.jhlabs.image.*

def lipsum = '''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
culpa qui officia deserunt mollit anim id est laborum.
'''

createContent = {
   scrollPane(preferredSize: [300, 300] ) {
      textArea(lineWrap: true, wrapStyleWord: true, text: lipsum*3, columns: 40)
   }
}

application(title: 'JXLayer',
  size: [460, 400],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   tabbedPane(tabPlacement: SwingConstants.LEFT) {
      panel(title: 'MouseScrollableUI') {
         borderLayout()
         jxlayer(constraints: CENTER) {
            mouseScrollableUI()
            createContent()
         }
         label('Press middle-mouse button and scroll.', constraints: SOUTH)
      }
      panel(title: 'SpotLightUI') {
         borderLayout()
         jxlayer(constraints: CENTER) {
            spotLightUI(id: 'spotLight', enabled: false) {
               bean(new Star(), cx: 150f, cy: 150f, or: 100f, ir: 50f, count: 5i)
            }
            createContent()
         }
         checkBox('SpotLight', constraints: SOUTH,
            actionPerformed: {e-> spotLight.enabled = e.source.selected})
      }
      panel(title: 'LockableUI') {
         borderLayout()
         jxlayer(constraints: CENTER) {
            lockableUI(id: 'lock') {
               bufferedImageOpEffect {
                  bean(new BlurFilter())
               }
            }
            createContent()
         }
         checkBox('Lock', constraints: SOUTH,
            actionPerformed: {e-> lock.locked = e.source.selected})
      }
      panel(title: 'JBusyComponent') {
         borderLayout()
         busyComponent(id: 'b',constraints: CENTER) {
            createContent()
         }
         checkBox('Busy', constraints: SOUTH,
            actionPerformed: {e-> b.busy = e.source.selected})
      }
   }
}
