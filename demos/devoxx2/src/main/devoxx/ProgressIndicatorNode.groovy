package devoxx

import java.awt.Color
import griffon.builder.gfx.Colors
import griffon.builder.gfx.GfxBuilder
import griffon.builder.gfx.GfxAttribute
import griffon.builder.gfx.DrawableNode
import griffon.builder.gfx.CustomGfxNode

class ProgressIndicatorNode extends CustomGfxNode {
    @GfxAttribute double x = 0
    @GfxAttribute double y = 0
    @GfxAttribute(alias='w') double width = 300
    @GfxAttribute(alias='h') double height = 30
    @GfxAttribute Color c1 = Colors.get(r: 255, g: 155, b: 47)
    @GfxAttribute Color c2 = Colors.get(r: 255, g: 155, b: 67)
    @GfxAttribute Color c3 = Colors.get(r: 255, g: 91, b: 91)
    @GfxAttribute Color c4 = Colors.get(r: 0, g: 255, b: 255)
    @GfxAttribute Color c5 = Colors.get(r: 255, g: 255, b: 0)
    @GfxAttribute int position = 0i
    @GfxAttribute float alpha = 1.0f

    ProgressIndicatorNode() {
        super('progressIndicator')
addPropertyChangeListener({e->
println([e.source, e.propertyName, e.oldValue, e.newValue])
onDirty(e)
}as java.beans.PropertyChangeListener)
    }

    DrawableNode createNode(GfxBuilder builder) {
        int hw = height - 2
        int hh = 2

        builder.group(borderColor: 'none') {
            antialias true

            int trackWidth = width - 36
            int trackHeight = 1
            [0.1f, 0.3f, 1.0f].eachWithIndex { opacity, i ->
                rect(x: 18 - i, y: (height / 2)- i - 1,
                w: trackWidth + i * 2, h: trackHeight + i * 2,
                aw: 2 * i, ah: 2 * i, bc: c3, o: opacity)
            }
            (6..0).each { i ->
                def cx = position
                def cy = height / 2
                ellipse(rx: (hw/1) - i,
                        ry: (hh + 2 * i)/2,
                        cx: cx,
                        cy: cy,
                        f: c4,
                        o: alpha * 0.1f)
            }
            rect(x: position-28, y: height / 2 - 1, w: 56, h: 2, f: c5, o: alpha)
        }
    }

    int getStartX(int containerWidth) {
        (containerWidth - width) / 2 + 18 + (height - 2) / 2
    }

    int getEndX(int containerWidth) {
	(containerWidth + width) / 2 - 18 - (height - 2) / 2
    }
}
