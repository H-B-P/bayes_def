package com.bayesdef.objects;

import com.badlogic.gdx.math.Rectangle;

public class StatusBar {
	public Rectangle rect;

	public float horzAcc=0;
	public float vertAcc=0;

	public float horzVel=0;
	public float vertVel=0;


	public boolean actuallyExists=true;
	public boolean restrained=true;

   public StatusBar(){
	   
	   rect = new Rectangle();
	   rect.width = 320;
	   rect.height = 80;
	   rect.x = 0;
	   rect.y = 400;
   }
   
   public void update_posn(float delta){
	   
	   horzVel = horzVel + horzAcc*delta;
	   vertVel = vertVel + vertAcc*delta;
	   
	   if (restrained){
		   rect.x = rect.x+horzVel*delta;
		   rect.y = Math.min(Math.max(rect.y+vertVel*delta, 400),480);
	   }
	   else{
		   rect.x = rect.x + horzVel*delta;
		   rect.y = rect.y + vertVel*delta;
	   }
   }
}
