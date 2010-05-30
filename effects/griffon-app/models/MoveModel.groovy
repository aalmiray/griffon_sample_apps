import groovy.beans.Bindable

class MoveModel {
    @Bindable String x = '0'
    @Bindable String y = '0'
    @Bindable String duration = '500'
    @Bindable String delay = '0'
    @Bindable String mode = 'relative'
}
