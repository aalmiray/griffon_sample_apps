import org.apache.pivot.wtk.Orientation
import org.apache.pivot.wtk.HorizontalAlignment
import org.apache.pivot.wtk.VerticalAlignment

bsl = buttonStateListener {
    onStateChanged { b, ps ->
        Orientation orientation = null
        if(horizontalOrientationButton.selected) {
            orientation = Orientation.HORIZONTAL
        } else if(verticalOrientationButton.selected) {
            orientation = Orientation.VERTICAL
        }
        if(orientation) boxPane1.orientation = orientation

        HorizontalAlignment horizontalAlignment = null
        if(horizontalAlignmentLeftButton.selected) {
            horizontalAlignment = HorizontalAlignment.LEFT
        } else if(horizontalAlignmentRightButton.selected) {
            horizontalAlignment = HorizontalAlignment.RIGHT
        } else if(horizontalAlignmentCenterButton.selected) {
            horizontalAlignment = HorizontalAlignment.CENTER
        }
        if(horizontalAlignment) boxPane1.styles.put("horizontalAlignment", horizontalAlignment)

        VerticalAlignment verticalAlignment = null
        if(verticalAlignmentTopButton.selected) {
            verticalAlignment = VerticalAlignment.TOP
        } else if(verticalAlignmentBottomButton.selected) {
            verticalAlignment = VerticalAlignment.BOTTOM
        } else if(verticalAlignmentCenterButton.selected) {
            verticalAlignment = VerticalAlignment.CENTER
        }
        if(verticalAlignment) boxPane1.styles.put("verticalAlignment", verticalAlignment)

        boxPane1.styles.put("fill", fillCheckbox.selected)
    }
}

tablePane {
    tablePaneColumn(width: 300)
    tablePaneColumn(width: -1)
    tablePaneRow(height: -1) {
        border(styles: "{padding: 6, color: '#999999'}") {
            hbox(id: 'boxPane1') {
                button('One')
                button('Two')
                button('Three')
            }
        }
        vbox(styles: '{padding: 6, spacing: 8, fill: true}') {
            buttonGroup(id: "orientation")
            buttonGroup(id: "horizontalAlignment")
            buttonGroup(id: "verticalAlignment")
            label("Orientation", styles: "{font:{bold:true}}")
            radioButton(id: "horizontalOrientationButton", "Horizontal", buttonGroup: orientation, selected: true) { buttonStateListener(bsl) }
            radioButton(id: "verticalOrientationButton", "Vertical", buttonGroup: orientation) { buttonStateListener(bsl) }

            label("Horizontal Alignment", styles: "{font:{bold:true}}")
            radioButton(id: "horizontalAlignmentLeftButton", "Left", buttonGroup: horizontalAlignment, selected: true) { buttonStateListener(bsl) }
            radioButton(id: "horizontalAlignmentRightButton", "Right", buttonGroup: horizontalAlignment) { buttonStateListener(bsl) }
            radioButton(id: "horizontalAlignmentCenterButton", "Center", buttonGroup: horizontalAlignment) { buttonStateListener(bsl) }

            label("Vertical Alignment", styles: "{font:{bold:true}}")
            radioButton(id: "verticalAlignmentTopButton", "Top", buttonGroup: verticalAlignment, selected: true) { buttonStateListener(bsl) }
            radioButton(id: "verticalAlignmentBottomButton", "Bottom", buttonGroup: verticalAlignment) { buttonStateListener(bsl) }
            radioButton(id: "verticalAlignmentCenterButton", "Center", buttonGroup: verticalAlignment) { buttonStateListener(bsl) }

            hbox(styles: "{padding:{top:8}}") {
                checkbox(id: "fillCheckbox", "Fill") { buttonStateListener(bsl) }
            }
        }
    }
}
