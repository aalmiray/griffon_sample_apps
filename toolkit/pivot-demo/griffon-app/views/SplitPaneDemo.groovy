splitPane(id: "splitPane1", orientation: "horizontal", splitRatio: 0.6f) {
    border(styles: "{padding:6}") {
        imageView(image: "IMG_0725_2.jpg", styles: "{fill:true}")
    }
    border {
        vbox(styles: "{padding:6, spacing:8, fill:true}") {
            buttonGroup(id: "orientation") {
                buttonGroupListener {
                    onSelectionChanged { buttonGroup, previousSelection ->
                        def selection = buttonGroup.selection
                        if(selection == horizontalOrientationButton) {
                           splitPane1.setOrientation("horizontal")
                        } else {
                           splitPane1.setOrientation("vertical")
                        }
                    }
                }
            }

            label("Orientation", styles: "{font:{bold:true}}")
            radioButton(id: "horizontalOrientationButton", "Horizontal", buttonGroup: orientation, selected: true)
            radioButton(id: "verticalOrientationButton", "Vertical", buttonGroup: orientation)
            separator()

            checkbox("Use Shadow") {
                buttonStateListener {
                    onStateChanged { button, previousState ->
                        splitPane1.styles.put("useShadow", button.selected)
                    }
                }
            }
        }
    }
}
