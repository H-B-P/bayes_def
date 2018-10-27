package com.bayesdef;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class Turret {
	   Rectangle rect;
	   
	   Texture normalT;
	   Texture firingT;
	   Texture selectedT;
	   Texture silhouetteT;
	   Texture emptytopT;
	   
	   Texture currentT;
	   
	   Texture targetT;
	   Mine targetMine;
	   
	   String ident;
	   
	   String descLineOne;
	   String descLineTwo;
	   String descLineThree;
	   String descLineFour;
	   
	   boolean does_it_work;
	   boolean targeted;
	   
	   float destroyChance=1;
	   float captureMissingChance=0.5f;
	   
	   float targetingXOffset=0;
	   float targetingYOffset=0;
	   
	   float firingDelta = 0;
	   float firingTime = 0;
	   
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
	   
	   void assign_textures(String id){
		   if (id.equals("triangle")){
			   normalT = Textures.Turrets.Triangle.normal;
			   firingT = Textures.Turrets.Triangle.firing;
			   selectedT = Textures.Turrets.Triangle.selected;
			   silhouetteT = Textures.Turrets.Triangle.silhouette;
			   emptytopT = Textures.Turrets.Triangle.emptytop;
			   
			   targetT = Textures.Targets.triangle;
		   }
		   if (id.equals("square")){
			   normalT = Textures.Turrets.Square.normal;
			   firingT = Textures.Turrets.Square.firing;
			   selectedT = Textures.Turrets.Square.selected;
			   silhouetteT = Textures.Turrets.Square.silhouette;
			   emptytopT = Textures.Turrets.Square.emptytop;
			   
			   targetT = Textures.Targets.square;
		   }
		   if (id.equals("pentagon")){
			   normalT = Textures.Turrets.Pentagon.normal;
			   firingT = Textures.Turrets.Pentagon.firing;
			   selectedT = Textures.Turrets.Pentagon.selected;
			   silhouetteT = Textures.Turrets.Pentagon.silhouette;
			   emptytopT = Textures.Turrets.Pentagon.emptytop;
			   
			   targetT = Textures.Targets.pentagon;
		   }
		   if (id.equals("hexagon")){
			   normalT = Textures.Turrets.Hexagon.normal;
			   firingT = Textures.Turrets.Hexagon.firing;
			   selectedT = Textures.Turrets.Hexagon.selected;
			   silhouetteT = Textures.Turrets.Hexagon.silhouette;
			   emptytopT = Textures.Turrets.Hexagon.emptytop;
			   
			   targetT = Textures.Targets.hexagon;
		   }
		   if (id.equals("octagon")){
			   normalT = Textures.Turrets.Octagon.normal;
			   firingT = Textures.Turrets.Octagon.firing;
			   selectedT = Textures.Turrets.Octagon.selected;
			   silhouetteT = Textures.Turrets.Octagon.silhouette;
			   emptytopT = Textures.Turrets.Octagon.emptytop;
			   
			   targetT = Textures.Targets.octagon;
		   }
		   if (id.equals("circle")){
			   normalT = Textures.Turrets.Circle.normal;
			   firingT = Textures.Turrets.Circle.firing;
			   selectedT = Textures.Turrets.Circle.selected;
			   silhouetteT = Textures.Turrets.Circle.silhouette;
			   emptytopT = Textures.Turrets.Circle.emptytop;
			   
			   targetT = Textures.Targets.circle;
		   }
		   currentT = normalT;
	   }
	   
	   void assign_probabilities(String id){
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
		   if (id.equals("circle")){
			   destroyChance=0;
		   }
	   }
	   
	   String determine_output(){
		   
		   //return "doomed capture";
		   
		   if (MathUtils.random()<destroyChance){
			   return "destroy";
		   }
		   else{
			   if (MathUtils.random()<captureMissingChance){
				   return "capture";
			   }
			   else{
				   return "doomed capture";
			   }
		   }
	   }
	   
}
