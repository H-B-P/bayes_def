package com.bayesdef.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class PlayerShip {
	public Rectangle rect;
	
	public float horzVel;
	public float vertVel;
	
	
	public boolean actuallyExists=true;
	
	public Rectangle shield;
	
	public int shieldCount=5;
	
   //EnemyShip target_enemy_ship;
   
   public PlayerShip(){
	   
	   rect = new Rectangle();
	   rect.width = 320;
	   rect.height = 480;
	   rect.x = 0;
	   //rect.y = 120-rect.height;
	   rect.y=-40-rect.height;
	   
	   
	   shield = new Rectangle();
	   shield.width=280;
	   shield.height=5;
	   shield.x=rect.x + 20;
       shield.y=rect.y+rect.height+15;
	   
	   vertVel = 80;
   }
   
   public void update_posn(float delta){
	   
	   rect.x = rect.x+horzVel*delta;
	   rect.y = Math.min(Math.max(rect.y+vertVel*delta, -60-rect.height),120-rect.height);
	   
	   shield.x=rect.x + 20;
       shield.y=rect.y+rect.height+15;
	   
   }
}
