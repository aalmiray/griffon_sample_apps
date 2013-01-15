package fusion.widgets;

import griffon.core.resources.InjectedResource;
import javax.swing.JPanel;
import java.awt.*;

@griffon.plugins.theme.ThemeAware
public class ContentPanel extends JPanel {
    @InjectedResource
    private GradientPaint backgroundGradient;

    @InjectedResource
    private Image light;

    @InjectedResource
    private float lightOpacity;

    @Override
    protected void paintComponent(Graphics g) {
        if (!isVisible()) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        Composite composite = g2.getComposite();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setPaint(backgroundGradient);
        Rectangle bounds = g2.getClipBounds();
        g2.fillRect((int)bounds.x, (int)bounds.y, (int)bounds.width, (int)bounds.height);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                         lightOpacity));
        g2.drawImage(light, 0, 0, getWidth(), light.getHeight(this), null);
        g2.setComposite(composite);
    }
}