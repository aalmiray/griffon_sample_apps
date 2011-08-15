import gov.nasa.worldwind.awt.WorldWindowGLCanvas
import gov.nasa.worldwind.examples.ApplicationTemplate
import gov.nasa.worldwind.layers.*
import gov.nasa.worldwind.layers.Mercator.examples.OSMMapnikLayer
import gov.nasa.worldwind.layers.Earth.*
import gov.nasa.worldwind.render.Annotation
import gov.nasa.worldwind.render.GlobeAnnotation

application(title: 'WorldwindTest',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    wwd = worldwind(preferredSize: [300, 300])
}

LayerList ll = wwd.model.layers
ll.remove(ll.getLayerByName('Place Names'))
// ApplicationTemplate.insertBeforeCompass(wwd, new OpenStreetMapLayer())
//ApplicationTemplate.insertBeforeCompass(wwd, annotationLayer = new AnnotationLayer())
