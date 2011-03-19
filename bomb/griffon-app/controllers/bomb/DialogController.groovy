package bomb

import java.awt.Window

class DialogController {
    def view

    @Threading(Threading.Policy.INSIDE_UITHREAD_SYNC)
    def show = { Window window ->
        view.pane.createDialog(
            window ?: Window.windows.find{it.focused}, 
            'Somebody setup us the bomb!').show()
    }
}