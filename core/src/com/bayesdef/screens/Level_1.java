package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Mine;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_1 extends ProbScreen{

	public Level_1(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=5;
		playerShip.rect.y=120-playerShip.rect.height;

		statusBar.rect.y=480;
		suppressFreezes=true;
	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		//we don't set up turrets at the start of this level; need to show why they're needed first.
	}

	void VERY_level_specific_turret_setup(){

		Turret turretOne = new Turret("circle");
		//Turret turretTwo = new Turret("circleplus");
		Turret turretThree = new Turret("circleplusplus");

		turretOne.rect.x = 50;
		//turretTwo.rect.x = 140;
		turretThree.rect.x = 230;

		turretOne.rect.y = -40;
		//turretTwo.rect.y = -40;
		turretThree.rect.y = -40;

		turretOne.targetingXOffset=-15;
		turretOne.targetingYOffset=15;

		//turretTwo.targetingXOffset=15;
		//turretTwo.targetingYOffset=15;

		turretThree.targetingXOffset=0;
		turretThree.targetingYOffset=-15;

		turrets.add(turretOne);
		//turrets.add(turretTwo);
		turrets.add(turretThree);
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

		if (seconds==25){
			waveno=2;
			spawnMine(-1, "regular");
			spawnMine(1, "regular");
		}
		if (seconds==30){
			waveno=3;
			spawnMine(-2, "slow");
			spawnMine(0, "regular");
			spawnMine(2, "fast");
		}
		if (seconds==35){
			waveno=4;
			spawnMine(-3, "slow");
			spawnMine(-1, "slow");
			spawnMine(1, "slow");
			spawnMine(3, "slow");
		}

		if (seconds==40){
			statusBar.vertVel=40;
		}
		if (seconds==42){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==48){
			game.setScreen(new Level_2(game, minecount));
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 1 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/4", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: NONE", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
