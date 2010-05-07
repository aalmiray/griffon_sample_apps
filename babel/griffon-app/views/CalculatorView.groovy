import net.miginfocom.swing.MigLayout

tabbedPane(tabGroup) {
  panel(title: title, layout: new MigLayout('fill', '5%[right]10%[left]5%')) {
    label 'Number A:'
    textField columns: 10, text: bind('numbera', target: model), constraints: 'wrap'
    label 'Number B:'
    textField columns: 10, text: bind('numberb', target: model), constraints: 'wrap'
    button 'Add!', actionPerformed: controller.add, enabled: bind{model.enabled}
    textField columns: 10, text: bind{model.result}, editable: false
  }
}
