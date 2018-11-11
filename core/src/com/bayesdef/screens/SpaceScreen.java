package com.bayesdef.screens;

/*
 * ~SUMMARY~
 * 
 */

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Rectangle;

import com.bayesdef.BayesDef;
import com.bayesdef.resources.Textures;

public class SpaceScreen extends MetaScreen {
	
	float TIMESPEED;
	
	float prettySpeed;
	float prettyBGheight=Textures.prettyBG.getHeight();
	
	//float shipLocn=120;
	
	float totalTime=0;
	float playerTime=0;
	
	Rectangle screenProper=new Rectangle(0, 0, 320, 400);
	Rectangle screenExtended=new Rectangle(-20, -20, 360, 540);
	
	public SpaceScreen(BayesDef bd) {
		super(bd);
		
		TIMESPEED=1;
		prettySpeed=20;
	}

	public void render(float delta) {
		
		space_render(delta);
		
	}
	
	public void space_render(float delta) {
		
		meta_render();
		
		totalTime += delta*TIMESPEED; //Increment time in-game: how much time passed for the passengers?
		playerTime += delta; //Increment time out-of-game: how much time passed for the player?
		
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		draw_pretty_background();
		batch.draw(Textures.statusBar, 0, 400);
		batch.draw(Textures.letterboxPoncho, -640, -960);
		batch.end();
		
	}
	
	void draw_pretty_background(){
		batch.draw(Textures.prettyBG, 0f, prettyBGheight-(float)((totalTime*prettySpeed)%(prettyBGheight*2)));
		batch.draw(Textures.prettyBG, 0f, prettyBGheight-(float)((totalTime*prettySpeed+prettyBGheight)%(prettyBGheight*2)));
		batch.draw(Textures.prettyBG, 0f, prettyBGheight-(float)((totalTime*prettySpeed+prettyBGheight*2)%(prettyBGheight*2)));

	}

}