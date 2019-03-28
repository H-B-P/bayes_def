package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_0 extends ProbScreen{

	public Level_0(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=3;
		playerShip.rect.y=120-playerShip.rect.height;

		statusBar.rect.y=480;
		currentStatus="sulking";
		suppressFreezes=true;
	}
	
	// ===Level-Specific Functions===

	@Override
	void level_specific_failure(){
		game.setScreen(new Level_0_restarted(game, originalMinecount));
	}

	@Override
	
	void level_specific_turret_setup(){
		//we don't set up turrets at the start of this level; need to show why they're needed first.
	}

	void VERY_level_specific_turret_setup(){

		Turret turretOne = new Turret("triangle");

		turretOne.rect.x = 140;

		turretOne.rect.y = -40;

		turretOne.targetingXOffset=0;
		turretOne.targetingYOffset=0;

		turrets.add(turretOne);
	}
	@Override
	
	void level_specific_events(){
		if (seconds==5){
			waveno=0;
			spawnMine(-3, "slow", 500);
			spawnMine(0, "regular", 500);
			spawnMine(3, "fast", 500);
		}
		if (seconds==11){
			playerShip.vertVel=-50;
		}
		if (seconds==14){
			VERY_level_specific_turret_setup();
			playerShip.vertVel=50;
		}
		if (seconds==15){
			statusBar.vertVel=-40;
			suppressFreezes=false;
		}
		if (seconds==20){
			waveno=1;
			spawnMine(0, "regular");
		}
		if (seconds==23){
			waveno=2;
			spawnMine(-1, "regular");
			spawnMine(1, "regular");
		}
		if (seconds==26){
			waveno=3;
			spawnMine(-2, "slow");
			spawnMine(0, "regular");
			spawnMine(2, "fast");
		}
		if (seconds==30){
			waveno=4;
			spawnMine(0,"regular",true,false);
		}
		if (seconds==33){
			waveno=5;
			spawnMine(-2, "slow", true,false);
			spawnMine(0, "regular",true,false);
			spawnMine(2, "fast", true,false);
		}
		if (seconds==37){
			waveno=6;
			spawnMine(0,"regular",MathUtils.randomBoolean(),true);
		}
		if (seconds==40){
			waveno=7;
			if (MathUtils.randomBoolean()){
				spawnMine(-1,"regular",true,true);
				spawnMine(1,"regular",false,true);
			}
			else{
				spawnMine(-1,"regular",false,true);
				spawnMine(1,"regular",true,true);
			}
		}
		if (seconds==43){
			waveno=8;
			spawnMine(-2, "slow", MathUtils.randomBoolean(),true);
			spawnMine(0, "slow",MathUtils.randomBoolean(),true);
			spawnMine(2, "slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==48){
			statusBar.vertVel=40;
		}
		if (seconds==50){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==56){
			game.setScreen(new Level_1(game, minecount));
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 0/4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/8", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);

		if (currentStatus=="sulking"){
			Fonts.AcalcFonts.white.draw(batch, "click to start", 80,260,160, 1, true);
			if (playerTime>5){
				Fonts.AcalcFonts.white.draw(batch, "or press space I guess", 80,220,160, 1, true);
			}
		}
	}
	
	
}
