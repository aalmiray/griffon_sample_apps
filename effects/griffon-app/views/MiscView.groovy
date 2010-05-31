import net.miginfocom.swing.MigLayout
import griffon.effects.Effects
import griffon.effects.EffectUtil

Closure resetWin = {w, p -> 
    parentModel.reset()
    Effects.appear(w, duration: 50l, delay: 520l)
    parentModel.animating = false
}

actions {
    action(id: 'puffAction',
        name: 'Puff',
        enabled: bind{!parentModel.animating},
        closure: { 
            parentModel.animating = true
            Effects.puff([duration: 250l], target, resetWin)
        })
    action(id: 'shakeAction',
        name: 'Shake',
        enabled: bind{!parentModel.animating},
        closure: {
            parentModel.animating = true
            Effects.shake(model.properties, target){w, p -> parentModel.reset()}
         })
    action(id: 'fadeAction',
        name: 'Fade / Appear',
        enabled: bind{!parentModel.animating},
        closure: {
            parentModel.animating = true
            Effects.fade(model.properties, target){w, p -> Effects.appear(w) {t, a ->
                parentModel.animating = false
            }}
        })
}

panel(id: 'box', layout: new MigLayout('fill', 'center')) {
    button(puffAction, constraints: 'grow, span 2, wrap')
    button(shakeAction, constraints: 'grow, span 2, wrap')
    button(fadeAction, constraints: 'grow, span 2, wrap')

    separator(constraints: 'grow, span 2, wrap')

    label('Duration:')
    textField(columns: 20, constraints: 'wrap',
        text: bind('duration', target: model, mutual: true))

    label('Delay:')
    textField(columns: 20,
        text: bind('delay', target: model, mutual: true))
}
