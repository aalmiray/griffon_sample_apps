package wizard

import static griffon.util.GriffonNameUtils.getNaturalName

panel(id: 'page',
      border: titledBorder(title: 'Page 1')) {
    migLayout()
    model.griffonClass.propertyNames.each { name ->
        label(getNaturalName(name), constraints: 'left')
        textField(columns: 20, constraints: 'growx, wrap',
            text: bind(name, target: model, mutual: true))
    }
}