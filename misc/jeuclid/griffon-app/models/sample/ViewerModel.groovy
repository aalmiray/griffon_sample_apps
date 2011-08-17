package sample

import groovy.beans.Bindable

class ViewerModel {
   @Bindable String content

    void mvcGroupInit(Map args) {
        execOutside {
            String text = ViewerModel.class.classLoader.getResource('math/example' + args.index + '.xml').text
            execAsync { content = text }
        }
    }
}