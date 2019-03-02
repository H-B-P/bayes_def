package com.bayesdef.objects;
import com.badlogic.gdx.math.MathUtils;


import com.badlogic.gdx.math.Rectangle;

public class Shot {
	   public Rectangle rect;
	   
	   public String type;
	   
	   public float vertVel;
	   public float horzVel;
	   
	   public Mine targetMine;
	   //EnemyShip enemyShip
	   
	   public boolean doomedToMiss = false;
	   
	   public Shot(Rectangle originR, Mine targetmine, float shotspeed, String typ){

		   type = typ;

		   if (typ.equals("doomed capture")) {
			   type = "capture";
			   doomedToMiss = true;
		   }
		   if (typ.equals("doomed destroy")){
			   type = "destroy";
			   doomedToMiss=true;
		   }
		   
		   targetMine=targetmine;
		   
		   
		   if (type.equals("capture")){
			   shotspeed=shotspeed*0.6f;
		   }
		   
		   
		   rect = new Rectangle();
		   
		   if (type.equals("destroy")){
			   rect.height=1;
			   rect.width=1;
		   }
		   else{
			   rect.height=15;
			   rect.width=15;
		   }
		   
		   float originX = originR.x+originR.width/2;
		   float originY = originR.y+originR.height;
		   
		   if (type.equals("destroy")){
			   //originY+=5;
		   }
		   
		   rect.setCenter(originX, originY);
		   
		   
		   float destX = targetMine.rect.x + targetMine.rect.width/2;
		   float destY = targetMine.rect.y + targetMine.rect.height/2;
		   
		   //If you want to make it miss in a show-not-tell way then least terrible approach is to mess with dest here.
		   
		   double jumpX = destX - originX;
		   double jumpY = destY - originY;
		   
		   double jumpMag = Math.sqrt(jumpX*jumpX+jumpY*jumpY);
		   
		   horzVel = (float) (jumpX/jumpMag)*shotspeed;
		   vertVel = (float) (jumpY/jumpMag)*shotspeed;
		   
	   }
	   public Shot(Rectangle origin_r, float dest_x, float dest_y, float shotspeed, String typ){

	   	   type = typ;
		   if (typ.equals("doomed capture")) {
			   type = "capture";
			   doomedToMiss = true;
		   }
		   if (typ.equals("doomed destroy")) {
			   type = "destroy";
			   doomedToMiss = true;
		   }
		   
		   if (type.equals("capture")){
			   shotspeed=shotspeed*0.6f;
		   }
		   
		   float origin_x=origin_r.x+origin_r.width/2;
		   float origin_y=origin_r.y;
		   
		   rect=new Rectangle();
		   
		   if (type.equals("destroy")){
			   rect.height=1;
			   rect.width=1;
		   }
		   else{
			   rect.height=15;
			   rect.width=15;
		   }
		   
		   rect.setCenter(origin_x, origin_y);
		   
		   double jump_x=dest_x-origin_x;
		   double jump_y=dest_y-origin_y;
		   
		   double jump_mag=Math.sqrt(jump_x*jump_x+jump_y*jump_y);
		   
		   horzVel=(float) (jump_x/jump_mag)*shotspeed;
		   vertVel=(float) (jump_y/jump_mag)*shotspeed;
	   }
	   
	   public void update_posn(float delta){
		 rect.x += horzVel*delta;
		 rect.y += vertVel*delta;
	   }
}