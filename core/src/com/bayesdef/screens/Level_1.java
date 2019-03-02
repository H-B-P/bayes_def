package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_1 extends ProbScreen{
    
	public Level_1(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=3;
		
	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("circle");
		Turret turretThree = new Turret("circle");
		Turret turretFour = new Turret("circle");
		Turret turretFive = new Turret("circle");
		
		turretOne.rect.x = 50;
		turretTwo.rect.x = 95;
		turretThree.rect.x = 140;
		turretFour.rect.x = 185;
		turretFive.rect.x = 230;
		
		turretOne.rect.y = -40;
		turretTwo.rect.y = -40;
		turretThree.rect.y = -40;
		turretFour.rect.y = -40;
		turretFive.rect.y = -40;
		
		turretOne.targetingXOffset=-10;
		turretOne.targetingYOffset=15;

		turretTwo.targetingXOffset=15;
		turretTwo.targetingYOffset=-5;

		turretThree.targetingXOffset=-15;
		turretThree.targetingYOffset=-5;

		turretFour.targetingXOffset=0;
		turretFour.targetingYOffset=-15;

		turretFive.targetingXOffset=10;
		turretFive.targetingYOffset=15;

		turrets.add(turretOne);
		turrets.add(turretTwo);
		turrets.add(turretThree);
		turrets.add(turretFour);
		turrets.add(turretFive);
	}
	
	@Override
	
	void level_specific_events(){
		if (seconds==5){
			waveno=1;
			spawnMine(0,"regular");
		}
		if (seconds==10){
			waveno=2;
			spawnMine(-1, "regular");
			spawnMine(1, "regular");
		}
		if (seconds==15){
			waveno=3;
			spawnMine(-2, "slow");
			spawnMine(0, "slow");
			spawnMine(2, "slow");
		}
		if (seconds==20){
			waveno=4;
			spawnMine(-2, "slow");
			spawnMine(0, "regular");
			spawnMine(2, "slow");
		}
		if (seconds==28){
			waveno=5;
			spawnMine(-2, "regular");
			spawnMine(0, "slow");
			spawnMine(2, "regular");
		}
		if (seconds==33){
			waveno=6;
			spawnMine(-3, "slow");
			spawnMine(-1, "slow");
			spawnMine(1, "slow");
			spawnMine(3, "slow");
		}
		
		if (seconds==38){
			waveno=7;
			spawnMine(0, "regular", true, false);
		}
		if (seconds==43){
			waveno=8;
			spawnMine(-2, "slow", true, false);
			spawnMine(0, "regular", true, false);
			spawnMine(2, "fast", true, false);
		}

		if (seconds==50) {
			waveno = 9;
			spawnMine(0, "regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==55) {
			waveno = 10;
			if (MathUtils.randomBoolean()){
				spawnMine(-1,"regular",true,true);
				spawnMine(1,"regular",false,true);
			}
			else{
				spawnMine(-1,"regular",false,true);
				spawnMine(1,"regular",true,true);
			}
		}
		if (seconds==60) {
			waveno = 11;
			spawnMine(-2, "slow", MathUtils.randomBoolean(), true);
			spawnMine(0, "slow", MathUtils.randomBoolean(), true);
			spawnMine(2, "slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==65) {
			waveno = 12;
			spawnMine(-2, "slow", MathUtils.randomBoolean(), true);
			spawnMine(0, "regular", MathUtils.randomBoolean(), true);
			spawnMine(2, "slow", MathUtils.randomBoolean(), true);
		}

		if (seconds==70){
			statusBar.vertVel=40;
		}
		if (seconds==72){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==78){
			game.setScreen(new Level_2(game, minecount));
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 1 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/12", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
