root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'MiglayoutGriffonAddon'.addon=true



jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'JxlayerGriffonAddon'.addon=true


root.'RestGriffonAddon'.addon=true

root.'JbusyComponentGriffonAddon'.addon=true

root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'TransitionsGriffonAddon'.addon=true
