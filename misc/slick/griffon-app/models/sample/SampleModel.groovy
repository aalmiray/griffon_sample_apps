package sample

import org.newdawn.slick.Image

class SampleModel {
    Image plane
    Image land
    float x = 400f
    float y = 300f
    float scale = 1f

    void load() {
        land = new Image('data/land.jpg')
        plane = new Image('data/plane.png')
    }
}

