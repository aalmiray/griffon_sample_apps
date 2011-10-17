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

root.'Neo4jGriffonAddon'.addon=true
