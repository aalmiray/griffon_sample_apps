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

root.'MybatisGriffonAddon'.addon=true

root.'GlazedlistsGriffonAddon'.addon=true
