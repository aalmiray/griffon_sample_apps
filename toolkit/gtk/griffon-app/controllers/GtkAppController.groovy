class GtkAppController {
    def model
    def view

    def copyText = { evt = null ->
        view.output.text = "[COPY] ${model.input}"
    }
}
