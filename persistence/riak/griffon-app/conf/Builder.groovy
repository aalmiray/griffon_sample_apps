root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'GlazedlistsGriffonAddon'.addon=true

root.'RiakGriffonAddon'.addon=true
