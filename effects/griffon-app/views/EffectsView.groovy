import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.PushTransition2D
import java.awt.Point
import java.awt.GraphicsEnvironment
import griffon.effects.Effects

def width = 480
def height = 400

model.reset = {
    model.animating = true
    Point center = GraphicsEnvironment.localGraphicsEnvironment.centerPoint
    Effects.bounds(window, x: center.x - width/2, y: center.y - height/2,
        w: width, h: height, mode: 'absolute') { w, p ->
            model.animating = false
    }
} 

actions {
    action(id: 'previousAction',
        name: ' << ',
        enabled: bind {!model.animating},
        closure: controller.previousPage)
    action(id: 'nextAction',
        name: ' >> ',
        enabled: bind {!model.animating},
        closure: controller.nextPage)
    action(id: 'resetAction',
        name: 'Reset',
        enabled: bind {!model.animating},
        closure: model.reset)
}

application(title: 'Effects', id: 'window',
  size: [width, height], undecorated: false,
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    menuBar {
        menu('Actions') {
            menuItem(resetAction)
        }
    }

    panel {
        migLayout(layoutConstraints: 'fill',
                  columnConstraints: '2%[left 20%]2%[center]2%[right 20%]2%',
                  rowConstraints: '2%[top 10%]2%[top 10%]2%[bottom]2%')
        button(resetAction, constraints: 'grow, span 3, wrap')
        button(previousAction)
        label(text: bind{model.currentPage})
        button(nextAction, constraints: 'wrap')
        panel(id: 'panes', constraints: 'grow, span 3, wrap') {
              transitionLayout(defaultDuration: 750l, mirrorTransition: true,
                  beforeCallback: { model.animating = true },
                  afterCallback: { model.animating = false },
                  defaultTransition: new PushTransition2D(Transition2D.LEFT))
        }
        swingRepaintTimeline(panes, loop: true)
    }
}
