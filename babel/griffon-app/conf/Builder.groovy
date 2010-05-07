root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'ClojureGriffonAddon'.addon=true

root.'ErlangGriffonAddon'.addon=true
