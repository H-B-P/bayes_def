package com.bayesdef.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemyShip {
	public Rectangle rect;
	
	public float vertVel;
	
	public boolean obscured;
	public boolean actuallyExists=true;
	
   public Turret turret;
   
   public float circleChance;
   public float octagonChance;
   public float hexagonChance;
   public float pentagonChance;
   public float squareChance;
   public float triangleChance;
   
   public float originalCircleChance;
   public float originalOctagonChance;
   public float originalHexagonChance;
   public float originalPentagonChance;
   public float originalSquareChance;
   public float originalTriangleChance;
   
   //EnemyShip target_enemy_ship;
   
   public EnemyShip(int xposn){
	   
	   rect = new Rectangle();
	   rect.width = 60;
	   rect.height = 60;
	   rect.x = (xposn * 50f+160f)-30f;
	   rect.y=440;
	   
	   vertVel = -70;
   }
   
   public EnemyShip(int xposn, float c, float o, float h, float p, float s, float t){
	   
	   this(xposn);
	   
	   circleChance = originalCircleChance = c;
	   octagonChance = originalOctagonChance = o;
	   hexagonChance = originalHexagonChance = h;
	   pentagonChance = originalPentagonChance = p;
	   squareChance = originalSquareChance = s;
	   triangleChance = originalTriangleChance = t;
	   
	   double a = Math.random();
	   
	   if (a<circleChance){
		   turret = new Turret("circle");
	   }
	   else if (a<(circleChance+octagonChance)){
		   turret = new Turret("octagon");
	   }
	   else if (a<(circleChance+octagonChance+hexagonChance)){
		   turret = new Turret("hexagon");
	   }
	   else if (a<(circleChance+octagonChance+hexagonChance+pentagonChance)){
		   turret = new Turret("pentagon");
	   }
	   else if (a<(circleChance+octagonChance+hexagonChance+pentagonChance+squareChance)){
		   turret = new Turret("square");
	   }
	   else{
		   turret = new Turret("triangle");
	   }
   }
   
   public void update_posn(float delta){
	   
	   rect.y = Math.max(rect.y+vertVel*delta, 300);
	   turret.rect.x = rect.x+10;
	   turret.rect.y = rect.y+10;
	   
   }
}
