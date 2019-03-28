package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_3 extends ProbScreen{

	public Level_3(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=3;
	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("circle",2);
		Turret turretThree = new Turret("circle",3);
		Turret turretFour = new Turret("triangle");
		
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

		turretThree.targetingXOffset=0;
		turretThree.targetingYOffset=-15;

		turretFour.targetingXOffset=0;
		turretFour.targetingYOffset=0;
		
		turrets.add(turretOne);
		turrets.add(turretTwo);
		turrets.add(turretThree);
		turrets.add(turretFour);
	}
	
	@Override
	
	void level_specific_events(){
		if (seconds==5 || seconds==6 || seconds==7){
			waveno=1;
			spawnMine(-2,"regular");
			spawnMine(0,"regular");
			spawnMine(2,"regular");
		}
		if (seconds==10 || seconds==11 || seconds==12){
			waveno=2;
			spawnMine(-3,"slow");
			spawnMine(-1,"slow");
			spawnMine(1,"slow");
			spawnMine(3,"slow");
		}

		if (seconds==16 || seconds==17 || seconds==18){
			waveno=3;
			spawnMine(-2,"fast");
			spawnMine(2,"fast");
		}

		if (seconds==20 || seconds==21 || seconds==22){
			waveno=4;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular");
		}

		if (seconds==26 || seconds==27 || seconds==28){
			waveno=5;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}





		if (seconds==33 || seconds==34 || seconds==35){
			waveno=6;
			spawnMine(-1,"regular", MathUtils.randomBoolean(), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==38 || seconds==39 || seconds==40){
			waveno=7;
			spawnMine(-3,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(), true);
		}

		if (seconds==44 || seconds==45 || seconds==46){
			waveno=8;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(0,"slow", MathUtils.randomBoolean(), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==50 || seconds==51 || seconds==52){
			waveno=9;
			spawnMine(-2,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"fast", MathUtils.randomBoolean(), true);
			spawnMine(2,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==56 || seconds==57 || seconds==58) {
			waveno = 10;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(3, "slow", MathUtils.randomBoolean(), true);
		}







		if (seconds==64 || seconds==65 || seconds==66){
			waveno=11;
			spawnMine(-3,"slow");
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
			spawnMine(3,"slow");
		}
		if (seconds==70 || seconds==71 || seconds==72){
			waveno=12;
			spawnMine(-2,"fast");
			spawnMine(2,"fast", MathUtils.randomBoolean(), true);
		}

		if (seconds==74 || seconds==75 || seconds==76){
			waveno=13;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(), true);
			spawnMine(3,"regular");
		}
		if (seconds==80 || seconds==81 || seconds==82){
			waveno=14;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==86 || seconds==87 || seconds==88){
			waveno=15;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(), true);
			spawnMine(2,"fast");
		}

		if (seconds==91 || seconds==92 || seconds==93){
			waveno=16;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow");
			spawnMine(3, "slow");
		}
		if (seconds==97 || seconds==98 || seconds==99){
			waveno=17;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(3, "regular");
		}
		if (seconds==103 || seconds==104 || seconds==105){
			waveno=18;
			spawnMine(-3, "slow");
			spawnMine(-1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(3, "slow");
		}
		if (seconds==109 || seconds==110 || seconds==111){
			waveno=19;
			spawnMine(-3, "slow");
			spawnMine(-1, "slow");
			spawnMine(1, "slow");
			spawnMine(3, "fast", MathUtils.randomBoolean(), true);
		}
		if (seconds==115 || seconds==116 || seconds==117){
			waveno=20;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow");
			spawnMine(3, "regular");
		}

		if (seconds==122){
			statusBar.vertVel=40;
		}
		if (seconds==124){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==130){
			game.setScreen(new Level_pi(game, minecount));
		}
	}

	@Override

	void level_specific_failure(){
		game.setScreen(new Level_3(game, originalMinecount));
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 3/4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*3: "+waveno+"/20", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
