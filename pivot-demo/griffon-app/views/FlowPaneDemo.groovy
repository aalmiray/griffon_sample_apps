import org.apache.pivot.wtk.HorizontalAlignment

bsl = buttonStateListener {
    onStateChanged { b, ps ->
        HorizontalAlignment alignment = null
        if(leftRadioButton.selected) {
            alignment = HorizontalAlignment.LEFT
        } else if(rightRadioButton.selected) {
            alignment = HorizontalAlignment.RIGHT
        } else if(centerRadioButton.selected) {
            alignment = HorizontalAlignment.CENTER
        }

        if(alignment) fp.styles.put("alignment", alignment)
        fp.styles.put("alignToBaseline", alignToBaselineCheckbox.selected)
    }
}

splitPane(splitRatio: 0.75f) {
    border(styles: '{padding:4}') {
        vbox(styles: '{fill:true}') {
            flowPane(id: 'fp', styles: '{padding:2}') {
                baselineDecorator()
                button('0', styles: '{minimumAspectRatio:1.5}')
                button('1', styles: '{minimumAspectRatio:1.5}')
                button('2', styles: '{minimumAspectRatio:1.5}')
                button('3', preferredWidth: 20, preferredHeight: 20)
                button('4', preferredWidth: 30, preferredHeight: 30)
                button('5', preferredWidth: 40, preferredHeight: 40)
                button('6', styles: '{minimumAspectRatio:1.5}')
                button('7', styles: '{minimumAspectRatio:1.5}')
            }
        }
    }
    border(styles: '{padding:{top:2, left:6}}') {
        vbox {
            label(text: 'Alignment', styles: '{font:{bold:true}}')
            buttonGroup(id: 'alignment')
            radioButton('Left', id: 'leftRadioButton', buttonGroup: alignment, selected: true) { buttonStateListener(bsl) }
            radioButton('Right', id: 'rightRadioButton', buttonGroup: alignment) { buttonStateListener(bsl) }
            radioButton('Center', id: 'centerRadioButton', buttonGroup: alignment) { buttonStateListener(bsl) }
            hbox(styles: '{padding:{top:6}}') {
                checkbox('Align to baseline', id: 'alignToBaselineCheckbox') { buttonStateListener(bsl) }
            }
        }
    }
} 
