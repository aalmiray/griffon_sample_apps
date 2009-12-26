tablePane(styles: "{padding:8, horizontalSpacing:6}" ) {
    tablePaneColumn(width: "1*")
    tablePaneColumn()
    tablePaneRow(height: "1*") {
        border(styles: "{padding:12}") {
            tablePane(styles: "{verticalSpacing:6}") {
                tablePaneColumn(width: "1*")
                tablePaneRow(height: "1*") {
                    hbox(styles: "{horizontalAlignment:'center', verticalAlignment:'center', backgroundColor:'#cccccc'}") {
                        border(styles: "{padding:6}") {
                            cardPane(id: "cardPane") {
                                imageView(image: "IMG_0725_2.jpg")
                                imageView(image: "IMG_0735_2.jpg")
                                imageView(image: "IMG_0767_2.jpg")
                                cardPaneListener {
                                    onSelectedIndexChanged { cp, psi ->
                                        int selectedIndex = cp.selectedIndex
                                        previousButton.enabled = selectedIndex > 0
                                        nextButton.enabled = selectedIndex < cp.getLength() - 1
                                    }
                                }
                            }
                        }
                    }
                }
                tablePaneRow() {
                   separator()
                }
                tablePaneRow() {
                    hbox(styles: "{horizontalAlignment:'center'}") {
                        linkButton(id: "previousButton", "Previous")
                        linkButton(id: "nextButton", "Next")
                    }
                }
            }
        }
        border(styles: "{padding:2}") {
            vbox(styles: "{padding:4, spacing:6}") {
                checkbox(id: "sizeToSelectionCheckbox", "Size to selection")
                label("Selection change effect:")
                buttonGroup(id: "selectionChangeEffect")
                radioButton(id: "crossfadeRadioButton", "Crossfade", selected: true, buttonGroup: selectionChangeEffect)
                radioButton(id: "horizontalSlideRadioButton", "Horizontal Slide", buttonGroup: selectionChangeEffect)
                radioButton(id: "verticalSlideRadioButton", "Vertical Slide", buttonGroup: selectionChangeEffect)
                radioButton(id: "horizontalFlipRadioButton", "Horizontal Flip", buttonGroup: selectionChangeEffect)
                radioButton(id: "verticalFlipRadioButton", "Vertical Flip", buttonGroup: selectionChangeEffect)
                radioButton(id: "zoomRadioButton", "Zoom", buttonGroup: selectionChangeEffect)
                radioButton(id: "noneRadioButton", "None", buttonGroup: selectionChangeEffect)
            }
        }
    }
}

