import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.math.Quaternion
import com.jme3.renderer.RenderManager
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

application(title: 'JMonkeyEngine + Griffon',
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
                   println app.game
    app.game.onInit = {
        Box box = new Box(Vector3f.ZERO, 1, 1, 1)
        model.cube = new Geometry("Box", box)
        model.cube.updateModelBound()

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/SimpleTextured.j3md")
        mat.setTexture("m_ColorMap", assetManager.loadTexture("griffon-icon-256x256.png"))
        model.cube.material = mat

        rootNode.attachChild(model.cube)
    }

    app.game.onUpdate = { float tpf ->
        model.cube.rotate((-1.5*tpf) as float, (2*tpf) as float, tpf)
    }
}
