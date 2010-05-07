import groovy.beans.Bindable
import java.beans.PropertyChangeListener

class CalculatorModel {
    @Bindable String numbera
    @Bindable String numberb
    @Bindable String result
    @Bindable boolean enabled = false

    CalculatorModel() {
        addPropertyChangeListener({ e ->
            if(e.propertyName in ['result', 'enabled']) return
            enabled = numbera && numberb
        } as PropertyChangeListener)
    }
}
