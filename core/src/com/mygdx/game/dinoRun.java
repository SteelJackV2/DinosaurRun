package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Actors.Obsticles;
import Actors.Score;
import Actors.dinoActor;
import Actors.road;

public class dinoRun extends Game {

	public static Stage game;
	Array<Actor> actors;
	public static  boolean gameStart = true;
	public static  boolean gameStop = false;
	public static boolean reset = false;
	public static  int gamescore = 0;
	public static  int hiscore;



	@Override
	public void create () {
		ScreenViewport viewport = new ScreenViewport();
		game = new Stage(viewport);
		Gdx.input.setInputProcessor(game);

		dinoActor dino = new dinoActor();
		road rd = new road();
		Obsticles obsticles = new Obsticles();
		Score s = new Score();
		dino.setName("dino");
		game.addActor(rd);
		game.addActor(dino);
		game.addActor(obsticles);
		game.addActor(s);
		Preferences gamePrefs =  Gdx.app.getPreferences("dinoGame");
		hiscore = gamePrefs.getInteger("HiScore",0);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.draw();
		if (gamescore>hiscore){
			hiscore = gamescore;
		}

		if(gameStart && !gameStop) {
			gamescore++;
			game.act();
		}
		else{
			if(reset){
				if(gamescore>hiscore){
					Preferences gamePref =  Gdx.app.getPreferences("dinoGame");
					gamePref.putInteger("HiScore",hiscore);
					gamePref.flush();
				}
				game.clear();
				gameStart = true;
				gameStop = false;
				gamescore = 0;
				dinoActor dno = new dinoActor();
				road r = new road();
				Obsticles obs = new Obsticles();
				Score sc = new Score();
				game.addActor(r);
				game.addActor(dno);
				game.addActor(obs);
				game.addActor(sc);
				reset = false;
			}
		}
	}

}
