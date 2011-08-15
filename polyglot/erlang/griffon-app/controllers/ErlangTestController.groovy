class ErlangTestController {
    def model
    def view

    def calculate = { evt = null ->
        double a = model.num1.toDouble()
        double b = model.num2.toDouble()
        model.enabled = false
        doOutside {
            try {
                model.connection.sendRPC('mathserver', 'add', [a, b].toErlang())
                def result = model.connection.receiveRPC()
                doLater { model.result = result.toString() }
            } finally {
                edt { model.enabled = true }
            }
        }
    }
}
