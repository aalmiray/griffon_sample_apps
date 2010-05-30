import net.miginfocom.swing.MigLayout

actions {
    action(id: 'runAction',
        name: 'Run',
        enabled: bind{!parentModel.animating},
        closure: controller.runEffect)
}

panel(id: 'box', layout: new MigLayout('fill')) {
    label('X (in pixels):')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('x', target: model, mutual: true))

    label('Y (in pixels):')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('y', target: model, mutual: true))

    label('W (in pixels):')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('w', target: model, mutual: true))

    label('H (in pixels):')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('h', target: model, mutual: true))

    label('Mode')
    buttonGroup(id: 'mode')
    radioButton('relative', buttonGroup: mode, selected: true, actionPerformed: {model.mode = 'relative'})
    radioButton('absolute', buttonGroup: mode, constraints: 'wrap', actionPerformed: {model.mode = 'absolute'})

    separator(constraints: 'grow, span 3, wrap')

    label('Duration:')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('duration', target: model, mutual: true))

    label('Delay:')
    textField(columns: 20, constraints: 'span 2, wrap',
        text: bind('delay', target: model, mutual: true))

    button(runAction, constraints: 'span3, right')
}
