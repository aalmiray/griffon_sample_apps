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

import java.awt.Component
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.table.TableCellRenderer
import javax.swing.table.DefaultTableCellRenderer

/**
 * @author Andres Almiray
 */
class SpeakerTableCellRenderer extends JPanel implements TableCellRenderer {
    private speakerPicture
    private speakerName
    private speakerCompany
    private speakerBio
    private final TableCellRenderer rendererDelegate = new DefaultTableCellRenderer()
    private final FactoryBuilderSupport builder
   
    SpeakerTableCellRenderer(FactoryBuilderSupport builder) {
        this.builder = builder
        final self = this
        builder.panel(self) {
            migLayout(layoutConstraints: 'fill', columnConstraints: '[left][left]', rowConstraints: '[top][top]')
            self.speakerPicture = label(icon: imageIcon('/speaker-icon.gif', constraints: 'gap right 10, span 1 2'))
            self.speakerName = label('', constraints: 'grow')
            self.speakerCompany = label('', constraints: 'right, wrap')
            self.speakerBio = textArea('', opaque: false, editable: false, lineWrap: true,
                              wrapStyleWord: true, constraints: 'grow, span 2')
        }
    }

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        def widget = rendererDelegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)

        border = widget.border
        speakerPicture.icon = builder.imageIcon(url: value.imageURI.toURL())
        speakerName.text = value.firstName +' '+ value.lastName
        speakerCompany.text = value.company
        speakerBio.text = value.bio

        [speakerName, speakerCompany, speakerBio].each { w ->
            w.font = widget.font
            w.foreground = widget.foreground
            w.background = widget.background
        }

        table.setRowHeight(row, Math.max(150, preferredSize.height) as int)

        return this
    }
}
