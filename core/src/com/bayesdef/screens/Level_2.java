package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_2 extends ProbScreen{

	boolean flipone;
	boolean fliptwo;

	public Level_2(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=2;

		flipone=MathUtils.randomBoolean();
		fliptwo=MathUtils.randomBoolean();
	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle",2);
		Turret turretTwo = new Turret("circle",2);
		Turret turretThree = new Turret("circle");
		Turret turretFour = new Turret("circle");
		
		turretOne.rect.x = 50;
		turretTwo.rect.x = 110;
		turretThree.rect.x = 170;
		turretFour.rect.x = 230;
		
		turretOne.rect.y = -40;
		turretTwo.rect.y = -40;
		turretThree.rect.y = -40;
		turretFour.rect.y = -40;
		
		turretOne.targetingXOffset=-15;
		turretOne.targetingYOffset=15;

		turretTwo.targetingXOffset=15;
		turretTwo.targetingYOffset=15;

		turretThree.targetingXOffset=-15;
		turretThree.targetingYOffset=-15;

		turretFour.targetingXOffset=15;
		turretFour.targetingYOffset=-15;
		
		turrets.add(turretOne);
		turrets.add(turretTwo);
		turrets.add(turretThree);
		turrets.add(turretFour);
	}
	
	@Override
	
	void level_specific_events(){
		if (seconds==5 || seconds==6){
			waveno=1;
			spawnMine(-1,"regular");
			spawnMine(1,"slow");
		}
		if (seconds==11 || seconds==12){
			waveno=2;

			spawnMine(-2,"slow");
			spawnMine(0,"slow");
			spawnMine(2,"slow");
		}
		if (seconds==17 || seconds==18){
			waveno=3;
			spawnMine(-3,"slow");
			spawnMine(-1,"slow");
			spawnMine(2,"regular");
		}
		if (seconds==23 || seconds==24){
			waveno=4;
			spawnMine(-1,"slow");
			spawnMine(1,"fast");
		}
		if (seconds==29 || seconds==30){
			waveno=5;
			spawnMine(-2,"regular");
			spawnMine(0,"slow");
			spawnMine(2,"regular");
		}
		if (seconds==35 || seconds==36){
			waveno=6;
			spawnMine(-3,"slow");
			spawnMine(1,"regular");
			spawnMine(3,"slow");
		}

		if (seconds==43){
			waveno=7;
			spawnMine(-2,"regular", MathUtils.randomBoolean(), false);
			spawnMine(0,"regular", flipone, false);
			spawnMine(2,"regular", !flipone, false);
		}
		if (seconds==44){
			spawnMine(-2,"regular", MathUtils.randomBoolean(),false);
			spawnMine(0,"regular", !flipone, false);
			spawnMine(2,"regular", MathUtils.randomBoolean(), false);
		}

		if (seconds==49){
			waveno=8;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),false);
			spawnMine(-1,"regular", fliptwo, false);
			spawnMine(1,"slow", MathUtils.randomBoolean(),false);
			spawnMine(3,"regular", !fliptwo, false);
		}
		if (seconds==50){
			spawnMine(-3,"slow", MathUtils.randomBoolean(),false);
			spawnMine(-1,"regular", !fliptwo, false);
			spawnMine(1,"slow", MathUtils.randomBoolean(),false);
			spawnMine(3,"regular", MathUtils.randomBoolean(),false);
		}

		if (seconds==57 || seconds==58){
			waveno=9;
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==63 || seconds==64){
			waveno=10;
			spawnMine(-1,"slow", MathUtils.randomBoolean(), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==69 || seconds==70){
			waveno=11;
			spawnMine(-1,"slow", MathUtils.randomBoolean(), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==75 || seconds==76){
			waveno=12;
			spawnMine(-2,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"slow", MathUtils.randomBoolean(), true);
			spawnMine(2,"slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==81 || seconds==82){
			waveno=13;
			spawnMine(-2,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"slow");
			spawnMine(2,"slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==87 || seconds==88){
			waveno=14;
			spawnMine(-2,"regular");
			spawnMine(0,"slow", MathUtils.randomBoolean(), true);
			spawnMine(2,"slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==93 || seconds==94){
			waveno=15;
			spawnMine(-2,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
			spawnMine(2,"slow");
		}
		if (seconds==99 || seconds==100){
			waveno=16;
			spawnMine(-2,"slow");
			spawnMine(0,"slow", MathUtils.randomBoolean(), true);
			spawnMine(2,"regular");
		}

		if (seconds==106){
			statusBar.vertVel=40;
		}
		if (seconds==108){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==114){
			game.setScreen(new Level_3(game, minecount));
		}
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 2 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*2: "+waveno+"/16", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
