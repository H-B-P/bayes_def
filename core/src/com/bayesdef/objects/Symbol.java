package com.bayesdef.objects;
import com.badlogic.gdx.math.MathUtils;


import com.badlogic.gdx.math.Rectangle;

public class Symbol {
	   public Rectangle rect;
	   
	   public String type;
	   
	   public float vertVel;
	   public float horzVel;
	   
	   public EnemyShip enemyShip;
	   
	   public boolean doomedToMiss = false;
	   
	   public Symbol(Rectangle originR, EnemyShip es, float shotspeed, String typ){
		   
		   type = typ;
		   
		   enemyShip = es;
		   
		   rect = new Rectangle();
		   rect.height=40;
		   rect.width=40;
		   
		   float originX = originR.x+originR.width/2;
		   float originY = originR.y+originR.height/2;
		   
		   rect.setCenter(originX, originY);
		   
		   float destX = enemyShip.rect.x + enemyShip.rect.width/2;
		   float destY = enemyShip.rect.y + enemyShip.rect.height/2;
		   
		   double jumpX = destX - originX;
		   double jumpY = destY - originY;
		   
		   double jumpMag = Math.sqrt(jumpX*jumpX+jumpY*jumpY);
		   
		   horzVel = (float) (jumpX/jumpMag)*shotspeed;
		   vertVel = (float) (jumpY/jumpMag)*shotspeed;
		   
	   }
	   
	   public void update_posn(float delta){
		 rect.x += horzVel*delta;
		 rect.y += vertVel*delta;
	   }
}