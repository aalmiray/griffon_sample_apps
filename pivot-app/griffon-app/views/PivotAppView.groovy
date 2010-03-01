application(title: "pivot-app", maximized: true) {
    vbox(styles: "{horizontalAlignment:'center', verticalAlignment:'center'}") {
        label( 'Enter some text below')
        textInput(textChanged: { source -> model.input = source.text })
        button('Click me!', buttonPressed: controller.copyText)
        textInput(id: 'output', enabled: false)
    }
}
