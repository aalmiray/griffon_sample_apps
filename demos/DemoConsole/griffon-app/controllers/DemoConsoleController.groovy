import java.awt.event.ActionEvent

class DemoConsoleController {
    private GroovyShell shell = new GroovyShell()

    // these will be injected by Griffon
    def model
    def view

    def executeScript = { ActionEvent evt = null ->
        model.enabled = false
        def result
        try {
            result = shell.evaluate(model.scriptSource)
        } finally {
            executeInsideUIAsync {
                model.enabled = true
                model.scriptResult = result
            }
        }
    }
}
