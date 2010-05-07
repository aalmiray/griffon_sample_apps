import math.*

class BabelController {
    def model
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
/*
        createMVCGroup('calculator', 'erlang', [
            tabGroup: view.tabGroup,
            title: 'Erlang',
            calculator: new ErlangCalculator()
        ])
*/
    }
}
