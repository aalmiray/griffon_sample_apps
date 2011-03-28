package bomb

import java.awt.Window

class DialogController {
    def model
    def view

    @Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
    def show = { Window window = null ->
        view.pane.createDialog(
            window ?: Window.windows.find{it.focused}, 
            model.title).show()
    }
}
