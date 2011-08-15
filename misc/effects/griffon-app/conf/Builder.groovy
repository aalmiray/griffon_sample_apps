root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'griffon.builder.trident.TridentBuilder'.view = '*'
root.'TransitionsGriffonAddon'.addon=true
root.'EffectsGriffonAddon'.addon=true
root.'MiglayoutGriffonAddon'.addon=true
