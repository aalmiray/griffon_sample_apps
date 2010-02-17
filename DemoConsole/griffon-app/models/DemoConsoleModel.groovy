import groovy.beans.Bindable

class DemoConsoleModel {
    String scriptSource
    @Bindable def scriptResult
    @Bindable boolean enabled = true
}
