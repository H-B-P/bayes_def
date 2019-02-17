package com.bayesdef.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Input.Keys;
import com.bayesdef.BayesDef;
import com.bayesdef.objects.Mine;
import com.bayesdef.objects.Shot;
import com.bayesdef.objects.Turret;
import com.bayesdef.resources.BGM;
import com.bayesdef.resources.Fonts;
import com.bayesdef.resources.Options;
import com.bayesdef.resources.Sounds;
import com.bayesdef.resources.Textures;

public class Level_2 extends ProbScreen{
    
	public Level_2(final BayesDef bd, int mc) {
		
		super(bd, mc);
		playerShip.shieldCount=3;
		
	}
	
	// ===Level-Specific Functions===
	
	@Override
	
	void level_specific_turret_setup(){
		
		Turret turretOne = new Turret("circle");
		Turret turretTwo = new Turret("circleplusplus");
		Turret turretThree = new Turret("circleplus");
		Turret turretFour = new Turret("circleplusplus");
		
		turretOne.rect.x = 50;
		turretTwo.rect.x = 110;
		turretThree.rect.x = 170;
		turretFour.rect.x = 230;
		
		turretOne.rect.y = 40;
		turretTwo.rect.y = 40;
		turretThree.rect.y = 40;
		turretFour.rect.y = 40;
		
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
		if (seconds==5){
			waveno=1;
			spawnMine(0);
		}
		if (seconds==10){
			waveno=2;
			spawnMine(0, "regular", true, false);
		}
		if (seconds==15){
			waveno=3;
			spawnMine(-3, "slow", true, false);
			spawnMine(0, "regular", true, false);
			spawnMine(3, "fast", true, false);
		}
		if (seconds==20){
			waveno=4;
			spawnMine(-3, "regular", true, false);
			spawnMine(-1, "regular", false, false);
			spawnMine(1, "regular", true, false);
			spawnMine(3, "regular", false, false);
		}
		if (seconds==30){
			waveno=5;
			spawnMine(0, "regular", false, false);
		}
		if (seconds==31){
			for (Mine mine: mines){
				mine.obscured=true;
			}
		}
		if (seconds==35){
			waveno=6;
			spawnMine(-1, "regular", false, false);
			spawnMine(2, "regular", true, false);
		}
		if (seconds==36){
			for (Mine mine: mines){
				mine.obscured=true;
			}
		}
		if (seconds==40){
			waveno=7;
			if (MathUtils.randomBoolean()){
				spawnMine(-2, "regular", false, false);
				spawnMine(0, "regular", false, false);
				spawnMine(2, "regular", true, false);
			}
		}
		if (seconds==41){
			for (Mine mine: mines){
				mine.obscured=true;
			}
		}
		if (seconds==45){
			waveno=8;
			if (MathUtils.randomBoolean()){
				spawnMine(-3, "fast", false, false);
				spawnMine(-1, "fast", true, false);
				spawnMine(1, "fast", true, false);
				spawnMine(3, "fast", false, false);
			}
			else{
				spawnMine(-3, "fast", true, false);
				spawnMine(-1, "fast", false, false);
				spawnMine(1, "fast", false, false);
				spawnMine(3, "fast", true, false);
			}
		}
		if (seconds==46){
			for (Mine mine: mines){
				mine.obscured=true;
			}
		}
		if (seconds==55){
			waveno=9;
			spawnMine(0, "regular", MathUtils.randomBoolean(), true);
		}
		if (seconds==60){
			waveno=10;
			spawnMine(-2, "regular", MathUtils.randomBoolean(), true);
			spawnMine(0, "regular", MathUtils.randomBoolean(), true);
			spawnMine(2, "regular", MathUtils.randomBoolean(), true);
		}
		
		if (seconds==65){
			waveno=11;
			spawnMine(-1, "slow", MathUtils.randomBoolean(), true);
			spawnMine(1, "regular", MathUtils.randomBoolean(), true);
			spawnMine(3, "slow", MathUtils.randomBoolean(), true);
		}
		if (seconds==70){
			waveno=12;
			spawnMine(-3, "slow", MathUtils.randomBoolean(), true);
			spawnMine(0, "regular", MathUtils.randomBoolean(), true);
			spawnMine(3, "fast", MathUtils.randomBoolean(), true);
		}


		if (seconds==75){
			statusBar.vertVel=40;
		}
		if (seconds==77){
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==83){
			//goto next level
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 2 ===", statusBar.rect.x+10, statusBar.rect.y+67, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/12", statusBar.rect.x+10, statusBar.rect.y+45, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "GHOSTS: SOME", statusBar.rect.x+10, statusBar.rect.y+25, 150, 1, true);
	}
	
	
}
