package devoxx

import javax.swing.*
import ca.odell.glazedlists.swing.JEventListPanel

class SpeakerListPanelFormat extends JEventListPanel.AbstractFormat {
    final FactoryBuilderSupport builder

    SpeakerListPanelFormat(FactoryBuilderSupport builder) {
        super('2dlu, t:p, 2dlu, t:p:g, 2dlu', '2dlu, l:p, 4dlu, f:p:g, 2dlu',  null, null,
              ['2, 2, 1, 3, center, top', '4, 2', '4, 4'] as String[])
        this.builder = builder
    }

    JComponent getComponent(Object element, int component) {
        switch(component) {
            case 0: return builder.label(icon: builder.imageIcon('/speaker-icon.gif'))
            case 1: return builder.label(element.firstName +' '+ element.lastName +' ('+ element.company + ')')
            case 2: return builder.textArea(lineWrap: true, wrapStyleWord: true, editable: false,
                                            opaque: false, text: element.bio)
        }
    }
}
