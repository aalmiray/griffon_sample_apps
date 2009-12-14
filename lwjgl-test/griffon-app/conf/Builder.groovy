root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'LwjglGriffonAddon'.addon=true

root.'griffon.builder.trident.TridentBuilder'.view = '*'
