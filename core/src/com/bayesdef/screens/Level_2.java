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
		Turret turretTwo = new Turret("circleplus");
		Turret turretThree = new Turret("circleplusplus");
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
			playerShip.restrained=false;
			playerShip.vertVel=40;
			playerShip.vertAcc=40;
		}
		if (seconds==15){
			//goto next level
		}
	}
	
	@Override
	
	void level_specific_huddery(){
		Fonts.AcalcFonts.black.draw(batch, "=== Level 2 ===", 10, 467, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "WAVE: "+waveno+"/10", 10, 445, 150, 1, true);
		Fonts.AcalcFonts.black.draw(batch, "DECOYS: SOME", 10, 425, 150, 1, true);
	}
	
	
}
