import fusion.widgets.*
import fusion.widgets.factory.WidgetFactory

root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
}

features {
    factories = [
        root: [
            contentPanel: new WidgetFactory(ContentPanel),
            headerPanel:  new WidgetFactory(HeaderPanel),
            footerPanel:  new WidgetFactory(FooterPanel),
            titleLabel:   new WidgetFactory(TitleLabel)
        ]
    ]
}