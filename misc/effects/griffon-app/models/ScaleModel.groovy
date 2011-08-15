import groovy.beans.Bindable

class ScaleModel {
    @Bindable boolean scaleX = true
    @Bindable boolean scaleY = true
    @Bindable String from = '100'
    @Bindable String to = '0'
    @Bindable String duration = '500'
    @Bindable String delay = '0'
    @Bindable String anchor = 'center'
}
