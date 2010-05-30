import groovy.beans.Bindable

class ResizeModel {
    @Bindable String w = '0'
    @Bindable String h = '0'
    @Bindable String duration = '500'
    @Bindable String delay = '0'
    @Bindable String mode = 'relative'
}
