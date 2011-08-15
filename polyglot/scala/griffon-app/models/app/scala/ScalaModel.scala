package app.scala

import org.codehaus.griffon.runtime.core.AbstractGriffonModel

class ScalaModel extends AbstractGriffonModel {
    var input: String = ""
    var output: String = ""

    def getInput():String = input
    def setInput(in: String) = firePropertyChange("input", input, input = in)

    def getOutput():String = output
    def setOutput(out: String) = firePropertyChange("output", output, output = out)
}
