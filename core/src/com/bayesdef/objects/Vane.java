package com.bayesdef.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.bayesdef.resources.Textures;
public class Vane {
	   public Rectangle rect;
	   
	   public boolean targeted = false;
	   
	   public String energy = "none";
	   
	   public EnemyShip targetShip;
	   
	   public float firingTime = 0f;
	   public float firingDelta = 0f;
	   
	   public Texture selectedT = Textures.vaneTrim;
	   
	   public Vane(){
		   
		   rect=new Rectangle();
		   rect.width=50;
		   rect.height=50;
	   }
	   
}