import javax.swing.JComponent
import java.awt.Graphics

class DrawingSurface extends JComponent {
    Closure closure

    void paintComponent(Graphics g) {
        if(closure) closure(this, g)
    }
}
