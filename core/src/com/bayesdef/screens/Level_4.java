package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_4 extends ProbScreen{

	String ghostNature="SOME";
	String wavex="2";

	public Level_4(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=2;

	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){

		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("circle");
		Turret turretThree = new Turret("circle",2);
		Turret turretFour = new Turret("circle",4);
		Turret turretFive = new Turret("triangle");

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

		turretOne.targetingXOffset=-15;
		turretOne.targetingYOffset=15;

		turretTwo.targetingXOffset=15;
		turretTwo.targetingYOffset=15;

		turretThree.targetingXOffset=-15;
		turretThree.targetingYOffset=-15;

		turretFour.targetingXOffset=15;
		turretFour.targetingYOffset=-15;

		turretFive.targetingXOffset=0;
		turretFive.targetingYOffset=0;

		turrets.add(turretOne);
		turrets.add(turretTwo);
		turrets.add(turretThree);
		turrets.add(turretFour);
		turrets.add(turretFive);
	}
	
	@Override
	
	void level_specific_events(){

		if (seconds==5 || seconds==6 || seconds==7 || seconds==8){
			waveno=1;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}
		if (seconds==11 || seconds==12 || seconds==13 || seconds==14){
			waveno=2;
			spawnMine(-3,"fast");
			spawnMine(1,"fast");
			spawnMine(3,"slow");
		}
		if (seconds==18 || seconds==19 || seconds==20 || seconds==21){
			waveno=3;
			spawnMine(-3,"slow");
			spawnMine(-1,"regular");
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==25 || seconds==26 || seconds==27 || seconds==28){
			waveno=4;
			spawnMine(-3,"fast");
			spawnMine(-1,"regular");
			spawnMine(1,"slow");
			spawnMine(3,"slow");
		}
		if (seconds==32 || seconds==33 || seconds==34 || seconds==35){
			waveno=5;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==39 || seconds==40 || seconds==41 || seconds==42){
			waveno=6;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==46 || seconds==47 || seconds==48 || seconds==49){
			waveno=7;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"fast");
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==53 || seconds==54 || seconds==55 || seconds==56){
			waveno=8;
			spawnMine(-3,"slow");
			spawnMine(-1,"fast");
			spawnMine(1,"slow");
			spawnMine(3,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==60 || seconds==61 || seconds==62 || seconds==63){
			waveno=9;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==66 || seconds==67 || seconds==68 || seconds==69){
			waveno=10;
			spawnMine(-2,"fast", MathUtils.randomBoolean(),true);
			spawnMine(2,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==71 || seconds==72 || seconds==73 || seconds==74){
			waveno=11;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==78 || seconds==79 || seconds==80 || seconds==81){
			waveno=12;
			spawnMine(-2,"slow", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"fast", MathUtils.randomBoolean(),true);
		}


		if (seconds==86){
			statusBar.vertVel=40;
		}
		if (seconds==88){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
	}

	@Override

	void level_specific_failure(){
		game.setScreen(new Level_4(game, originalMinecount));
	}

	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 4/4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*4: "+waveno+"/12", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: "+ghostNature, statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);


		if (seconds>94){
			Fonts.AcalcFonts.white.draw(batch, "congrats", 80,260,160, 1, true);
		}
		if (seconds>96){
			Fonts.AcalcFonts.white.draw(batch, "you won", 80,240,160, 1, true);
		}
		if (seconds>98){
			Fonts.AcalcFonts.white.draw(batch, "good job", 80,220,160, 1, true);
		}


	}
	
	
}
