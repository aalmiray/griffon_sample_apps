import org.apache.pivot.wtk.skin.CardPaneSkin

updateCardPane = {
    cardPane1.styles.put("sizeToSelection", sizeToSelectionCheckbox.selected)

    if(crossfadeRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.CROSSFADE)
    } else if(horizontalSlideRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.HORIZONTAL_SLIDE)
    } else if(verticalSlideRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.VERTICAL_SLIDE)
    } else if(horizontalFlipRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.HORIZONTAL_FLIP)
    } else if(verticalFlipRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.VERTICAL_FLIP)
    } else if(zoomRadioButton.selected) {
        cardPane1.styles.put("selectionChangeEffect", CardPaneSkin.SelectionChangeEffect.ZOOM)
    } else {
        cardPane1.styles.put("selectionChangeEffect", null)
    }
}

checkboxStateAdapter = buttonStateListener {
    onStateChanged { button, previousState ->
        updateCardPane()
    }
}

radioButtonStateAdapter = buttonStateListener {
    onStateChanged { button, previousState ->
        if(button.selected) updateCardPane()
    }
}

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
                            cardPane(id: "cardPane1") {
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
                            noparent{ cardPane1.selectedIndex = 0 }
                        }
                    }
                }
                tablePaneRow() {
                   separator()
                }
                tablePaneRow() {
                    hbox(styles: "{horizontalAlignment:'center'}") {
                        linkButton(id: "previousButton", "Previous", buttonPressed: {cardPane1.selectedIndex -= 1})
                        linkButton(id: "nextButton", "Next", buttonPressed: {cardPane1.selectedIndex += 1})
                    }
                }
            }
        }
        border(styles: "{padding:2}") {
            vbox(styles: "{padding:4, spacing:6}") {
                checkbox(id: "sizeToSelectionCheckbox", "Size to selection") { buttonStateListener(checkboxStateAdapter) }
                label("Selection change effect:")
                buttonGroup(id: "selectionChangeEffect")
                radioButton(id: "crossfadeRadioButton", "Crossfade", selected: true, buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "horizontalSlideRadioButton", "Horizontal Slide", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "verticalSlideRadioButton", "Vertical Slide", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "horizontalFlipRadioButton", "Horizontal Flip", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "verticalFlipRadioButton", "Vertical Flip", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "zoomRadioButton", "Zoom", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
                radioButton(id: "noneRadioButton", "None", buttonGroup: selectionChangeEffect) {
                    buttonStateListener(radioButtonStateAdapter)
                }
            }
        }
    }
}
