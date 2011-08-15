root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'SpringGriffonAddon'.addon=true
root.'ActivemqGriffonAddon'.addon=true
root.'JmsGriffonAddon'.addon=true
