package com.bayesdef.objects;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.bayesdef.resources.Textures;

public class Turret {
	   public Rectangle rect;
	   
	   public Texture normalT;
	   public Texture firingT;
	   public Texture selectedT;
	   public Texture silhouetteT;
	   public Texture emptytopT;
	   
	   public Texture currentT;
	   
	   public Texture targetT;
	   public Mine targetMine;
	   
	   public String ident;
	   
	   public String descLineOne;
	   public String descLineTwo;
	   public String descLineThree;
	   public String descLineFour;
	   
	   public boolean does_it_work;
	   public boolean targeted;
	   
	   public float destroyChance=1;
	   public float captureMissingChance=0.5f;
	   
	   public float targetingXOffset=0;
	   public float targetingYOffset=0;
	   
	   public float firingDelta = 0;
	   public float firingTime = 0;
	   
	   public Turret(){
		   ident="triangle";
		   
		   rect=new Rectangle();
		   rect.width=40;
		   rect.height=40;
		   
		   does_it_work=true;
		   targeted=false;
		   
		   assign_textures(ident);
		   assign_probabilities(ident);
	   }
	   
	   public Turret(String id){
		   this();
		   ident=id;
		   
		   assign_textures(ident);
		   assign_probabilities(ident);
	   }
	   
	   public void assign_textures(String id){
		   if (id.equals("triangle")){
			   normalT = Textures.Turrets.Triangle.normal;
			   firingT = Textures.Turrets.Triangle.firing;
			   selectedT = Textures.Turrets.Triangle.selected;
			   silhouetteT = Textures.Turrets.Triangle.silhouette;
			   emptytopT = Textures.Turrets.Triangle.emptytop;
			   
			   targetT = Textures.Targets.Turret.triangle;
		   }
		   if (id.equals("square")){
			   normalT = Textures.Turrets.Square.normal;
			   firingT = Textures.Turrets.Square.firing;
			   selectedT = Textures.Turrets.Square.selected;
			   silhouetteT = Textures.Turrets.Square.silhouette;
			   emptytopT = Textures.Turrets.Square.emptytop;
			   
			   targetT = Textures.Targets.Turret.square;
		   }
		   if (id.equals("pentagon")){
			   normalT = Textures.Turrets.Pentagon.normal;
			   firingT = Textures.Turrets.Pentagon.firing;
			   selectedT = Textures.Turrets.Pentagon.selected;
			   silhouetteT = Textures.Turrets.Pentagon.silhouette;
			   emptytopT = Textures.Turrets.Pentagon.emptytop;
			   
			   targetT = Textures.Targets.Turret.pentagon;
		   }
		   if (id.equals("hexagon")){
			   normalT = Textures.Turrets.Hexagon.normal;
			   firingT = Textures.Turrets.Hexagon.firing;
			   selectedT = Textures.Turrets.Hexagon.selected;
			   silhouetteT = Textures.Turrets.Hexagon.silhouette;
			   emptytopT = Textures.Turrets.Hexagon.emptytop;
			   
			   targetT = Textures.Targets.Turret.hexagon;
		   }
		   if (id.equals("octagon")){
			   normalT = Textures.Turrets.Octagon.normal;
			   firingT = Textures.Turrets.Octagon.firing;
			   selectedT = Textures.Turrets.Octagon.selected;
			   silhouetteT = Textures.Turrets.Octagon.silhouette;
			   emptytopT = Textures.Turrets.Octagon.emptytop;
			   
			   targetT = Textures.Targets.Turret.octagon;
		   }
		   if (id.equals("circle")){
			   normalT = Textures.Turrets.Circle.normal;
			   firingT = Textures.Turrets.Circle.firing;
			   selectedT = Textures.Turrets.Circle.selected;
			   silhouetteT = Textures.Turrets.Circle.silhouette;
			   emptytopT = Textures.Turrets.Circle.emptytop;
			   
			   targetT = Textures.Targets.Turret.circle;
		   }
		   if (id.equals("circleplus")){
			   normalT = Textures.Turrets.CirclePlus.normal;
			   firingT = Textures.Turrets.CirclePlus.firing;
			   selectedT = Textures.Turrets.CirclePlus.selected;
			   silhouetteT = Textures.Turrets.CirclePlus.silhouette;
			   emptytopT = Textures.Turrets.CirclePlus.emptytop;
			   
			   targetT = Textures.Targets.Turret.circle;
		   }
		   if (id.equals("circleplusplus")){
			   normalT = Textures.Turrets.CirclePlusPlus.normal;
			   firingT = Textures.Turrets.CirclePlusPlus.firing;
			   selectedT = Textures.Turrets.CirclePlusPlus.selected;
			   silhouetteT = Textures.Turrets.CirclePlusPlus.silhouette;
			   emptytopT = Textures.Turrets.CirclePlusPlus.emptytop;
			   
			   targetT = Textures.Targets.Turret.circle;
		   }
		   currentT = normalT;
	   }
	   
	   public void assign_probabilities(String id){
		   if (id.equals("triangle")){
			   destroyChance=1;
		   }
		   if (id.equals("square")){
			   destroyChance=0.8f;
		   }
		   if (id.equals("pentagon")){
			   destroyChance=0.6f;
		   }
		   if (id.equals("hexagon")){
			   destroyChance=0.4f;
		   }
		   if (id.equals("octagon")){
			   destroyChance=0.2f;
		   }
		   if (id.contains("circle")){
			   destroyChance=0;
		   }
		   
		   if (id.equals("circleplus")){
			   captureMissingChance=0.3f;
		   }
		   if (id.equals("circleplusplus")){
			   captureMissingChance=0.1f;
		   }
	   }
	   
	   public String determine_output(){
		   
		   //return "doomed capture";
		   
		   if (MathUtils.random()<destroyChance){
			   if (targetMine.ghostly){
				   return "doomed destroy";
			   }
			   else{
				   return "destroy";
			   }
		   }
		   else{
			   if (MathUtils.random()>captureMissingChance && !targetMine.ghostly){
				   return "capture";
			   }
			   else{
				   return "doomed capture";
			   }
		   }
	   }
	   
}
