root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'WeldGriffonAddon'.addon=true

root.'MiglayoutGriffonAddon'.addon=true

root.'I18nGriffonAddon'.addon=true

root.'ActionsGriffonAddon'.addon=true
