import org.lwjgl.opengl.GL11

float angle = 0f

application(title:'LWJGL test', 
  size:[320,320],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    lwjglCanvas(id: 'lwjgl', onInitGL:{ println "init" },
        onPaintGL: {
            GL11.with {  
                glClear(GL_COLOR_BUFFER_BIT)  
                glMatrixMode(GL_PROJECTION_MATRIX)  
                glLoadIdentity()  
                glOrtho(0, 640, 0, 480, 1, -1)  
                glMatrixMode(GL_MODELVIEW_MATRIX)  
             
                glPushMatrix()  
                glTranslatef(320, 240, 0.0f)  
                glRotatef(angle, 0, 0, 1.0f)  
                glBegin(GL_QUADS)  
                glVertex2i(-50, -50)  
                glVertex2i(50, -50)  
                glVertex2i(50, 50)  
                glVertex2i(-50, 50)  
                glEnd()  
                glPopMatrix()  
            }  
            angle += 1  
            swapBuffers()
    })
    swingRepaintTimeline(lwjgl, loop: true)
}
