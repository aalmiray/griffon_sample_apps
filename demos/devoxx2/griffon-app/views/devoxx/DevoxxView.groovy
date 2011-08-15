package devoxx

import java.awt.Color
import java.awt.Font
import griffon.transitions.FadeTransition2D

model.loader.catalogs = imageIcon('/applications-system.gray.png')
model.loader.speakers = imageIcon('/system-users.gray.png')
model.loader.presentations = imageIcon('/x-office-presentation.gray.png')
model.loader.schedule = imageIcon('/x-office-calendar.gray.png')

actions {
    def type = Constants.TYPES.speakers
    action(id: 'speakerAction',
        shortDescription: type.description,
        smallIcon: tangoIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'speakers')})
    type = Constants.TYPES.presentations
    action(id: 'presentationAction',
        shortDescription: type.description,
        smallIcon: tangoIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'presentations')})
    type = Constants.TYPES.schedule
    action(id: 'scheduleAction',
        shortDescription: type.description,
        smallIcon: tangoIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'schedule')})
}

application(title: 'Devoxx 2010',
  size: [640,480], undecorated: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    current.contentPane.background = Color.BLACK
    main = current.contentPane
    transitionLayout(defaultDuration: 2000, defaultTransition: new FadeTransition2D(Color.BLACK))

    panel(constraints: 'splash', opaque: false) {
        migLayout(layoutConstraints: 'fill', columnConstraints: 'center', rowConstraints: 'center')
        label(icon: imageIcon('/Devoxx2K10.png'))
    }

    panel(constraints: 'loader', opaque: false) {
        migLayout(layoutConstraints: 'fill', columnConstraints: 'center', rowConstraints: 'center')
        panel(opaque: false) {
            migLayout(layoutConstraints: '')
            label('Loading', constraints: 'center, span 4, wrap',
                  foreground: Color.WHITE, font: new Font('Helvetica', Font.BOLD, 32))
            label(icon: bind{model.loader.catalogs}, constraints: 'center')
            label(icon: bind{model.loader.speakers}, constraints: 'center')
            label(icon: bind{model.loader.presentations}, constraints: 'center')
            label(icon: bind{model.loader.schedule}, constraints: 'center')
        }
    }

    panel(constraints: 'main', opaque: false) {
        migLayout(layoutConstraints: 'fill', rowConstraints: '[top][bottom]')
        panel(id: 'content', opaque: false, constraints: 'grow, wrap') {
            transitionLayout(defaultDuration: 2000, defaultTransition: new FadeTransition2D(Color.BLACK))
            ['speakers', 'presentations', 'schedule'].each { type ->
                def (m, v, c) = [null, null, null]
                noparent {
                    (m, v, c) = createMVCGroup(type)
                }
                widget(v.box, constraints: type, opaque: false)
            }
        }
        panel(constraints: 'left', opaque: false) {
            gridLayout(cols: 3, rows: 1)
            button(speakerAction, constraints: 'left')
            button(presentationAction, constraints: 'left')
            button(scheduleAction, constraints: 'left')
        }
    }

    swingRepaintTimeline(main, loop: true)
}
