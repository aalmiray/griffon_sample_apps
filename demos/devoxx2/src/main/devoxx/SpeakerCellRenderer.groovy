package devoxx

import java.awt.Component
import javax.swing.JComponent
import javax.swing.DefaultListCellRenderer
import javax.swing.JList
import javax.swing.SwingConstants

class SpeakerCellRenderer extends DefaultListCellRenderer {
    final FactoryBuilderSupport builder
    final component
    private picture
    private title
    private bio 

    SpeakerCellRenderer(FactoryBuilderSupport builder) {
        this.builder = builder
        def self = this
        component = builder.panel(opaque: true) {
            migLayout(layoutConstraints: 'fill', rowConstraints: '[top, 10%][top, 90%]')
            self.picture = label(icon: imageIcon('/speaker-icon.gif'), constraints: 'span 1 2, top')
            self.title = label('', constraints: 'left, wrap')
            label ''
            // self.bio = textArea('', lineWrap: true, wrapStyleWord: true, editable: true,
            //                     opaque: true, constraints: 'top, growx', rows: 4)
        }
    }

    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        def cell = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)

        component.border = cell.border 
        component.foreground = cell.foreground 
        title.text = value.firstName +' '+ value.lastName +' ('+ value.company + ')'
        // bio.text = value.bio.size() < 200 ? value.bio : (value.bio[0..200] + ' ...')
        // bio.text = value.bio.trim()

        component
    }
}
