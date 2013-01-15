package fusion.widgets.factory

import griffon.util.ApplicationHolder
import groovy.swing.factory.ComponentFactory

class WidgetFactory extends ComponentFactory {
    WidgetFactory(Class beanClass) {
        this(beanClass, false)
    }

    WidgetFactory(Class beanClass, boolean leaf) {
        super(beanClass, leaf)
    }

    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes)
        throws InstantiationException, IllegalAccessException {
        ApplicationHolder.application.newInstance(beanClass, '')
    }
}