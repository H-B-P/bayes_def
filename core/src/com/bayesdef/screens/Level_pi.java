package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_pi extends ProbScreen{

	String ghostNature="SOME";
	int firstAnomaly;
	int secondAnomaly;

	public Level_pi(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=2;

		firstAnomaly = MathUtils.random(1,4);
		secondAnomaly = MathUtils.random(1,4);

	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle",3);
		Turret turretTwo = new Turret("circle",1);
		Turret turretThree = new Turret("circle",4);
		Turret turretFour = new Turret("circle",2);
		
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
		if (seconds==4){
			ghostNature="";
		}
		if (seconds==6){
			ghostNature="FEW";
		}
		if (seconds==8){
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
		if (seconds==9){
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

		if (seconds==16 || seconds==17){
			waveno=3;
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==21 || seconds==22){
			waveno=4;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==25 || seconds==26){
			waveno=5;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==30 || seconds==31){
			waveno=6;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(2,"fast", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==34 || seconds==35){
			waveno=7;
			spawnMine(-3,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==39 || seconds==40){
			waveno=8;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.2f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.2f), true);
			spawnMine(3,"fast", MathUtils.randomBoolean(0.2f), true);
		}

		if (seconds==46){
			ghostNature="";
		}
		if (seconds==48){
			ghostNature="MANY";
		}

		if (seconds==50){
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
		if (seconds==51){
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

		if (seconds==54 || seconds==55){
			waveno=10;
			spawnMine(0,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(2,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==58 || seconds==59){
			waveno=11;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==63 || seconds==64){
			waveno=12;
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==67 || seconds==68){
			waveno=13;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==72 || seconds==73){
			waveno=14;
			spawnMine(-2,"fast", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==76 || seconds==77){
			waveno=15;
			spawnMine(-3,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"regular", MathUtils.randomBoolean(0.8f), true);
		}

		if (seconds==81 || seconds==82){
			waveno=16;
			spawnMine(-3,"fast", MathUtils.randomBoolean(0.8f), true);
			spawnMine(-1,"regular", MathUtils.randomBoolean(0.8f), true);
			spawnMine(1,"slow", MathUtils.randomBoolean(0.8f), true);
			spawnMine(3,"slow", MathUtils.randomBoolean(0.8f), true);
		}



		if (seconds==88){
			statusBar.vertVel=40;
		}
		if (seconds==90){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==96){
			game.setScreen(new Level_4(game, minecount));
		}
	}

	@Override

	void level_specific_failure(){
		game.setScreen(new Level_pi(game, originalMinecount));
	}

	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level pi/4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE*2: "+waveno+"/16", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: "+ghostNature, statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
