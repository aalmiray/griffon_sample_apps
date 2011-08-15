import org.lwjgl.test.opengl.Gears

gears = new Gears()

application(title:'LWJGL test', 
  size:[320,320],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    lwjglCanvas(id: 'canvas',
        onInitGL:  { gears.init() },
        onPaintGL: { gears.draw() }
    )
    swingRepaintTimeline(canvas, loop: true)
}
