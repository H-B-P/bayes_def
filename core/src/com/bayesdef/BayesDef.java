package com.bayesdef;

/*
 * ~SUMMARY~
 * 
 * This is the actual game.
 * It's pretty empty: all the fun happens in the screens, which we hand off to as soon as possible.
 * 
 */

import com.badlogic.gdx.Game;
import com.bayesdef.resources.BGM;
import com.bayesdef.resources.Fonts;
import com.bayesdef.resources.Options;
import com.bayesdef.resources.Sounds;
import com.bayesdef.resources.Textures;
import com.bayesdef.screens.*;

public class BayesDef extends Game {
	
	
	public void create() {
		
		Textures.load();
		Sounds.load();
		Fonts.load();
		BGM.load();
		
		Options.load();
		
		
		this.setScreen(new Level_0(this, 0)); //Hand off to initial screen.
		
	}

	public void render() {
		super.render(); // I deleted this once and I deeply regretted it.
	}

}