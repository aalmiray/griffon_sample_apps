application(title: 'gtk-app', width: 320, height: 240,
            icon: pixbuf('griffon-icon-24x24.png')) {
    vbox {
        label(label: 'Enter some text below')
        entry(onChanged: { source -> model.input = source.text })
        button(label: 'Click me!', onClicked: controller.copyText)
        entry(id: 'output', editable: false)
    }
}
