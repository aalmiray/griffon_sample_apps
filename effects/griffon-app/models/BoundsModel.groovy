import groovy.beans.Bindable

class BoundsModel {
    @Bindable String x = '0'
    @Bindable String y = '0'
    @Bindable String w = '0'
    @Bindable String h = '0'
    @Bindable String duration = '500'
    @Bindable String delay = '0'
    @Bindable String mode = 'relative'
}
