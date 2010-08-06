/*
 * Copyright (c) 2010 Devoxx Schedule app - Andres Almiray. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Effects - Andres Almiray nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 'AS IS'
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package devoxx;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.Timeline.RepeatBehavior;
import org.pushingpixels.trident.interpolator.*;
import org.pushingpixels.trident.swing.SwingRepaintTimeline;

/**
 * The following code comes form Trident's test sources.
 * @author Kirill Grouchnikov (original)
 * @author Andres Almiray (modifications)
 */
public class ProgressIndicator extends JComponent {
    private int position = 0;
    private float alpha = 1.0f;

    final int innerWidth = 300;
    final int innerHeight = 60;
    final int highlighterWidth = 58;
    final int highlighterHeight = 2;

    final Color base = Color.decode("#F9A529");
    final Color baseDark = Color.decode("#F99000");

    private Timeline progressTimeline;
    private Timeline swingProgressTimeline;

    private void setup() {
        progressTimeline = new Timeline(this);
	progressTimeline.addPropertyToInterpolate("position", getStartX(), getEndX());
	KeyValues<Float> alphaValues = KeyValues.create(0.0f, 1.0f, 1.0f, 0.0f);
	KeyTimes alphaTimes = new KeyTimes(0.0f, 0.3f, 0.7f, 1.0f);
	progressTimeline.addPropertyToInterpolate("alpha", new KeyFrames<Float>(alphaValues, alphaTimes));
	progressTimeline.setDuration(1500);
	swingProgressTimeline = new SwingRepaintTimeline(this);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void start() {
        if(progressTimeline == null) setup();
	progressTimeline.playLoop(RepeatBehavior.LOOP);
	swingProgressTimeline.playLoop(RepeatBehavior.LOOP);
    }

    public void suspend() {
	progressTimeline.suspend();
	swingProgressTimeline.suspend();
    }

    public void resume() {
	progressTimeline.resume();
	swingProgressTimeline.resume();
    }

    public void cancel() {
	progressTimeline.cancel();
	swingProgressTimeline.cancel();
    }

    protected void paintComponent(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Progress track
        int trackWidth = innerWidth - 36;
        int trackHeight = 1;
        g2d.setColor(new Color(91, 91, 91));
        for (int i = 2; i >= 0; i--) {
            Shape trackContour = new RoundRectangle2D.Double(
                18 - i, h / 2 - i - 1,
                trackWidth + i * 2, trackHeight + i * 2, 2 * i, 2 * i);
            float alpha = 1.0f;
            if (i == 1)
                alpha = 0.3f;
            if (i == 2)
                alpha = 0.1f;
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            g2d.draw(trackContour);
        }

        // Highlighter
        g2d.setColor(baseDark);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.1f * this.alpha));
        for (int i = 6; i >= 0; i--) {
            g2d.fillOval(this.position - highlighterWidth / 2 - i, h / 2
            - highlighterHeight / 2 - i,
            highlighterWidth + 2 * i, highlighterHeight + 2 * i);
        }

        // Highlighter on track
        g2d.setComposite(AlphaComposite.SrcOver.derive(this.alpha));
        g2d.setColor(base);
        g2d.fillRect(this.position - 28, h / 2 - 1, 56, 2);
    }

    public int getStartX() {
        return 18 + highlighterWidth / 2;
    }

    public int getEndX() {
        return (int) (getPreferredSize().getWidth() - (highlighterWidth / 2)) - 18;
    }
}
