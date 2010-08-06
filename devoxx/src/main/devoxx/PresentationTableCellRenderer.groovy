package devoxx

import java.awt.Color
import java.awt.Component
import java.awt.Dimension
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.table.TableCellRenderer
import javax.swing.table.DefaultTableCellRenderer

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
