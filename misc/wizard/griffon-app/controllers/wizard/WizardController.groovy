package wizard

import griffon.transform.Threading
import static griffon.util.GriffonNameUtils.getNaturalName

class WizardController {
    def model
    def view

    void mvcGroupInit(Map args) {
        (1..3).each { index ->
            def (m, v, c) = createMVCGroup('page'+index)
            view.wizardContainer.add('page'+index, v.page)
        }
        model.totalPages = 3
        execAsync {
            view.wizardContainer.layout.first(view.wizardContainer)
        }
    }

    @Threading(Threading.Policy.SKIP)
    void backAction(evt = null) {
        if(model.decrease()) {
            view.wizardContainer.layout.previous(view.wizardContainer)
        }
    }
    
    @Threading(Threading.Policy.SKIP)
    void nextAction(evt = null) {
        if(model.increase()) {
            view.wizardContainer.layout.next(view.wizardContainer)
        } else {
            List values = []
            (1..3).each { index ->
                def m = app.models."page${index}"
                m.griffonClass.propertyNames.collect(values) { name ->
                    "${getNaturalName(name)} = ${m[name]}"
                }
            }
            
            javax.swing.JOptionPane.showMessageDialog(
                app.windowManager.windows.find{it.focused},
                values.join('\n')
            )
        }       
    }
}
