package jzy3d;

import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.legends.colorbars.ColorbarLegend;
import org.codehaus.griffon.runtime.jzy3d.AbstractGriffonChart3D;
import java.util.Map;

public class MexicanChart3D extends AbstractGriffonChart3D {
    public void mvcGroupInit(Map<String, ?> args) {
        initChart();
    }

    public void initChart(){
        // Define a function to plot
        Mapper mapper = new Mapper(){
            public double f(double x, double y) {
                double sigma = 10;
                return Math.exp( -(x*x+y*y) / sigma  )  *  Math.abs( Math.cos( 2 * Math.PI * ( x*x + y*y ) ) );
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-.5, .5);
        int steps   = 50;
        
        // Create the object to represent the function over the given range.
        final Shape surface = (Shape)Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax()));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(true);
        surface.setWireframeColor(Color.BLACK);
        
        // Setup a colorbar for the surface object and add it to the scene
        Chart chart = getChart();
        chart.getScene().getGraph().add(surface);
        ColorbarLegend cbar = new ColorbarLegend(surface, chart.getView().getAxe().getLayout());
        surface.setLegend(cbar);
    }
}
