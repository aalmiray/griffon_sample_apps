package fusion.widgets;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import griffon.core.resources.InjectedResource;

@griffon.plugins.theme.ThemeAware
public class TitleLabel extends JComponent {
    private String text;

    @InjectedResource
    private float shadowOpacity;

    @InjectedResource
    private Color shadowColor;

    @InjectedResource
    private int shadowDistance;

    @InjectedResource
    private int shadowDirection;

    @InjectedResource
    private Font titleFont;

    @InjectedResource
    private Color titleColor;

    public TitleLabel() {
        setOpaque(false);
    }

    public TitleLabel(String text) {
        setOpaque(false);
        this.text = text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setupGraphics(g2);

        FontRenderContext context = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(text, titleFont, context);
        Rectangle2D bounds = layout.getBounds();

        float x = (float) (getWidth() - bounds.getWidth()) / 2.0f;
        float y = (float) (getHeight() - bounds.getHeight()) / 2.0f;

        double rads = Math.toRadians(shadowDirection);
        float shadowOffsetX = (float) Math.cos(rads) * shadowDistance;
        float shadowOffsetY = (float) Math.sin(rads) * shadowDistance;

        Composite composite = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                                   shadowOpacity));
        g2.setColor(shadowColor);
        layout.draw(g2,
                    x + shadowOffsetX,
                    y + layout.getAscent() / 2.0f + shadowOffsetY);

        g2.setComposite(composite);
        g2.setColor(titleColor);
        layout.draw(g2,
                    x,
                    y + layout.getAscent() / 2.0f);
    }

    private void setupGraphics(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
    }
}