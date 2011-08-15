root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'RestGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'JxlayerGriffonAddon'.addon=true


root.'MiglayoutGriffonAddon'.addon=true



root.'JbusyComponentGriffonAddon'.addon=true

root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'TransitionsGriffonAddon'.addon=true
