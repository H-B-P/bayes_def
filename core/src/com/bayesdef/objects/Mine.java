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
   
   public boolean captureProof=false; //If a captureshot hits it, will it be captured?
   public boolean destroyProof=false; //If a destroyshot hits it, will it be destroyed?
   
   public boolean actuallyExists =true;
   public boolean beingDetained=false;
   
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
	   rect.y=440;
	   
	   vertVel = -115;
	   //vertVel = -78;
   }
   
   public Mine(int xposn, String typ){
	   
	   this(xposn);
	   
	   minetype = typ;
	   
	   if (minetype.equals("speedy")){
		   vertVel = -175;
	   }
	   if (minetype.equals("slow")){
		   vertVel = -80;
	   }
   }
   
   public void update_posn(float delta){
	   
	   rect.x += horzVel*delta;
	   rect.y += vertVel*delta;
	   
   }
}
