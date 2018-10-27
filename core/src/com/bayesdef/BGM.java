package com.bayesdef;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BGM {
	public static Music campaignMusic;
	
	public static void load () {
		campaignMusic=Gdx.audio.newMusic(Gdx.files.internal("music/Song2_final.wav"));
	}
}
