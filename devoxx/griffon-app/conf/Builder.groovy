root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

root.'LookandfeelGriffonAddon'.addon=true
root.'LookandfeelJtattooGriffonAddon'.addon=true
root.'griffon.builder.trident.TridentBuilder'.view = '*'
root.'EffectsGriffonAddon'.addon=true
root.'TransitionsGriffonAddon'.addon=true
root.'GlazedlistsGriffonAddon'.addon=true
root.'RestGriffonAddon'.addon=true
root.'MiglayoutGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
        controller = ['withWorker']
    }
}

root.'griffon.builder.swingxtras.SwingxtrasBuilder'.view = '*'

root.'JGoodiesFormsGriffonAddon'.addon=true

root.'CrystaliconsGriffonAddon'.addon=true
