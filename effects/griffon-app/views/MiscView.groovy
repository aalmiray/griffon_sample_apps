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
            Effects.shake(target){w, p -> parentModel.reset()}
         })
    action(id: 'fadeAction',
        name: 'Fade / Appear',
        enabled: bind{!parentModel.animating},
        closure: {
            parentModel.animating = true
            Effects.fade(target){w, p -> Effects.appear(w) {t, a ->
               parentModel.animating = false
            }}
        })
}

panel(id: 'box', layout: new MigLayout('fill', 'center')) {
    button(puffAction, constraints: 'grow, wrap')
    button(shakeAction, constraints: 'grow, wrap')
    button(fadeAction, constraints: 'grow')
}
