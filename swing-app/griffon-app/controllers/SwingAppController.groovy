class SwingAppController {
    def model

    def copyText = { evt = null ->
        model.output = "[COPY] ${model.input}"
    }
}
