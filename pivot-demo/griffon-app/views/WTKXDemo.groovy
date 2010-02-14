wtkxButtonPressed = { button ->
    app.alert(message: "You pressed the button with text: '${button.buttonData}'")
}

vbox {
    label('The following buttons were read from a wtkx file')
    wtkx('buttons.wtkx') {
        widget(button1) {
            buttonPressListener {
                onButtonPressed(wtkxButtonPressed)
            }
        }
        widget(button2, buttonPressed: wtkxButtonPressed)
    }
}
