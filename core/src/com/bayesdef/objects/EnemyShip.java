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
	
	public boolean obscured = false;
	public int obscurityno = 1;
	public float obscuritytime = 0;
	
	
	public boolean actuallyExists=true;
	
   public Turret turret;
   public Mine attackingMine;
   
   public Rectangle shield;
   public int shieldCount=1;
   
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
	   
	   shield = new Rectangle();
	   shield.width=80;
	   shield.height=5;
	   shield.x=rect.x-10;
	   shield.y=rect.y-15;
	   
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
	   
	   normalise();
	   
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
   
   public EnemyShip(int xposn, float c, float o, float h, float p, float s, float t, boolean obs){
	   
	   this(xposn, c, o, h, p, s, t);
	   
	   obscured=obs;
   }
   
   public void normalise(){
	   
	   float tot = circleChance + octagonChance + hexagonChance + pentagonChance + squareChance + triangleChance;
	   
	   circleChance = circleChance/tot;
	   octagonChance = octagonChance/tot;
	   hexagonChance = hexagonChance/tot;
	   pentagonChance = pentagonChance/tot;
	   squareChance = squareChance/tot;
	   triangleChance = triangleChance/tot;
   
   }
   
   public void update_chances_on_fail(String type){
	   
	   if (type.equals("circle")){
		   circleChance=0;
	   }
	   if (type.equals("octagon")){
		   octagonChance=0;
	   }
	   if (type.equals("hexagon")){
		   hexagonChance=0;
	   }
	   if (type.equals("pentagon")){
		   pentagonChance=0;
	   }
	   if (type.equals("square")){
		   squareChance=0;
	   }
	   if (type.equals("triangle")){
		   triangleChance=0;
	   }
	   
	   normalise();
   
   }
   
   public void update_chances_on_shoot(String type){
	   if (type.equals("destroy")){
		   circleChance=0f*circleChance;
		   octagonChance=0.2f*octagonChance;
		   hexagonChance=0.4f*hexagonChance;
		   pentagonChance=0.6f*pentagonChance;
		   squareChance=0.8f*squareChance;
		   triangleChance=1f*triangleChance;
	   }
	   else{
		   circleChance=1f*circleChance;
		   octagonChance=0.8f*octagonChance;
		   hexagonChance=0.6f*hexagonChance;
		   pentagonChance=0.4f*pentagonChance;
		   squareChance=0.2f*squareChance;
		   triangleChance=0f*triangleChance;
	   }
	   normalise();
   }
   
   public void update_posn(float delta){
	   
	   rect.y = Math.max(rect.y+vertVel*delta, 300);
	   
	   turret.rect.x = rect.x + 10;
	   turret.rect.y = rect.y + 10;
	   
	   shield.x = rect.x - 10;
       shield.y = rect.y - 15;
	   
   }
}
