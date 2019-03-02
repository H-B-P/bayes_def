package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_4 extends ProbScreen{

	String ghostNature="SOME";
	int firstAnomaly;
	int secondAnomaly;

	public Level_4(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=2;

		firstAnomaly = MathUtils.random(1,4);
		secondAnomaly = MathUtils.random(1,4);

	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle",4);
		Turret turretTwo = new Turret("circle",3);
		Turret turretThree = new Turret("circle",2);
		Turret turretFour = new Turret("circle",1);
		
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
		if (seconds==2){
			ghostNature="";
		}
		if (seconds==4){
			ghostNature="FEW";
		}
		if (seconds==6){
			waveno=1;
			if (firstAnomaly==1){
				spawnMine(-3,"regular", true, false);
			}
			else{
				spawnMine(-3,"regular");
			}
			if (firstAnomaly==2){
				spawnMine(-1,"regular", true, false);
			}
			else{
				spawnMine(-1,"regular");
			}
			if (firstAnomaly==3){
				spawnMine(1,"regular", true, false);
			}
			else{
				spawnMine(1,"regular");
			}
			if (firstAnomaly==4){
				spawnMine(3,"regular", true, false);
			}
			else{
				spawnMine(3,"regular");
			}
		}
		if (seconds==7){
			if (firstAnomaly==1){
				spawnMine(-3,"regular");
			}
			else{
				spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), false);
			}
			if (firstAnomaly==2){
				spawnMine(-1,"regular");
			}
			else{
				spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), false);
			}
			if (firstAnomaly==3){
				spawnMine(1,"regular");
			}
			else{
				spawnMine(1,"regular", MathUtils.randomBoolean(0.2f), false);
			}
			if (firstAnomaly==4){
				spawnMine(3,"regular");
			}
			else{
				spawnMine(3,"regular", MathUtils.randomBoolean(0.2f), false);
			}
		}

		if (seconds==12 || seconds==13){
			waveno=2;
			spawnMine(-2,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(0,"regular", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==18 || seconds==19){
			waveno=3;
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==24 || seconds==25){
			waveno=4;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==30 || seconds==31){
			waveno=5;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==36 || seconds==37){
			waveno=6;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(2,"fast", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==42 || seconds==43){
			waveno=7;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==48 || seconds==49){
			waveno=8;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"fast", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==50){
			ghostNature="";
		}
		if (seconds==52){
			ghostNature="MANY";
		}

		if (seconds==54){
			waveno=9;
			if (secondAnomaly==1){
				spawnMine(-3,"regular");
			}
			else{
				spawnMine(-3,"regular", true, false);
			}
			if (secondAnomaly==2){
				spawnMine(-1,"regular");
			}
			else{
				spawnMine(-1,"regular", true, false);
			}
			if (secondAnomaly==3){
				spawnMine(1,"regular");
			}
			else{
				spawnMine(1,"regular", true, false);
			}
			if (secondAnomaly==4){
				spawnMine(3,"regular");
			}
			else{
				spawnMine(3,"regular", true, false);
			}
		}
		if (seconds==55){
			if (secondAnomaly==1){
				spawnMine(-3,"regular", true, false);
			}
			else{
				spawnMine(-3,"regular", MathUtils.randomBoolean(0.8f), false);
			}
			if (secondAnomaly==2){
				spawnMine(-1,"regular", true, false);
			}
			else{
				spawnMine(-1,"regular", MathUtils.randomBoolean(0.8f), false);
			}
			if (secondAnomaly==3){
				spawnMine(1,"regular", true, false);
			}
			else{
				spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), false);
			}
			if (secondAnomaly==4){
				spawnMine(3,"regular", true, false);
			}
			else{
				spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), false);
			}
		}

		if (seconds==60 || seconds==61){
			waveno=10;
			spawnMine(0,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(2,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==66 || seconds==67){
			waveno=11;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==72 || seconds==73){
			waveno=12;
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==78 || seconds==79){
			waveno=13;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==84 || seconds==85){
			waveno=14;
			spawnMine(-2,"fast", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==90 || seconds==91){
			waveno=15;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==96 || seconds==97){
			waveno=16;
			spawnMine(-3,"fast", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.8f), true);
		}



		if (seconds==104){
			statusBar.vertVel=40;
		}
		if (seconds==106){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==112){
			//goto next level
		}
	}


	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*2: "+waveno+"/16", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: "+ghostNature, statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
