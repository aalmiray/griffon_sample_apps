import griffon.effects.*

Closure resetWin = {w, p -> 
    parentModel.reset()
    Effects.appear(w, duration: 50l, delay: 520l)
    parentModel.animating = false
}

actions {
    action(id: 'dropOutAction',
        name: 'Drop Out',
        enabled: bind{!parentModel.animating},
        closure: { 
            parentModel.animating = true
            Effects.dropOut(model.properties, target, resetWin)
        })
    action(id: 'dropInAction',
        name: 'Drop In',
        enabled: bind{!parentModel.animating},
        closure: {
            parentModel.animating = true
            Effects.dropIn(model.properties, target){w, p ->
                parentModel.animating = false
            }
         })
}

panel(id: 'box') {
    migLayout(layoutConstraints: 'fill', columnConstraints: 'center')
    button(dropOutAction, constraints: 'grow, span 2, wrap')
    button(dropInAction, constraints: 'grow, span 2, wrap')

    label('Anchor')
    comboBox(items: Anchor.collect{it.name()}, id: 'anchor', constraints: 'wrap')
    bean(model, anchor: bind{anchor.selectedItem})

    separator(constraints: 'grow, span 2, wrap')

    label('Duration:')
    textField(columns: 20, constraints: 'wrap',
        text: bind('duration', target: model, mutual: true))

    label('Delay:')
    textField(columns: 20,
        text: bind('delay', target: model, mutual: true))
}
