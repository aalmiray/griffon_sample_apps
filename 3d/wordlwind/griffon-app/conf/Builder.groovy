root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'WorldwindGriffonAddon'.addon=true
root.'JoglCompatGriffonAddon'.addon=true
