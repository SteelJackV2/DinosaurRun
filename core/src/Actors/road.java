package Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Akash on 6/9/2018.
 */

public class road extends Actor {

    Sprite road = new Sprite(new Texture("road.png"));
    Sprite road2 = new Sprite(new Texture("road.png"));
    Sprite cloud = new Sprite(new Texture("cloud.png"));
    Sprite cloud2 = new Sprite(new Texture("cloud.png"));
    Sprite cloud3 = new Sprite(new Texture("cloud.png"));
    Sprite rock = new Sprite(new Texture("rocks.png"));
    Sprite rock2 = new Sprite(new Texture("rocks.png"));
    Sprite rock3 = new Sprite(new Texture("rocks.png"));
    Sprite rock4 = new Sprite(new Texture("rocks.png"));



    public road(){
        road.setPosition(0, 250);
        road2.setPosition(road.getWidth(), 250);
        cloud.setPosition(700, 700);
        cloud2.setPosition(1500, 550);
        cloud3.setPosition(2300, 625);
        rock.setPosition(100, 185);
        rock2.setPosition(700, rock.getY());
        rock3.setPosition(1300,  rock.getY());
        rock4.setPosition(1900,  rock.getY());
    }

    @Override
    public void act(float delta) {
        if((road.getX()+road.getWidth())<0){
            road.setPosition(road2.getX()+road2.getWidth(), road.getY());
        }
        if((road2.getX()+road2.getWidth())<0){
            road2.setPosition(road.getX()+road.getWidth(), road2.getY());
        }
        if((cloud.getX()+cloud.getWidth())<0){
            cloud.setPosition(cloud3.getX()+800, cloud.getY());
        }
        if((cloud2.getX()+cloud2.getWidth())<0){
            cloud2.setPosition(cloud.getX()+700, cloud2.getY());
        }
        if((cloud3.getX()+cloud3.getWidth())<0){
            cloud3.setPosition(cloud2.getX()+900, cloud3.getY());
        }
        if((rock.getX()+rock.getWidth())<0){
            rock.setPosition(rock4.getX()+600, rock.getY());
        }
        if((rock2.getX()+rock2.getWidth())<0){
            rock2.setPosition(rock.getX()+500, rock2.getY());
        }
        if((rock3.getX()+rock3.getWidth())<0){
            rock3.setPosition(rock2.getX()+650, rock3.getY());
        }
        if((rock4.getX()+rock4.getWidth())<0){
            rock4.setPosition(rock3.getX()+450, rock4.getY());
        }

        road.setPosition(road.getX() -18, road.getY());
        road2.setPosition(road2.getX() -18, road.getY());
        cloud.setPosition(cloud.getX()-5, cloud.getY());
        cloud2.setPosition(cloud2.getX()-5, cloud2.getY());
        cloud3.setPosition(cloud3.getX()-5, cloud3.getY());
        rock.setPosition(rock.getX()-18, rock.getY());
        rock2.setPosition(rock2.getX()-18, rock2.getY());
        rock3.setPosition(rock3.getX()-18, rock3.getY());
        rock4.setPosition(rock4.getX()-18, rock4.getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        road.draw(batch);
        road2.draw(batch);
        cloud.draw(batch);
        cloud2.draw(batch);
        cloud3.draw(batch);
        rock.draw(batch);
        rock2.draw(batch);
        rock3.draw(batch);
        rock4.draw(batch);
    }
}
