root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'ErlangGriffonAddon'.addon=true


root.'ClojureGriffonAddon'.addon=true

root.'MiglayoutGriffonAddon'.addon=true

root.'JythonGriffonAddon'.addon=true
