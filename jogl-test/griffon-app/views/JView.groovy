import com.jogamp.opengl.util.Animator

application(title: 'Jogl',
  size:[300,300],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    glcanvas(id: 'jogl')
    jogl.addGLEventListener(new Gears())
    app.bindings.glanimator = new Animator(jogl)
}
