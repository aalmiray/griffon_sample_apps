formSubmitter = buttonPressListener {
    onButtonPressed { button ->
        String lastName = lastNameTextInput.text
        String firstName = firstNameTextInput.text

        def flag = null
        if(lastName.length() == 0 || firstName.length() == 0) {
            flag = formFlag(message: "Name is required.")
        }

        nameBoxPane.setFormFlag(flag)

        if(!flag) {
            errorLabel.text = null
            app.prompt(message: "Pretending to submit...")
        } else {
            errorLabel.text = "Some required information is missing."
        }
    }
}

border(styles: '{padding: 6}') {
    tablePane {
        tablePaneColumn(width: "1*")
        tablePaneRow(height: "1*") {
            form(styles: '{rightAlignLabels: true}') {
                formSection {
                    hbox(id: 'nameBoxPane', formLabel: 'Name') {
                        textInput(id: 'lastNameTextInput', prompt: 'Last')
                        textInput(id: 'firstNameTextInput', prompt: 'First')
                    }
                }
                formSection(heading:' Addresses') {
                    vbox(formLabel: 'Home') {
                        textInput(prompt: 'Street', textSize: 24)
                        hbox {
                            textInput(prompt: 'City')
                            textInput(prompt: 'State', textSize: 6)
                            textInput(prompt: 'Zip', textSize: 10)
                        }
                    }
                    vbox(formLabel: 'Work') {
                        textInput(prompt: 'Street', textSize: 24)
                        hbox {
                            textInput(prompt: 'City')
                            textInput(prompt: 'State', textSize: 6)
                            textInput(prompt: 'Zip', textSize: 10)
                        }
                    }
                }
                formSection(heading:' Phone Numbers') {
                    textInput(formLabel: 'Home')
                    textInput(formLabel: 'Work')
                }
                formSection(heading:' Email Addresses') {
                    textInput(formLabel: 'Home')
                    textInput(formLabel: 'Work')
                }
            }
        }
        tablePaneRow(height: -1) {
            separator()
        }
        tablePaneRow(height: -1) {
            tablePane {
                tablePaneColumn(width: "1*")
                tablePaneColumn(width: "-1")
                tablePaneRow {
                    hbox(styles: "{verticalAlignment: 'center'}"){
                        label(id: 'errorLabel', styles: "{color: '#ff0000'}")
                    }
                    hbox(styles: "{horizontalAlignment: 'right', verticalAlignment: 'center'}"){
                        button(id: 'submitButton', 'Submit', styles: '{minimumAspectRatio: 3}') {
                            buttonPressListener(formSubmitter)
                        }
                    }
                }
            }
        }
    }
}
