package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.dinoRun;

/**
 * Created by Akash on 6/9/2018.
 */

public class dinoActor extends Actor implements GestureDetector.GestureListener{

    TextureAtlas runAtlas = new TextureAtlas(Gdx.files.internal("Spritesheets/dinorun.atlas"));
    TextureAtlas jumpAtlas = new TextureAtlas(Gdx.files.internal("Spritesheets/dinojump.atlas"));
    Animation<TextureRegion> stillAnimation = new Animation(1/8f,runAtlas.getRegions());
    Animation<TextureRegion> jumpAnimation = new Animation(1/32f, jumpAtlas.getRegions());
    float timeForStill = 0f;
    float timeForJump = 0f;
    public boolean jump = false;
    boolean run = true;


    Sprite drino = new Sprite(new Texture("dino.png"));
    Rectangle d = new Rectangle(100, 269, (drino.getWidth()/2), drino.getHeight());

    public dinoActor(){
        GestureDetector gd = new GestureDetector(this);
        Gdx.input.setInputProcessor(gd);
    }

    public Rectangle getBounds() {
        return d;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        run = true;
        drino.setPosition(100, 269);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        timeForStill += Gdx.graphics.getDeltaTime();
        timeForJump += Gdx.graphics.getDeltaTime();

        if(jump){
            batch.draw(jumpAnimation.getKeyFrame(timeForJump,false),100,269);
            timeForStill = 0;
            if(jumpAnimation.isAnimationFinished(timeForJump)){
                jump = false;
            }
        }else {
            if(run) {
                batch.draw(stillAnimation.getKeyFrame(timeForStill, true), 100, 269);
                timeForJump = 0;
            }

            if(getBounds().overlaps(Obsticles.getRectangle()) || getBounds().overlaps(Obsticles.getbigRectangle())){
                dinoRun.gameStop = true;
                dinoRun.gameStart = false;
                drino.draw(batch);
                run = false;
            }

        }


    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        jump = true;
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        dinoRun.reset = true;
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
