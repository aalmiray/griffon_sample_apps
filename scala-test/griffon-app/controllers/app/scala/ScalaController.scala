package app.scala

import java.awt.event.ActionEvent
import org.codehaus.griffon.runtime.core.AbstractGriffonController

class ScalaController extends AbstractGriffonController {
    var model:ScalaModel = _

    def setModel(m:ScalaModel) = model = m

    //def copy(e:ActionEvent):Unit = model.setOutput(model.input)
    def copy():Unit = model.setOutput(model.input)
}
