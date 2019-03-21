package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.dinoRun;

/**
 * Created by Akash on 6/10/2018.
 */

public class Score extends Actor {

    BitmapFont text, high, inst;
    private int w,h;
    String score = Integer.toString(dinoRun.gamescore);
    String hiscore = Integer.toString(dinoRun.hiscore);;



    public Score(){
        text = new BitmapFont(Gdx.files.internal("fonts/main.fnt"),false);
        high = new BitmapFont(Gdx.files.internal("fonts/sub.fnt"),false);
        inst = new BitmapFont(Gdx.files.internal("fonts/text.fnt"),false);
        text.setColor(Color.BLACK);
        high.setColor(Color.BLACK);
        inst.setColor(Color.BLACK);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        score = Integer.toString(dinoRun.gamescore/10);
        hiscore = Integer.toString(dinoRun.hiscore/10);
        text.draw(batch, "Score: "+score, (w/2)-200, 950);
        high.draw(batch, "Hi Score: "+hiscore, 1850, 1025);
        inst.draw(batch, "Tap to JUMP.   Long Press to RESTART", 1540, 50);

    }
}
