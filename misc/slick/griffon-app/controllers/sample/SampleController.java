package sample;

import griffon.core.GriffonApplication;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.codehaus.griffon.runtime.core.AbstractGriffonController;

public class SampleController extends AbstractGriffonController {
    private SampleModel model;

    public void setModel(SampleModel model) { this.model = model; }

    public void onSlickInit(GriffonApplication app, GameContainer container) {
        model.load();
    }

    public void onSlickUpdate(GriffonApplication app, GameContainer container, int delta) {
        Input input = container.getInput();
        Image plane = model.getPlane();

        if(input.isKeyDown(Input.KEY_A)) {
            plane.rotate(-0.2f * delta);
        }

        if(input.isKeyDown(Input.KEY_D)) {
            plane.rotate(0.2f * delta);
        }

        if(input.isKeyDown(Input.KEY_W)) {
            float hip = 0.4f * delta;

            float rotation = plane.getRotation();

            double x = model.getX() + (hip * Math.sin(Math.toRadians(rotation)));
            double y = model.getY() - (hip * Math.cos(Math.toRadians(rotation)));
            model.setX((float) x);
            model.setY((float) y);
        }

        float scale = model.getScale();
        if(input.isKeyDown(Input.KEY_Z)) {
            scale += (scale >= 5.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*scale, plane.getHeight()/2.0f*scale);
        }
        if(input.isKeyDown(Input.KEY_O)) {
            scale -= (scale <= 1.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*scale, plane.getHeight()/2.0f*scale);
        }
        model.setScale(scale);
    }
}

