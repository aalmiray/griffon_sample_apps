root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'DatasourceGriffonAddon'.addon=true

root.'GsqlGriffonAddon'.addon=true

root.'GlazedlistsGriffonAddon'.addon=true
