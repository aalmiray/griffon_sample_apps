package login

import javax.swing.JOptionPane

class LoginController {
    def model

    def login = {
        JOptionPane.showMessageDialog(app.windowManager.windows[0],
            """
               username = $model.username
               password = $model.password
            """.stripIndent(14).toString())
    }
}
