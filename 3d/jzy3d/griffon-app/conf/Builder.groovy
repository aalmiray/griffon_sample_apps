root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'JoglCompatGriffonAddon'.addon=true
root.'Jzy3dGriffonAddon'.addon=true
