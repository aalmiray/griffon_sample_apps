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


root.'LwjglGriffonAddon'.addon=true
