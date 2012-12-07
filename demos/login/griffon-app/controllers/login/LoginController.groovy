package login

import javax.swing.JOptionPane
import griffon.transform.Threading

class LoginController {
    def model

    @Threading(Threading.Policy.SKIP)
    def login = {
        JOptionPane.showMessageDialog(app.windowManager.windows[0],
            """
               username = $model.username
               password = $model.password
            """.stripIndent(14).toString())
    }
}
