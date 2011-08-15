import java.awt.*
import javax.swing.*
import org.pushingpixels.trident.TridentConfig
import org.pushingpixels.trident.Timeline.TimelineState

currHue = 0f

newStarTimeline = { star, currX, currY, outerStartSpan, outerFinalSpan ->
    double angle = Math.random() * 2d * Math.PI
    double distance = 20d + 30d * Math.PI

    timeline(star, duration: 3000, start: true) {
        interpolatedProperty('x', from: currX, to: currX + distance * Math.cos(angle))
        interpolatedProperty('y', from: currY, to: currY + distance * Math.sin(angle))
        interpolatedProperty('alpha', from: 1f, to: 0f)
        interpolatedProperty('rotation', from: 0f, to: (2 * Math.PI * Math.random()) as float)
        interpolatedProperty('outerSpan', from: outerStartSpan, to: outerFinalSpan)
        interpolatedProperty('color', from: Color.WHITE, to: new Color(Color.HSBtoRGB(currHue as float, 0.8f, 0.7f)))
        currHue += 0.1f

        timelineCallback {
            timelineStateChanged { oldState, newState, df, tp ->
                if(newState == TimelineState.DONE) {
                    synchronized(model.stars) { model.stars.removeLast() }
                }
            }
        }
    }
}

application(title: 'Stardust',
  size: [400,300],
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    widget(new DrawingSurface(), id: 'surface', closure: { container, g ->
        g.color = Color.BLACK
        g.fillRect 0i, 0i, container.width, container.height
        
        def g2d = g.create()
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON)
        synchronized(model.stars) {
            model.stars.each { star ->
                g2d.color = star.color
                g2d.composite = AlphaComposite.SrcOver.derive(star.alpha)
                g2d.fill star.currentShape
            }
        }
        g2d.dispose()
    })

    // higher pulse rate to create 50 stars a second
     TridentConfig.getInstance().setPulseSource(new TridentConfig.FixedRatePulseSource(20))

    timeline(loop: true) {
        uiThreadTimelineCallback {
            timelinePulse { durationFraction, timelinePosition ->
                Point mouseLoc = MouseInfo.pointerInfo.location
                SwingUtilities.convertPointFromScreen(mouseLoc, surface)
                double currX = mouseLoc.x
                double currY = mouseLoc.y
                if(currX < 0 || currY <0  ||
                   currX > surface.width ||
                   currY > surface.height) return

                Star star = new Star(currX, currY, 5)
                synchronized(model.stars) {
                    model.stars.addFirst(star)
                }
                newStarTimeline(star, currX, currY, 5, 20)
            }
        }
    }

    swingRepaintTimeline(surface, loop: true)
}
