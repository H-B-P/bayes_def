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
import com.bayesdef.objects.Symbol;
import com.bayesdef.objects.Turret;
import com.bayesdef.objects.EnemyShip;
import com.bayesdef.objects.Vane;
import com.bayesdef.resources.BGM;
import com.bayesdef.resources.Fonts;
import com.bayesdef.resources.Options;
import com.bayesdef.resources.Sounds;
import com.bayesdef.resources.Textures;

public class BayesScreen extends GameScreen{
	
    int seconds = 0;
    
    boolean bayesian = true;
    
    String currentStatus = "waiting";
    
    Vane currentlyActiveVane = null;
    
    float volleyEndingTime = 0;
    
	public BayesScreen(final BayesDef bd) {
		
		super(bd);
		shieldsRemaining=5;
		
		vane_setup();
		
		spawnEnemyShip(-2,0.2f, false);
		spawnEnemyShip(0,0.5f, false);
		spawnEnemyShip(2,0.8f, true);
		
		BGM.campaignMusic.setLooping(true);
		BGM.campaignMusic.play();
		
		
	}
	
	void vane_setup(){
		Vane vane_one=new Vane();
		Vane vane_two=new Vane();
		
		vane_one.energy=level_specific_forward_energy_cycle("");
		vane_two.energy=level_specific_forward_energy_cycle("");

		
		vane_one.rect.x=55;
		vane_two.rect.x=215;
		
		vanes.add(vane_one);
		vanes.add(vane_two);
	}
	
	@Override
	
	public void render(float delta){
		game_render(delta);
		
		//check_for_shield_mine_collisions();
		//check_for_ship_mine_collisions();
		//check_for_shot_mine_collisions();
		check_for_symbol_enemyship_collisions();
		check_for_ship_shot_collisions();
		
		do_status_relevant_things();
		
		
		
		//draw_HUD();
		
		for (Vane vane: vanes){
			vane.rect.y = theShip.y + theShip.height - vane.rect.height - 15;
		}
		
		autocalc();
		
	}
	
	// ===Implications of Status===
	
	void do_status_relevant_things(){
		if (currentStatus.equals("bowling")){
			TIMESPEED=1;
			do_bowling_things();
		}
		else if (currentStatus.equals("waiting")){
			TIMESPEED=1;
			do_waiting_things();
		}
		else if (currentStatus.equals("targeting")){
			TIMESPEED=0;
			do_targeting_things();
		}
		else if (currentStatus.equals("firing")){
			TIMESPEED=0.1f;
			do_firing_things();
		}
	}
	
	void do_bowling_things(){
		
	}
	
	void do_waiting_things(){
		if ((seconds+1)<totalTime){
			seconds+=1;
			System.out.println(seconds);
			if (any_targetable_ships()){
				currentStatus="targeting";
			}
			level_specific_events();
		}
	}
	
void do_targeting_things(){
		
		//Draw targeting
		
		draw_targeting();
		//autocalc();
		
		//Change to tapped turrets
		
		if (Gdx.input.justTouched()){
			for (Vane vane: vanes){
				if (vane.rect.contains(tp_x, tp_y)){
					if (vane.equals(currentlyActiveVane)){
						vane.energy = level_specific_forward_energy_cycle(vane.energy);
					}
					else{
						vane.targeted = false;
						vane.targetShip = null;
						currentlyActiveVane = vane;
					}
				}
			}
		}
		
		//Target vanes
		
		if (currentlyActiveVane!=null){
			if (Gdx.input.isKeyJustPressed(Keys.SPACE)){
				currentlyActiveVane.targeted = true;
			}
			else if (Gdx.input.justTouched()){
				for (EnemyShip enemyship: enemyships){
					if (enemyship.rect.contains(tp_x,tp_y)){
						currentlyActiveVane.targeted = true;
						currentlyActiveVane.targetShip = enemyship;
					}
				}
			}
		}		
		
		//Pick new vanes
		
		if (currentlyActiveVane==null){
			cycle_through_vanes();
		}
		else if (currentlyActiveVane.targeted){
			cycle_through_vanes();
		}
		
		//Handle handover
		
		if (currentlyActiveVane==null && (!Options.waitForFiringButton || Gdx.input.isKeyJustPressed(Keys.SPACE))){
			set_up_firing_times();
			currentStatus="firing";
		}
		if (Gdx.input.justTouched() && fireButtonRect.contains(tp_x,tp_y)){
			set_up_firing_times();
			currentStatus="firing";
		}
		
	}
	
void do_firing_things(){

	
	batch.begin();
	for (Vane vane:vanes){
		if (vane.firingTime>totalTime){
			if (vane.energy.equals("circle")){
				if ((vane.firingTime-0.08)<totalTime){
					batch.draw(Textures.Symbols.someCircle, vane.rect.x+5, vane.rect.y+5);
				}
				if ((vane.firingTime-0.05)<totalTime){
					batch.draw(Textures.Symbols.mostCircle, vane.rect.x+5, vane.rect.y+5);
				}
				if ((vane.firingTime-0.02)<totalTime){
					batch.draw(Textures.Symbols.fullCircle, vane.rect.x+5, vane.rect.y+5);
				}
			}
			if (vane.energy.equals("triangle")){
				if ((vane.firingTime-0.08)<totalTime){
					batch.draw(Textures.Symbols.someTriangle, vane.rect.x+5, vane.rect.y+5);
				}
				if ((vane.firingTime-0.05)<totalTime){
					batch.draw(Textures.Symbols.mostTriangle, vane.rect.x+5, vane.rect.y+5);
				}
				if ((vane.firingTime-0.02)<totalTime){
					batch.draw(Textures.Symbols.fullTriangle, vane.rect.x+5, vane.rect.y+5);
				}
			}
		}
	}
	batch.end();
	
	draw_targeting();
	draw_miss_statements();
	
	for (Vane vane: vanes){
		if (vane.targetShip!=null){
			if (vane.targeted && vane.firingTime<totalTime){
				if (vane.targetShip.actuallyExists){
					Sounds.laser.play(Options.SFXVolume*0.3f);
					Symbol symbol = new Symbol(vane.rect, vane.targetShip, 2000, vane.energy);
					symbols.add(symbol);
					vane.targeted=false;
					vane.targetShip=null;
				}
				else{
					vane.targeted=false;
				}
			}
		}
	}
	
	for (EnemyShip enemyship: enemyships){
		if (enemyship.turret.firingTime<totalTime && enemyship.turret.targeted==true){
			Sounds.fire.play(Options.SFXVolume*0.3f);
			Shot shot = new Shot(enemyship.turret.rect, 160, 0, 5000, enemyship.turret.determine_output());
			shots.add(shot);
			enemyship.update_chances_on_shoot(shot.type);
			enemyship.turret.targeted=false;
			enemyship.turret.currentT=enemyship.turret.firingT;
		}
		if ((enemyship.turret.firingTime+0.05f)<totalTime){
			enemyship.turret.currentT=enemyship.turret.normalT;
	   }
	}
	
	if (totalTime>volleyEndingTime){
		
		for (Vane vane: vanes){
			vane.targeted=false;
			vane.targetShip=null;
		}
		
		currentStatus = "waiting";
	}
}
	
	//===
	
	void cycle_through_vanes(){
		boolean gotTurret=false;
		
		for (Vane vane: vanes){
			if (!gotTurret){
				if(!vane.targeted){
					currentlyActiveVane = vane;
					gotTurret=true;
				}
			}
		}
		if (gotTurret==false){
			currentlyActiveVane = null;
		}
	}
	
	void set_up_firing_times(){
		float firingTime = totalTime + 0f;
		for (Vane vane: vanes){
			if (vane.targeted && vane.targetShip!=null){
				firingTime += 0.1f;
				vane.firingTime = firingTime;
			}
		}
		firingTime = totalTime + 0.4f;
		for (EnemyShip enemyship: enemyships){
				firingTime += 0.1f;
				enemyship.turret.targeted=true;
				enemyship.turret.firingTime = firingTime;
		}
		volleyEndingTime = firingTime + 0.15f;
	}
	
	// ===Level-Specific Functions===
	
	void level_specific_events(){
		
	}
	
	@Override
	
	void level_specific_enemyship_drawing(EnemyShip enemyShip){
		
		float delter = enemyShip.originalCircleChance*10-5;
		
		batch.draw(Textures.ShipParts.Engines.Fronts.one, enemyShip.rect.x-10, enemyShip.rect.y+40-delter);
		batch.draw(Textures.ShipParts.Engines.Backs.one, enemyShip.rect.x-10, enemyShip.rect.y+40+delter);
		batch.draw(Textures.ShipParts.Engines.Fronts.one, enemyShip.rect.x+50, enemyShip.rect.y+40-delter);
		batch.draw(Textures.ShipParts.Engines.Backs.one, enemyShip.rect.x+50, enemyShip.rect.y+40+delter);
		
		batch.draw(Textures.ShipParts.Fronts.one, enemyShip.rect.x, enemyShip.rect.y);
		batch.draw(Textures.ShipParts.Backs.one, enemyShip.rect.x, enemyShip.rect.y+30);
		
	}
	
	String level_specific_forward_energy_cycle(String en){
		if (en.equals("circle")){
			return "triangle";
		}
		else if (en.equals("triangle")){
			return "circle";
		}
		else{
			return "circle";
		}
	}
	
	String level_specific_backward_energy_cycle(String en){
		if (en.equals("circle")){
			return "triangle";
		}
		else if (en.equals("triangle")){
			return "circle";
		}
		else{
			return "circle";
		}
	}
	
	// ===Check Functions===
	
	void check_for_symbol_enemyship_collisions(){
		for (Symbol symbol: symbols){
			if (symbol.rect.y>symbol.enemyShip.turret.rect.y && symbol.enemyShip.actuallyExists){
				if (symbol.type.equals(symbol.enemyShip.turret.ident)){
					Sounds.shock.play(Options.SFXVolume*0.8f);
					Sounds.mineSplode.play(Options.SFXVolume*0.8f);
					spawn_big_explosion(symbol.enemyShip.rect.x, symbol.enemyShip.rect.y);
					
					symbol.enemyShip.actuallyExists=false;
					enemyships.removeValue(symbol.enemyShip, true);
				}
				else{
					Sounds.mistakenShock.play(Options.SFXVolume*0.8f);
					symbol.enemyShip.update_chances_on_fail(symbol.type);
				}
				symbols.removeValue(symbol,true);
			}
		}
	}
	
	void check_for_ship_shot_collisions(){
		for (Shot shot: shots){
			if (shot.rect.y<theShield.y && !shot.doomedToMiss){
				Sounds.deShield.play(Options.SFXVolume*0.5f);
				shots.removeValue(shot, true);
				shieldsRemaining -= 1;
			}
		}
	}
	
	// ===Energy Functions===
	
	Texture shape_appropriate_target(String shape){
		if (shape.equals("circle")){
			return Textures.Targets.Vane.circle;
		}
		else if (shape.equals("triangle")){
			return Textures.Targets.Vane.triangle;
		}
		else{
			return Textures.Targets.Vane.circle;
		}
	}
	
	// ===Drawing Functions===
	
	void draw_targeting(){
		batch.begin();
		if (currentlyActiveVane!=null){
			batch.draw(currentlyActiveVane.selectedT, currentlyActiveVane.rect.x, currentlyActiveVane.rect.y);
			batch.draw(shape_appropriate_target(currentlyActiveVane.energy), tp_x-30, tp_y-30);
	    	draw_green_dotted_line(currentlyActiveVane.rect.x+currentlyActiveVane.rect.width/2, currentlyActiveVane.rect.y+currentlyActiveVane.rect.height/2,tp_x,tp_y,10);
		}
		
		for (Vane vane: vanes){
			if (vane.targeted && vane.targetShip!=null){
				batch.draw(shape_appropriate_target(vane.energy), vane.targetShip.rect.x, vane.targetShip.rect.y);
				draw_green_dotted_line(vane.rect.x+vane.rect.width/2f, vane.rect.y+vane.rect.height/2, vane.targetShip.rect.x+vane.targetShip.rect.width/2, vane.targetShip.rect.y+vane.targetShip.rect.height/2, 10);
			}
		}
		
		batch.draw(Textures.statusBar, 0, 400);
		batch.end();
	}
	
	void autocalc(){
		batch.begin();
		
		for (EnemyShip enemyship:enemyships){
		   if (screenProper.overlaps(enemyship.rect) && enemyship.obscured){
			   
			   Fonts.AcalcFonts.gray.draw(batch, present_float(enemyship.circleChance*100f)+"%", enemyship.rect.x, enemyship.rect.y-20, 81, 1, true);
			   batch.draw(Textures.Icons.circle, enemyship.rect.x-10, enemyship.rect.y-35);
			      
			   Fonts.AcalcFonts.gray.draw(batch, present_float(enemyship.triangleChance*100f)+"%", enemyship.rect.x, enemyship.rect.y-45, 81, 1, true);
			   batch.draw(Textures.Icons.triangle, enemyship.rect.x-10, enemyship.rect.y-60);
			   
//			   Fonts.AcalcFonts.gray.draw(batch, present_float(enemyship.circleChance*100f)+"%", enemyship.rect.x, enemyship.rect.y-60, 81, 1, true);
//			   batch.draw(Textures.Icons.circle, enemyship.rect.x-10, enemyship.rect.y-75);
//			   
//			   Fonts.AcalcFonts.gray.draw(batch, present_float(enemyship.circleChance*100f)+"%", enemyship.rect.x, enemyship.rect.y-85, 81, 1, true);
//			   batch.draw(Textures.Icons.circle, enemyship.rect.x-10, enemyship.rect.y-100);
//			   
//			   Fonts.AcalcFonts.gray.draw(batch, present_float(enemyship.circleChance*100f)+"%", enemyship.rect.x, enemyship.rect.y-110, 81, 1, true);
//			   batch.draw(Textures.Icons.circle, enemyship.rect.x-10, enemyship.rect.y-125);
		   }
		}
		
		batch.end();
	}
	
	
	void draw_miss_statements(){
		batch.begin();
		for (Shot shot: shots){
			if (shot.rect.y<theShield.y && shot.rect.overlaps(screenProper)){
				if (shot.doomedToMiss){
					Fonts.AcalcFonts.black.draw(batch, "MISS", shot.rect.x-10, shot.rect.y+10);
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
	
	void draw_green_dotted_line(float start_x, float start_y, float finish_x, float finish_y, int number_of_divs){
		   for (int q=1; q<number_of_divs; q++){
			   float centre_x=start_x+((float)q/(float)number_of_divs)*(finish_x-start_x);
			   float centre_y=start_y+((float)q/(float)number_of_divs)*(finish_y-start_y);
			   batch.draw(Textures.Targets.Vane.lineDot, centre_x-1, centre_y-1);
		   }
	}
	
	// ===Spawning Functions===
	
	void spawnEnemyShip(int xposn, float cChance, boolean obs) {
		   
		   EnemyShip enemyship = new EnemyShip(xposn, cChance, 0,0,0,0,1-cChance, obs);
		   enemyships.add(enemyship);
		         
	}
	
	// ===
	
	boolean any_targetable_ships(){
		   for (EnemyShip enemyship:enemyships){
			   //if (enemyship.rect.overlaps(screenProper)){
			   if (screenProper.contains(enemyship.rect)){
				   return true;
			   }
		   }
		   return false;
	}
	
}
