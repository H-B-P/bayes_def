package com.bayesdef.screens;

import com.badlogic.gdx.math.MathUtils;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.Fonts;

public class Level_0_restarted extends ProbScreen{

	public Level_0_restarted(final BayesDef bd, int mc) {

		super(bd, mc);
		playerShip.shieldCount=0;

	}
	
	// ===Level-Specific Functions===

	@Override
	void level_specific_failure(){
		game.setScreen(new Level_0_restarted(game, originalMinecount));
	}

	@Override
	
	void level_specific_turret_setup(){
		Turret turretOne = new Turret("triangle");

		turretOne.rect.x = 140;

		turretOne.rect.y = -40;

		turretOne.targetingXOffset=0;
		turretOne.targetingYOffset=0;

		turrets.add(turretOne);
	}
	@Override
	
	void level_specific_events(){
		if (seconds==5){
			waveno=1;
			spawnMine(0, "regular");
		}
		if (seconds==8){
			waveno=2;
			spawnMine(-1, "regular");
			spawnMine(1, "regular");
		}
		if (seconds==11){
			waveno=3;
			spawnMine(-2, "slow");
			spawnMine(0, "regular");
			spawnMine(2, "fast");
		}
		if (seconds==14){
			waveno=4;
			spawnMine(0,"regular",true,false);
		}
		if (seconds==17){
			waveno=5;
			spawnMine(-3, "fast", true,false);
			spawnMine(-1, "regular");
			spawnMine(1, "regular");
			spawnMine(3, "slow", true,false);
		}
		if (seconds==21){
			waveno=6;
			spawnMine(0,"regular",MathUtils.randomBoolean(),true);
		}
		if (seconds==24){
			waveno=7;
			if (MathUtils.randomBoolean()){
				spawnMine(-1,"regular",true,true);
				spawnMine(1,"regular",false,true);
			}
			else{
				spawnMine(-1,"regular",false,true);
				spawnMine(1,"regular",true,true);
			}
		}
		if (seconds==27){
			waveno=8;
			spawnMine(-2, "slow", MathUtils.randomBoolean(),true);
			spawnMine(0, "slow",MathUtils.randomBoolean(),true);
			spawnMine(2, "slow", MathUtils.randomBoolean(),true);
		}
		if (seconds==32){
			statusBar.vertVel=40;
		}
		if (seconds==34){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==40){
			game.setScreen(new Level_1(game, minecount));
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 0/4 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/8", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
