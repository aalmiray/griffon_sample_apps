package forkjoin

import java.awt.Color
import net.sf.jtreemap.swing.TreeMapNode
import net.sf.jtreemap.swing.TreeMapNodeBuilder
import net.sf.jtreemap.swing.ValuePercent

class ForkjoinModel {
    static final List<Color> THREAD_COLORS = [
         Color.YELLOW,
         new Color(76, 160, 255),
         Color.CYAN,
         Color.MAGENTA,
         Color.GREEN,
         Color.PINK,
         Color.ORANGE,
         Color.WHITE
    ]

    static final COLOR_WAIT      = new Color(212, 146, 52)
    static final COLOR_SCHEDULED = new Color(134, 219, 52)
    static final COLOR_FINISHED  = Color.GRAY
    
    @Bindable int speed = 700
    @Bindable int numThreads = 3
    @Bindable int problemSize = 32
    @Bindable boolean busy = false
}