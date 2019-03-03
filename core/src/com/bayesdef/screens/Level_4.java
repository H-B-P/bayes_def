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
		playerShip.shieldCount=3;

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
		if (seconds==15 || seconds==16 || seconds==17 || seconds==18){
			waveno=2;
			spawnMine(-3,"fast");
			spawnMine(1,"fast");
			spawnMine(3,"slow");
		}
		if (seconds==25 || seconds==26 || seconds==27 || seconds==28){
			waveno=3;
			spawnMine(-3,"slow");
			spawnMine(-1,"regular");
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==35 || seconds==36 || seconds==37 || seconds==38){
			waveno=4;
			spawnMine(-3,"fast");
			spawnMine(-1,"regular");
			spawnMine(1,"slow");
			spawnMine(3,"slow");
		}
		if (seconds==45 || seconds==46 || seconds==47 || seconds==48){
			waveno=5;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==55 || seconds==56 || seconds==57 || seconds==58){
			waveno=6;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==65 || seconds==66 || seconds==67 || seconds==68){
			waveno=7;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"fast");
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==75 || seconds==76 || seconds==77 || seconds==78){
			waveno=8;
			spawnMine(-3,"slow");
			spawnMine(-1,"fast");
			spawnMine(1,"slow");
			spawnMine(3,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==85 || seconds==86 || seconds==87 || seconds==88){
			waveno=9;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==95 || seconds==96 || seconds==97 || seconds==98){
			waveno=10;
			spawnMine(-2,"fast", MathUtils.randomBoolean(),true);
			spawnMine(2,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==105 || seconds==106 || seconds==107 || seconds==108){
			waveno=11;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==115 || seconds==116 || seconds==117 || seconds==118){
			waveno=12;
			spawnMine(-2,"slow", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"fast", MathUtils.randomBoolean(),true);
		}


		if (seconds==125){
			statusBar.vertVel=40;
		}
		if (seconds==127){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*4: "+waveno+"/12", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: "+ghostNature, statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);


		if (seconds>140){
			Fonts.AcalcFonts.white.draw(batch, "congrats", 80,260,160, 1, true);
		}
		if (seconds>142){
			Fonts.AcalcFonts.white.draw(batch, "you won", 80,240,160, 1, true);
		}
		if (seconds>144){
			Fonts.AcalcFonts.white.draw(batch, "good job", 80,220,160, 1, true);
		}


	}
	
	
}
