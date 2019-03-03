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
		if (seconds==12 || seconds==13 || seconds==14){
			waveno=2;
			spawnMine(-3,"slow");
			spawnMine(-1,"slow");
			spawnMine(1,"slow");
			spawnMine(3,"slow");
		}

		if (seconds==19 || seconds==20 || seconds==21){
			waveno=3;
			spawnMine(-2,"fast");
			spawnMine(2,"fast");
		}

		if (seconds==26 || seconds==27 || seconds==28){
			waveno=4;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular");
		}

		if (seconds==33 || seconds==34 || seconds==35){
			waveno=5;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}





		if (seconds==42 || seconds==43 || seconds==44){
			waveno=6;
			spawnMine(-1,"regular", MathUtils.randomBoolean(), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==49 || seconds==50 || seconds==51){
			waveno=7;
			spawnMine(-3,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(), true);
		}

		if (seconds==56 || seconds==57 || seconds==58){
			waveno=8;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(0,"slow", MathUtils.randomBoolean(), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==63 || seconds==64 || seconds==65){
			waveno=9;
			spawnMine(-2,"slow", MathUtils.randomBoolean(), true);
			spawnMine(0,"fast", MathUtils.randomBoolean(), true);
			spawnMine(2,"regular", MathUtils.randomBoolean(), true);
		}

		if (seconds==70 || seconds==71 || seconds==72) {
			waveno = 10;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(3, "slow", MathUtils.randomBoolean(), true);
		}







		if (seconds==80 || seconds==81 || seconds==82){
			waveno=11;
			spawnMine(-3,"slow");
			spawnMine(0,"regular", MathUtils.randomBoolean(), true);
			spawnMine(3,"slow");
		}
		if (seconds==88 || seconds==89 || seconds==90){
			waveno=12;
			spawnMine(-2,"fast");
			spawnMine(2,"fast", MathUtils.randomBoolean(), true);
		}

		if (seconds==96 || seconds==97 || seconds==98){
			waveno=13;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(), true);
			spawnMine(3,"regular");
		}
		if (seconds==104 || seconds==105 || seconds==106){
			waveno=14;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==112 || seconds==113 || seconds==114){
			waveno=15;
			spawnMine(-3,"regular", MathUtils.randomBoolean(), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(), true);
			spawnMine(2,"fast");
		}

		if (seconds==120 || seconds==121 || seconds==122){
			waveno=16;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow");
			spawnMine(3, "slow");
		}
		if (seconds==128 || seconds==129 || seconds==130){
			waveno=17;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(3, "regular");
		}
		if (seconds==136 || seconds==137 || seconds==138){
			waveno=18;
			spawnMine(-3, "slow");
			spawnMine(-1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(3, "slow");
		}
		if (seconds==144 || seconds==145 || seconds==146){
			waveno=19;
			spawnMine(-3, "slow");
			spawnMine(-1, "slow");
			spawnMine(1, "slow");
			spawnMine(3, "fast", MathUtils.randomBoolean(), true);
		}
		if (seconds==152 || seconds==153 || seconds==154){
			waveno=20;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(-1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(1, "slow");
			spawnMine(3, "regular");
		}

		if (seconds==160){
			statusBar.vertVel=40;
		}
		if (seconds==162){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==168){
			game.setScreen(new Level_pi(game, minecount));
		}
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 3 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*3: "+waveno+"/20", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
