import groovy.beans.Bindable

class EffectsModel {
    @Bindable String currentPage = ''
    @Bindable boolean animating = false
    Closure reset
}
