class SwtAppController {
    def model
    def view

    def copyText = { evt = null ->
        view.output.text = "[COPY] ${view.input.text}"
    }
}
