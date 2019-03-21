package Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Akash on 6/9/2018.
 */

public class Obsticles extends Actor {

    static Sprite obsticle = new Sprite(new Texture("obsticle.png"));
    static Sprite bitobsticel = new Sprite(new Texture("obsticle1.png"));
    int height = 280;

    public Obsticles(){
        obsticle.setPosition(3000, height);
        bitobsticel.setPosition(5000, height);
    }
    public static Rectangle getRectangle(){
        return obsticle.getBoundingRectangle();
    }
    public static Rectangle getbigRectangle(){
        return bitobsticel.getBoundingRectangle();
    }

    @Override
    public void act(float delta) {
        if((obsticle.getX()+obsticle.getWidth())<0){
            obsticle.setPosition(bitobsticel.getX()+1500, height);
        }
        if((bitobsticel.getX()+bitobsticel.getWidth())<0){
            bitobsticel.setPosition(obsticle.getX()+1500, height);
        }
        obsticle.setPosition(obsticle.getX() -18, height);
        bitobsticel.setPosition(bitobsticel.getX() -18, height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        obsticle.draw(batch);
        bitobsticel.draw(batch);
    }
}
