package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_5_old extends ProbScreen{

	String ghostNature="SOME";
	String wavex="2";

	public Level_5_old(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=4;

	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){

		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("circle");
		Turret turretThree = new Turret("circle",2);
		Turret turretFour = new Turret("circle",3);
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

		if (seconds==5 || seconds==6){
			waveno=1;
			spawnMine(-3,"fast");
			spawnMine(1,"fast");
			spawnMine(3,"slow");
		}
		if (seconds==11 || seconds==12){
			waveno=2;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}
		if (seconds==17 || seconds==18){
			waveno=3;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==23 || seconds==24){
			waveno=4;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==29 || seconds==30){
			waveno=5;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"fast");
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==35 || seconds==36){
			waveno=6;
			spawnMine(-3,"slow");
			spawnMine(-1,"fast");
			spawnMine(1,"slow");
			spawnMine(3,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==41 || seconds==42){
			waveno=7;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==47 || seconds==48){
			waveno=8;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}

		if (seconds==57){
			wavex="";
		}
		if (seconds==60){
			wavex="3";
		}

		if (seconds==63 || seconds==64 || seconds==65){
			waveno=9;
			spawnMine(-3,"fast");
			spawnMine(1,"fast");
			spawnMine(3,"slow");
		}
		if (seconds==70 || seconds==71 || seconds==72){
			waveno=10;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}
		if (seconds==77 || seconds==78 || seconds==79){
			waveno=11;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==84 || seconds==85 || seconds==86){
			waveno=12;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==91 || seconds==92 || seconds==93){
			waveno=13;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"fast");
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==98 || seconds==99 || seconds==100){
			waveno=14;
			spawnMine(-3,"slow");
			spawnMine(-1,"fast");
			spawnMine(1,"slow");
			spawnMine(3,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==105 || seconds==106 || seconds==107){
			waveno=15;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==112 || seconds==113 || seconds==114){
			waveno=16;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}

		if (seconds==117){
			wavex="";
		}
		if (seconds==120){
			wavex="4";
		}

		if (seconds==123 || seconds==124 || seconds==125 || seconds==126){
			waveno=17;
			spawnMine(-3,"fast");
			spawnMine(1,"fast");
			spawnMine(3,"slow");
		}
		if (seconds==131 || seconds==132 || seconds==134 || seconds==135){
			waveno=18;
			spawnMine(-3,"regular");
			spawnMine(-1,"regular");
			spawnMine(2,"fast");
		}
		if (seconds==139 || seconds==140 || seconds==141 || seconds==142){
			waveno=19;
			spawnMine(-2,"slow");
			spawnMine(0,"fast");
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==147 || seconds==148 || seconds==149 || seconds==150){
			waveno=20;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"regular");
			spawnMine(3,"regular");
		}
		if (seconds==155 || seconds==156 || seconds==157 || seconds==158){
			waveno=21;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"fast");
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==163 || seconds==164 || seconds==165 || seconds==166){
			waveno=22;
			spawnMine(-3,"slow");
			spawnMine(-1,"fast");
			spawnMine(1,"slow");
			spawnMine(3,"fast", MathUtils.randomBoolean(),true);
		}
		if (seconds==171 || seconds==172 || seconds==173 || seconds==174){
			waveno=23;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}
		if (seconds==179 || seconds==180 || seconds==181 || seconds==182){
			waveno=24;
			spawnMine(-3,"slow", MathUtils.randomBoolean(),true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(1,"slow", MathUtils.randomBoolean(),true);
			spawnMine(3,"slow", MathUtils.randomBoolean(),true);
		}

		if (seconds==190){
			wavex="";
		}
		if (seconds==193){
			wavex="5";
		}

		if (seconds==196 || seconds==197 || seconds==198 || seconds==199 || seconds==200){
			waveno=25;
			spawnMine(-2,"regular", MathUtils.randomBoolean(),true);
			spawnMine(0,"regular", MathUtils.randomBoolean(),true);
			spawnMine(2,"regular", MathUtils.randomBoolean(),true);
		}


		if (seconds==210){
			statusBar.vertVel=40;
		}
		if (seconds==212){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==218){
			//goto next level
		}
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 5 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*"+wavex+": "+waveno+"/25", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: "+ghostNature, statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);

		//Fonts.AcalcFonts.white.draw(batch, "Congrats", 80,260,160, 1, true);
		//Fonts.AcalcFonts.white.draw(batch, "you won", 80,240,160, 1, true);
		//Fonts.AcalcFonts.white.draw(batch, "good job", 80,220,160, 1, true);


		if (seconds>220){
			Fonts.AcalcFonts.white.draw(batch, "congrats", 80,220,160, 1, true);
		}
		if (seconds>222){
			Fonts.AcalcFonts.white.draw(batch, "you won", 80,240,160, 1, true);
		}
		if (seconds>224){
			Fonts.AcalcFonts.white.draw(batch, "good job", 80,260,160, 1, true);
		}


	}
	
	
}
