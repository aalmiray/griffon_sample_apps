/*
 * Copyright (c) 2010 Devoxx Schedule app - Andres Almiray. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Effects - Andres Almiray nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 'AS IS'
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package devoxx

import java.awt.Color
import java.awt.Font
import griffon.transitions.FadeTransition2D

/**
 * @author Andres Almiray
 */

model.loader.catalogs = imageIcon('/settings-gray.png')
model.loader.speakers = imageIcon('/speakers-gray.png')
model.loader.presentations = imageIcon('/presentations-gray.png')
model.loader.schedule = imageIcon('/schedule-gray.png')

actions {
    def type = Constants.TYPES.speakers
    action(id: 'speakerAction',
        shortDescription: type.description,
        smallIcon: crystalIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'speakers')})
    type = Constants.TYPES.presentations
    action(id: 'presentationAction',
        shortDescription: type.description,
        smallIcon: crystalIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'presentations')})
    type = Constants.TYPES.schedule
    action(id: 'scheduleAction',
        shortDescription: type.description,
        smallIcon: crystalIcon(size: 32, category: type.icon.category, icon: type.icon.name),
        closure: {content.layout.show(content, 'schedule')})
}

application(title: 'Devoxx 2010',
  size: [800,600], undecorated: true,
  locationByPlatform:true, resizable: false,
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
        toolBar(constraints: 'left', floatable: false, opaque: false) {
            button(speakerAction, constraints: 'left')
            button(presentationAction, constraints: 'left')
            button(scheduleAction, constraints: 'left')
        }
    }

    swingRepaintTimeline(main, id: 'mainTimeline', loop: true)
}
