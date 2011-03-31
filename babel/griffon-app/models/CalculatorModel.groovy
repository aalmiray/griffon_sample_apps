@Bindable
@Listener(enabler)
class CalculatorModel {
    String numbera
    String numberb
    String result
    boolean enabled = false

    private enabler = { e ->
        if(e.propertyName in ['result', 'enabled']) return
        enabled = numbera && numberb
    }
}
