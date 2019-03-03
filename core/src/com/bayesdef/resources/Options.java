package com.bayesdef.resources;

public class Options {
	public static float SFXVolume;
	public static float MusicVolume;
	
	public static boolean waitForFiringButton;
	
	public static boolean permitFlickering;

	public static String autocalcSettings;

	public static void load () {
		SFXVolume=1f;
		MusicVolume=0.8f;
		
		waitForFiringButton=false;
		permitFlickering=true;

		autocalcSettings="preal";

	}
}
