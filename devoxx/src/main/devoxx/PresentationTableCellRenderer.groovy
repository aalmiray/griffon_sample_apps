package devoxx

import java.awt.Color
import java.awt.Component
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.table.TableCellRenderer
import javax.swing.table.DefaultTableCellRenderer

class PresentationTableCellRenderer extends JPanel implements TableCellRenderer {
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
            migLayout(columnConstraints: '[left, grow][right]')
            self.presentationTitle = label('', opaque: false, constraints: 'top')
            self.presentationType = label('', opaque: false, constraints: 'top, grow, wrap')
            self.presentationSpeaker = label('', opaque: false, constraints: 'top, grow',
                icon: builder.crystalIcon(size: 16, category: speakersType.icon.category, icon: speakersType.icon.name))
            self.presentationTrack = label('', opaque: false, constraints: 'top, wrap')
            self.presentationSummary = textArea('', opaque: false, editable: false, lineWrap: true,
                wrapStyleWord: true, constraints: 'top, grow, span 2')
        }
    }

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        def widget = rendererDelegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column)

        Map exp = Constants.EXPERIENCE[value.experience.toLowerCase()]

        border = widget.border
        presentationTitle.text = value.title
        presentationTitle.icon = builder.crystalIcon(size: '16', category: exp.icon.category, icon: exp.icon.name)
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
