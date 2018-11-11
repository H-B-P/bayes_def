package com.bayesdef.screens;

import java.util.Iterator;

import com.bayesdef.resources.Options;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Explosion;
import com.bayesdef.objects.Mine;
import com.bayesdef.objects.Shot;
import com.bayesdef.objects.Turret;
import com.bayesdef.objects.Vane;
import com.bayesdef.objects.Symbol;
import com.bayesdef.objects.EnemyShip;
import com.bayesdef.objects.PlayerShip;
import com.bayesdef.resources.Textures;

public class GameScreen extends SpaceScreen{
	
	Array<Mine> mines;
	Array<Turret> turrets;
	Array<Explosion> explosions;
	Array<Shot> shots;
	Array<Symbol> symbols;
	Array<Vane> vanes;
	Array<EnemyShip> enemyships;
	
	PlayerShip playerShip;
	
	Rectangle menuButtonRect = new Rectangle(230,420,100,40);
    Rectangle fireButtonRect = new Rectangle(10,420,100,40);
    
    boolean bayesian = false;
    
	public GameScreen(final BayesDef bd) {
		
		super(bd);
		
		mines = new Array<Mine>();
		turrets = new Array<Turret>();
		vanes = new Array<Vane>();
		explosions = new Array<Explosion>();
		shots = new Array<Shot>();
		symbols = new Array<Symbol>();
		enemyships = new Array<EnemyShip>();
		
		playerShip = new PlayerShip();

	}
	
	@Override
	
	public void render(float delta){
		game_render(delta);
		handle_exits();
	}
	
	public void game_render(float delta){
		space_render(delta);
		process_everything(delta);
		batch.begin();
		draw_everything();
		batch.end();
	}
	
	//Processing
	
	void process_everything(float delta){
		
		collect_captured_mines();
		collect_stray_shots();
		
		for (Mine mine: mines){
			mine.update_posn(delta*TIMESPEED);
		}
		
		for (Shot shot:shots){
			shot.update_posn(delta*TIMESPEED);
		}
		
		for (Symbol symbol:symbols){
			symbol.update_posn(delta*TIMESPEED);
		}
		
		for (EnemyShip enemyship:enemyships){
			enemyship.update_posn(delta*TIMESPEED);
		}
		
		playerShip.update_posn(delta*TIMESPEED);
		
		time_out_explosions();
		
		
	}
	
	void time_out_explosions(){
		for (Explosion boom: explosions){
			if((totalTime-boom.birthtime)>0.2f){
				explosions.removeValue(boom, true);
			}
		}
	}
	
	void handle_exits(){
		
	}
	
	void collect_captured_mines(){
		   for (Mine mine: mines){
			   if (mine.beingDetained){
				   if (!mine.rect.overlaps(screenProper)){					   
					   //captured+=1;
					   //minecount-=1;
					   mines.removeValue(mine,true);
				   }
			   }
		   }
	   }
	
	void collect_stray_shots(){
		   for (Shot shot: shots){
			   if (!shot.rect.overlaps(screenExtended)){
				   shots.removeValue(shot,true);
			   }
		   }
	   }
	void collect_stray_symbols(){
		   for (Symbol symbol: symbols){
			   if (!symbol.rect.overlaps(screenExtended)){
				   symbols.removeValue(symbol,true);
			   }
		   }
	   }
	
	//Drawing
	
	public void draw_everything(){
		
		draw_playership();
		
		draw_mines();
		draw_explosions();
		
		draw_enemyships();
		draw_obscurities();
		draw_turrets();
		draw_vanes();
		draw_symbols();
		draw_shots();
		draw_overlays();
		
		batch.draw(Textures.statusBar, 0, 400);
		batch.draw(Textures.letterboxPoncho, -640, -960);
	}
	
	void draw_playership(){
		
		batch.draw(Textures.theShip, playerShip.rect.x, playerShip.rect.y);
		
		if (playerShip.shieldCount==1){
			batch.draw(Textures.Shields.one, playerShip.shield.x, playerShip.shield.y);
		}
		if (playerShip.shieldCount==2){
			batch.draw(Textures.Shields.two, playerShip.shield.x, playerShip.shield.y);
		}
		if (playerShip.shieldCount==3){
			batch.draw(Textures.Shields.three, playerShip.shield.x, playerShip.shield.y);
		}
		if (playerShip.shieldCount==4){
			batch.draw(Textures.Shields.four, playerShip.shield.x, playerShip.shield.y);
		}
		if (playerShip.shieldCount==5){
			batch.draw(Textures.Shields.five, playerShip.shield.x, playerShip.shield.y);
		}
	}
	
	void draw_mines(){
		for(Mine mine: mines) {
			
			if (mine.minetype.equals("speedy")){
				batch.draw(Textures.Mine.speedy, mine.rect.x-20, mine.rect.y-20);
			}
			else if(mine.minetype.equals("slow")){
				batch.draw(Textures.Mine.slow, mine.rect.x-20, mine.rect.y-20);				
			}
			else{
				batch.draw(Textures.Mine.regular, mine.rect.x-20, mine.rect.y-20);
			}
		    if (mine.beingDetained){
		    	batch.draw(Textures.detainingCircle, mine.rect.x-20, mine.rect.y-20);
		    }
		}
	}
	
	void draw_explosions(){
		for(Explosion boom: explosions) {
			if (boom.big){
				batch.draw(Textures.bigExplosion, boom.rect.x, boom.rect.y);
			}
			else{
				batch.draw(Textures.explosion, boom.rect.x, boom.rect.y);
			}
		}
	}
	
	void draw_enemyships(){
		for (EnemyShip enemyship: enemyships){
			level_specific_enemyship_drawing(enemyship);
			batch.draw(enemyship.turret.currentT, enemyship.turret.rect.x, enemyship.turret.rect.y, 40, 40, 0, 0, 40, 40, false, true);
		}
	}
	
	void level_specific_enemyship_drawing(EnemyShip enemyShip){
		
	}
	
	void draw_obscurities(){
		   for (EnemyShip enemyship: enemyships){
			   if (enemyship.obscured){
				   
				   if (totalTime>enemyship.obscuritytime){
					   enemyship.obscuritytime=totalTime+0.08f;
					   enemyship.obscurityno=(enemyship.obscurityno+MathUtils.random(1,3))%4;
				   }
				   
				   if (!Options.permitFlickering){
					   batch.draw(Textures.Obscurities.one, enemyship.rect.x, enemyship.rect.y);
				   }
				   else{
					   if (enemyship.obscurityno==1){
						   batch.draw(Textures.Obscurities.one, enemyship.rect.x, enemyship.rect.y);
					   }
					   else if (enemyship.obscurityno==2){
						   batch.draw(Textures.Obscurities.two, enemyship.rect.x, enemyship.rect.y);
					   }
					   else if (enemyship.obscurityno==3){
						   batch.draw(Textures.Obscurities.three, enemyship.rect.x, enemyship.rect.y);
					   }
					   else if (enemyship.obscurityno==4){
						   batch.draw(Textures.Obscurities.four, enemyship.rect.x, enemyship.rect.y);
					   }
					   else{
						   batch.draw(Textures.Obscurities.one, enemyship.rect.x, enemyship.rect.y);
					   }
				   }
			   }
		   }
	   }
	
	void draw_turrets(){
			for (Turret turret: turrets){
				batch.draw(turret.currentT, turret.rect.x, turret.rect.y);
			}
	}
	
	void draw_vanes(){
		for (Vane vane: vanes){
			batch.draw(Textures.vane, vane.rect.x, vane.rect.y);
		}
	}
	
	void draw_shots(){
		for (Shot shot: shots){
			if (shot.type.equals("capture")){
				batch.draw(Textures.Shots.capture, shot.rect.x, shot.rect.y);
			}
			if (shot.type.equals("destroy")){
				//batch.draw(Textures.Shots.destroy, shot.rect.x-10, shot.rect.y-20);
				batch.draw(Textures.Shots.destroy, shot.rect.x-10, shot.rect.y-20, 10,20, (float)Textures.Shots.destroy.getWidth(), (float)Textures.Shots.destroy.getHeight(), 1f, 1f, -MathUtils.radiansToDegrees*MathUtils.atan2(shot.horzVel, shot.vertVel), 0, 0, Textures.Shots.destroy.getWidth(), Textures.Shots.destroy.getHeight(), false, false);
			}
			
		}
	}
	
	void draw_symbols(){
		for (Symbol symbol: symbols){
			if (symbol.type.equals("circle")){
				batch.draw(Textures.Symbols.fullCircle, symbol.rect.x, symbol.rect.y);
			}
			if (symbol.type.equals("triangle")){
				batch.draw(Textures.Symbols.fullTriangle, symbol.rect.x, symbol.rect.y);
			}
		}
	}
	
	void draw_overlays(){
		for (Turret turret: turrets){
			batch.draw(turret.emptytopT, turret.rect.x, turret.rect.y);
		}
	}
	
	// ===Shared Conveniences===
	
	void exit_stage_whatever(Mine exitingMine){
		   if (exitingMine.rect.x>160){
			   exitingMine.horzVel=2000;
		   }
		   else{
			   exitingMine.horzVel=-2000;
		   }
	   }
	
	String present_float(float flo){//All the normal methods won't export to html so I have to reinvent the wheel here.
		   int a=Math.round(flo*100);
		   int b=a%100;
		   int c=(a-b)/100;
		   
		   String firstHalf="";
		   
		   if (c>9){
			   firstHalf=" "+c;
		   }
		   else{
			   firstHalf=""+c;
		   }
		   
		   if (b<10){
			   return firstHalf + ".0" + b;
		   }
		   else{
			   return firstHalf + "." + b;
		   }
	   }
	
	//---Spawning functions---
	
		void spawn_explosion(float X, float Y){
			   Explosion boom = new Explosion();
			   boom.rect= new Rectangle();
			   boom.birthtime=totalTime;

			   boom.rect.x= X-20;
			   boom.rect.y= Y-20;
			   boom.rect.width=80;
			   boom.rect.height=80;
			   
			   boom.big=false;
			   explosions.add(boom);
		}
		
		void spawn_big_explosion(float X, float Y){
			   Explosion boom = new Explosion();
			   boom.rect= new Rectangle();
			   boom.birthtime=totalTime;
			   
			   boom.rect.x= X-20;
			   boom.rect.y= Y-20;
			   boom.rect.width=100;
			   boom.rect.height=100;
			   
			   boom.big=true;
			   explosions.add(boom);
		}
		
		// ---Death---
		
		void initiate_failure(){
			
		}
}
