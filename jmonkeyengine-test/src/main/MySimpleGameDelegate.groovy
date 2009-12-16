import griffon.jme.app.SimpleGameGriffonApplication
import griffon.jme.app.SimpleGameDelegate

import com.jme.math.Quaternion
import com.jme.math.Vector3f
import com.jme.scene.shape.Box
import com.jme.image.Texture
import com.jme.scene.state.TextureState
import com.jme.util.TextureManager

class MySimpleGameDelegate extends SimpleGameDelegate {
    float angle = 0
    Box cube

    MySimpleGameDelegate(SimpleGameGriffonApplication app) {
        super(app)
    }

    void simpleInitGame() {
        // Create a box centered at the origin. Its extents along each dimension
        // are of length 3, this creates a 6x6x6 cube.
        cube = new Box("A Cube",               // Node name
                       new Vector3f(0, 0, 0),  // Box center
                       3, 3, 3)                // Box x,y,z extents
   
        // Load a texture
        ClassLoader cl = getClass().getClassLoader()
        URL url = cl.getResource("griffon-icon-256x256.png")
        Texture tex = TextureManager.loadTexture(url,
                          Texture.MinificationFilter.Trilinear,
                          Texture.MagnificationFilter.Bilinear)

        // Create a TextureState instance
        TextureState ts = display.renderer.createTextureState()

        // Assign the texture
        ts.texture = tex

        // Assign texture state to cube
        cube.renderState = ts

       // Attach the box to the root of the scene graph
       rootNode.attachChild(cube)
   }

   void simpleUpdate() {
        angle += 0.001f
        Quaternion q = new Quaternion()
        q.fromAngleAxis(angle, new Vector3f(1, 1, 1))
        cube.localRotation = q
   }
}
