package devoxx

import org.hybird.list.Cell

class SpeakerCell extends Cell {
    final FactoryBuilderSupport builder
    private container
    private picture
    private title
    private bio 

    SpeakerCell(FactoryBuilderSupport builder) {
        this.builder = builder
    }

    void setValue(value) {
        if(!container) {
            def self = this
            container = builder.panel(opaque: true) {
                migLayout(layoutConstraints: 'fill', rowConstraints: '[top, 10%][top, 90%]')
                self.picture = label(icon: imageIcon('/speaker-icon.gif'), constraints: 'span 1 2, top')
                self.title = label('', constraints: 'left, wrap')
                self.bio = textArea('', lineWrap: true, wrapStyleWord: true, editable: true,
                                    opaque: true, constraints: 'top, growx', rows: 4)
            }
            add(container)
        }

        title.text = value.firstName +' '+ value.lastName +' ('+ value.company + ')'
        bio.text = value.bio.trim()
    }
}
