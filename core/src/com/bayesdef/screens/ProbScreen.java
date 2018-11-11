package com.bayesdef.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
//import com.hbp.probdef.RT_Kaboom;
//import com.hbp.probdef.Mine;
//import com.hbp.probdef.Turret;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Mine;
import com.bayesdef.objects.Shot;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.BGM;
import com.bayesdef.resources.Fonts;
import com.bayesdef.resources.Options;
import com.bayesdef.resources.Sounds;
import com.bayesdef.resources.Textures;

public class ProbScreen extends GameScreen{
	
    int seconds = 0;
    
    boolean bayesian = false;
    
    String currentStatus = "waiting";
    
    Turret currentlyActiveTurret = null;
    
    float volleyEndingTime=0;
    
	public ProbScreen(final BayesDef bd) {
		
		super(bd);
		playerShip.shieldCount=5;
		
		level_specific_turret_setup();
		
		BGM.campaignMusic.setLooping(true);
		BGM.campaignMusic.play();
	}
	
	@Override
	
	public void render(float delta){
		game_render(delta);
		
		check_for_shield_mine_collisions();
		check_for_ship_mine_collisions();
		check_for_shot_mine_collisions();
		
		do_status_relevant_things();
		
		draw_HUD();
		
		for (Turret turret: turrets){
			turret.rect.y = playerShip.rect.y + playerShip.rect.height - turret.rect.height - 20;
		}
	}
	
	// ===Implications of Status===
	
	void do_status_relevant_things(){
		if (currentStatus.equals("waiting")){
			TIMESPEED=1;
			do_waiting_things();
		}
		//else here?
		if (currentStatus.equals("targeting")){
			TIMESPEED=0;
			do_targeting_things();
		}
		if (currentStatus.equals("firing")){
			TIMESPEED=0.1f;
			do_firing_things();
		}
	}
	
	void do_waiting_things(){
		if ((seconds+1)<totalTime){
			seconds+=1;
			System.out.println(seconds);
			if (any_targetable_mines()){
				currentStatus="targeting";
			}
			level_specific_events();
		}
	}
	
	void do_targeting_things(){
		
		//Draw targeting
		
		draw_targeting();
		autocalc();
		//Change to tapped turrets
		
		if (Gdx.input.justTouched()){
			for (Turret turret: turrets){
				if (turret.rect.contains(tp_x, tp_y)){
					turret.targeted = false;
					turret.targetMine = null;
					currentlyActiveTurret = turret;
				}
			}
		}
		
		//Target turrets
		
		if (currentlyActiveTurret!=null){
			if (Gdx.input.isKeyJustPressed(Keys.SPACE)){
				currentlyActiveTurret.targeted = true;
			}
			else if (Gdx.input.justTouched()){
				for (Mine mine: mines){
					if (mine.rect.contains(tp_x,tp_y)){
						currentlyActiveTurret.targeted = true;
						currentlyActiveTurret.targetMine = mine;
					}
				}
			}
		}		
		
		//Pick new turrets
		
		if (currentlyActiveTurret==null){
			cycle_through_turrets();
		}
		else if (currentlyActiveTurret.targeted){
			cycle_through_turrets();
		}
		
		//Handle handover
		
		if (currentlyActiveTurret==null && (!Options.waitForFiringButton || Gdx.input.isKeyJustPressed(Keys.SPACE))){
			set_up_firing_times();
			currentStatus="firing";
		}
		if (Gdx.input.justTouched() && fireButtonRect.contains(tp_x,tp_y)){
			set_up_firing_times();
			currentStatus="firing";
		}
		
	}
	
	void do_firing_things(){
		
		draw_targeting();
		draw_miss_statements();
		
		for (Turret turret: turrets){
			if (turret.targetMine!=null){
				if (turret.targeted && turret.firingTime<totalTime){
					if (!turret.targetMine.beingDetained && turret.targetMine.actuallyExists){
						Sounds.fire.play(Options.SFXVolume*0.3f);
						Shot shot = new Shot(turret.rect, turret.targetMine, 5000, turret.determine_output());
						shots.add(shot);
						turret.currentT=turret.firingT;
						turret.targeted=false;
						turret.targetMine=null;
					}
					else{
						turret.targeted=false;
					}
				}
			}
			
			if ((turret.firingTime+0.05f)<totalTime){
				turret.currentT=turret.normalT;
		   }
		}
		
		if (totalTime>volleyEndingTime){
			
			for (Turret turret: turrets){
				turret.targeted=false;
				turret.targetMine=null;
			}
			
			currentStatus = "waiting";
		}
	}
	
	// ===Level-Specific Functions===
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("triangle");
		
		turretOne.rect.x = 50;
		turretTwo.rect.x = 230;
		
		turretOne.rect.y = 60;
		turretTwo.rect.y = 60;
		
		
		turretOne.targetingXOffset=-19;
		turretOne.targetingYOffset=0;
		
		turretTwo.targetingXOffset=0;
		turretTwo.targetingYOffset=-19;
		
		
		turrets.add(turretOne);
		turrets.add(turretTwo);
	}
	
	void level_specific_events(){

		if (seconds==4){
			spawnMine(0);
		}
		
		if (seconds==10){
			spawnMine(-2);
			spawnMine(2);
		}
		
		if (seconds==15){
			spawnMine(0, "slow");
		}
		
		if (seconds==20){
			spawnMine(-3);
			spawnMine(1, "speedy");
		}
	}
	
	// ===Check Functions===
	
	void check_for_shield_mine_collisions(){
		for (Mine mine: mines){
		   if(mine.rect.y<(playerShip.shield.y+playerShip.shield.height/2) && playerShip.shieldCount>0) {
			     	spawn_explosion(mine.rect.x,mine.rect.y);
			        playerShip.shieldCount-=1;
			        Sounds.mineHitUs.play(Options.SFXVolume*0.4f);
			        Sounds.mineSplode.play(Options.SFXVolume);
			        //if (option_flicker){
			        //	shipshield_t=shipshield_flicker_t;
			        //
			        mines.removeValue(mine,true);
			}  
		 }
	}
	
	void check_for_ship_mine_collisions(){
		
		for (Mine mine: mines){
		   if(mine.rect.y<(playerShip.rect.y+playerShip.rect.height) && playerShip.shieldCount<1) {
				//minecount-=1;
		     	spawn_explosion(mine.rect.x,mine.rect.y);
		        Sounds.mineHitUs.play(Options.SFXVolume*0.8f);
		        Sounds.mineSplode.play(Options.SFXVolume);
		        mines.removeValue(mine,true);
		        initiate_failure();
			}  
		 }
	}
	
	void check_for_shot_mine_collisions(){
		for (Shot shot: shots){
			if ((shot.rect.y-2)>shot.targetMine.rect.y && !shot.doomedToMiss){
				if (shot.type.equals("capture")){
					Sounds.capture.play(Options.SFXVolume*0.8f);
					shot.targetMine.beingDetained=true;
					exit_stage_whatever(shot.targetMine);
					shots.removeValue(shot, true);
				}
				if (shot.type.equals("destroy")){
					Sounds.mineSplode.play(Options.SFXVolume*0.6f);
					spawn_explosion(shot.targetMine.rect.x, shot.targetMine.rect.y);
					shot.targetMine.actuallyExists=false;
					mines.removeValue(shot.targetMine, true);
					shots.removeValue(shot, true);
				}
			}
		}
	}
	
	// ===Turret functions===
	
	void cycle_through_turrets(){
		boolean gotTurret=false;
		
		for (Turret turret: turrets){
			if (!gotTurret){
				if(!turret.targeted){
					currentlyActiveTurret = turret;
					gotTurret=true;
				}
			}
		}
		if (gotTurret==false){
			currentlyActiveTurret = null;
		}
	}
	
	void set_up_firing_times(){
		float firingTime=totalTime+0.05f;
		for (Turret turret: turrets){
			if (turret.targeted && turret.targetMine!=null){
				firingTime+=0.1f;
				turret.firingTime=firingTime;
			}
		}
		volleyEndingTime=firingTime+0.15f;
	}
	
	// ===Drawing Functions===
	
	void draw_targeting(){
		batch.begin();
		if (currentlyActiveTurret!=null){
			batch.draw(currentlyActiveTurret.selectedT, currentlyActiveTurret.rect.x, currentlyActiveTurret.rect.y);
			batch.draw(currentlyActiveTurret.targetT, tp_x-30, tp_y-30);
	    	draw_orange_dotted_line(currentlyActiveTurret.rect.x+currentlyActiveTurret.rect.width/2, currentlyActiveTurret.rect.y+currentlyActiveTurret.rect.height*3/4,tp_x,tp_y,10);
		}
		
		for (Turret turret: turrets){
			if (turret.targeted && turret.targetMine!=null){
				if (!turret.targetMine.beingDetained && turret.targetMine.actuallyExists){
					batch.draw(turret.targetT, turret.targetMine.rect.x+turret.targetingXOffset, turret.targetMine.rect.y+turret.targetingYOffset);
					draw_orange_dotted_line(turret.rect.x+turret.rect.width/2f, turret.rect.y+turret.rect.height*3f/4f, turret.targetMine.rect.x+turret.targetMine.rect.width/2+turret.targetingXOffset, turret.targetMine.rect.y+turret.targetMine.rect.height/2-turret.targetingYOffset, 10);
				}
			}
		}
		
		batch.draw(Textures.statusBar, 0, 400);
		batch.end();
	}
	
	void autocalc(){
		batch.begin();
		
		for (Mine mine:mines){
		   if (screenProper.overlaps(mine.rect)){
			   
			   float survive=1f;
			   float destroy=0f;
			   float capture=0f;
			   float destroyExtra=0f;
			   float captureExtra=0f;
			   
			   for (Turret turret: turrets){
				   if (turret.targeted){
					   if (turret.targetMine!=null){
						   if (turret.targetMine.equals(mine)){
							   destroyExtra = survive*turret.destroyChance;
							   destroy = destroy + destroyExtra;
							   
							   captureExtra = survive*(1f-turret.destroyChance)*(1f-turret.captureMissingChance);
							   capture = capture + captureExtra;
							   
							   survive = survive - destroyExtra - captureExtra;
						   }
					   }							   
				   }
			   }
			   
			   Fonts.AcalcFonts.blue.draw(batch, present_float(capture*100f)+"%", mine.rect.x-12, mine.rect.y-20, 81, 1, true);
			   batch.draw(Textures.Icons.capture, mine.rect.x-12, mine.rect.y-31);
			      
			   Fonts.AcalcFonts.gray.draw(batch, present_float(survive*100f)+"%", mine.rect.x-12, mine.rect.y-35, 81, 1, true);
			   batch.draw(Textures.Icons.survive, mine.rect.x-12, mine.rect.y-46);
			   
			   Fonts.AcalcFonts.red.draw(batch, present_float(destroy*100f)+"%", mine.rect.x-12, mine.rect.y-50, 81, 1, true);
			   batch.draw(Textures.Icons.destroy, mine.rect.x-12, mine.rect.y-61);
		   }
		}
		
		batch.end();
	}
	
	void draw_miss_statements(){
		batch.begin();
		for (Shot shot: shots){
			if (shot.rect.y>shot.targetMine.rect.y && shot.rect.overlaps(screenProper)){
				if (shot.doomedToMiss){
					Fonts.AcalcFonts.white.draw(batch, "MISS", shot.rect.x-10, shot.rect.y-10);
				}
			}
		}
		batch.end();
	}
	
	void draw_HUD(){
		batch.begin();
		batch.draw(Textures.statusBar, 0, 400);
		batch.draw(Textures.Buttons.fire, 20, 420);
		batch.draw(Textures.Buttons.exit, 220, 420);
		batch.end();
	}
	
	void draw_orange_dotted_line(float start_x, float start_y, float finish_x, float finish_y, int number_of_divs){
		   for (int q=1; q<number_of_divs; q++){
			   float centre_x=start_x+((float)q/(float)number_of_divs)*(finish_x-start_x);
			   float centre_y=start_y+((float)q/(float)number_of_divs)*(finish_y-start_y);
			   batch.draw(Textures.Targets.Turret.lineDot, centre_x-1, centre_y-1);
		   }
	}
	
	// ===Spawning Functions===
	
	void spawnMine(int xposn) {
		   
		   Mine mine = new Mine(xposn);
		   mines.add(mine);
		         
	}
	
	void spawnMine(int xposn, String typ) {
		   
		   Mine mine = new Mine(xposn, typ);
		   mines.add(mine);
		         
	}
	
	// ===Miscellaneous Useful Functions===
	
	boolean any_targetable_mines(){
		   for (Mine mine:mines){
			   if (mine.rect.overlaps(screenProper)){
				   return true;
			   }
		   }
		   return false;
	}
	
}
