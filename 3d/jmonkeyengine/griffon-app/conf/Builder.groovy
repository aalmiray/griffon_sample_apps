root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'LwjglGriffonAddon'.addon=true
root.'JmonkeyengineGriffonAddon'.addon=true
