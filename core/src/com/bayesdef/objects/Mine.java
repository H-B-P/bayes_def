package com.bayesdef.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.bayesdef.objects.EnemyShip;

public class Mine {
	public Rectangle rect;
   
   public String minetype="regular";
   
   public boolean actuallyExists =true;
   public boolean beingDetained=false;
   
   public boolean ghostly=false;
   public boolean obscured=false;
   
   public float horzVel=0;
   public float vertVel=0;
   
   //EnemyShip target_enemy_ship;
   
   public Mine(EnemyShip enemyship){
	   
	   rect = new Rectangle();
	   rect.width = 40;
	   rect.height = 40;
	   rect.x = enemyship.turret.rect.x;
	   rect.y=-60;
	   
	   vertVel=115;
	   
   }
   
   public Mine(int xposn){
	   
	   rect = new Rectangle();
	   rect.width = 40;
	   rect.height = 40;
	   rect.x = (xposn * 40f+160f)-20f;
	   rect.y=420;
	   
	   vertVel = -103;
   }
   
   public Mine(int xposn, String typ){
	   
	   this(xposn);
	   
	   minetype = typ;
	   
	   if (minetype.equals("fast")){
		   vertVel = -155;
	   }
	   if (minetype.equals("slow")){
		   vertVel = -77;
	   }
   }
   
   public Mine(int xposn, String typ, boolean g, boolean o){
	   this(xposn, typ);
	   ghostly=g;
	   obscured=o;
   }
   
   public void update_posn(float delta){
	   
	   rect.x += horzVel*delta;
	   rect.y += vertVel*delta;
	   
   }
}
