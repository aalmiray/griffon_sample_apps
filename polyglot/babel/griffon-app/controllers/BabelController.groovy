import babel.math.*
import griffon.jython.JythonObjectFactory

class BabelController {
    def view

    void mvcGroupInit(Map args) {
        createMVCGroup('calculator', 'scala', [
            tabGroup: view.tabGroup,
            title: 'Scala',
            calculator: new ScalaCalculator()
        ])
        createMVCGroup('calculator', 'clojure', [
            tabGroup: view.tabGroup,
            title: 'Clojure',
            calculator: new ClojureCalculator()
        ])
        createMVCGroup('calculator', 'erlang', [
            tabGroup: view.tabGroup,
            title: 'Erlang',
            calculator: new ErlangCalculator()
        ])
        createMVCGroup('calculator', 'jython', [
            tabGroup: view.tabGroup,
            title: 'Jython',
            calculator: newJythonCalculator()
        ])
    }

    private newJythonCalculator() {
        new JythonObjectFactory(Calculator, 'JythonCalculator', 'JythonCalculator').createObject()
    }
}
