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
import java.awt.Component
import java.awt.Dimension
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.table.TableCellRenderer
import javax.swing.table.DefaultTableCellRenderer

/**
 * @author Andres Almiray
 */
class PresentationTableCellRenderer extends JPanel implements TableCellRenderer {
    private presentationExperience
    private presentationTitle
    private presentationSpeaker
    private presentationTrack
    private presentationType
    private presentationSummary
    private final TableCellRenderer rendererDelegate = new DefaultTableCellRenderer()
    private final FactoryBuilderSupport builder
   
    PresentationTableCellRenderer(FactoryBuilderSupport builder) {
        this.builder = builder
        final self = this
        Map speakersType = Constants.TYPES.speakers
        Map presentationsType = Constants.TYPES.presentations

        builder.panel(self, opaque: true) {
            migLayout(layoutConstraints: 'fill', columnConstraints: '[][left][right]', rowConstraints: '[top][top][top]')
            self.presentationExperience = label(opaque: false, icon: imageIcon('/transparent-16x16.png'))
            self.presentationTitle = textArea('', opaque: false, editable: false, lineWrap: true,
                wrapStyleWord: true, constraints: 'grow')
            self.presentationType = label('', opaque: false, constraints: 'wrap')

            label(icon: crystalIcon(size: 16, category: speakersType.icon.category, icon: speakersType.icon.name))
            self.presentationSpeaker = label('', opaque: false)
            self.presentationTrack = label('', opaque: false, constraints: 'wrap')

            label(opaque: false, icon: imageIcon('/transparent-16x16.png'))
            self.presentationSummary = textArea('', opaque: false, editable: false, lineWrap: true,
                wrapStyleWord: true, constraints: 'grow, span 2')
        }
    }

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        def widget = rendererDelegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)

        Map exp = Constants.EXPERIENCE[value.experience.toLowerCase()]

        border = widget.border
        presentationExperience.icon = builder.crystalIcon(size: '16', category: exp.icon.category, icon: exp.icon.name)
        presentationTitle.text = value.title
        presentationSpeaker.text = value.speaker
        presentationTrack.text = value.track
        presentationType.text = value.type
        presentationSummary.text = value.summary

        [presentationTitle, presentationSpeaker, presentationTrack, presentationType, presentationSummary].each { w ->
            w.font = widget.font
            w.foreground = widget.foreground
            w.background = widget.background
        }
       
        table.setRowHeight(row, Math.max(110, preferredSize.height) as int)

        return this
    }
}
