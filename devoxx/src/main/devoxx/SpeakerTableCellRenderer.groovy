package devoxx

import java.awt.Component
import javax.swing.JTable
import javax.swing.JPanel
import javax.swing.table.TableCellRenderer
import javax.swing.table.DefaultTableCellRenderer

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
            migLayout(layoutConstraints: 'fill', columnConstraints: '[left][left, grow]')
            self.speakerPicture = label(icon: imageIcon('/speaker-icon.gif', constraints: 'top, gap left 5, span 1 2'))
            self.speakerName = label('', constraints: 'top, grow')
            self.speakerCompany = label('', constraints: 'top, right, wrap')
            self.speakerBio = textArea('', opaque: false, editable: false, lineWrap: true,
                              wrapStyleWord: true, constraints: 'top, grow, span 2')
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
