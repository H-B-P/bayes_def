package com.bayesdef.resources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	public static Texture badlog;
	
	public static Texture letterboxPoncho;
	
	public static Texture prettyBG;
	public static Texture theShip;
	public static Texture statusBar;
	
	public static class Shields{
		public static Texture one;
		public static Texture two;
		public static Texture three;
		public static Texture four;
		public static Texture five;
	}
	
	public static class Turrets{
		public static class Triangle{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		public static class Square{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		public static class Pentagon{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		public static class Hexagon{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		public static class Octagon{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		public static class Circle{
			public static Texture normal;
			public static Texture firing;
			public static Texture selected;
			public static Texture silhouette;
			public static Texture emptytop;
		}
		
	}
	
	public static class ShipParts{
		public static class Fronts{
			public static Texture one;
		}
		public static class Backs{
			public static Texture one;
		}
		public static class Engines{
			public static class Fronts{
				public static Texture one;
			}
			public static class Backs{
				public static Texture one;
			}
		}
	}
	
	public static class Targets{

		public static class Turret{
			public static Texture triangle;
			public static Texture square;
			public static Texture pentagon;
			public static Texture hexagon;
			public static Texture octagon;
			public static Texture circle;
			public static Texture lineDot;
		}
		
		public static class Vane{
			public static Texture triangle;
			public static Texture square;
			public static Texture pentagon;
			public static Texture hexagon;
			public static Texture octagon;
			public static Texture circle;
			public static Texture lineDot;
		}
		
		public static class Mine{
			public static Texture standard;
		}
	}
	
	public static class Shots{
		public static Texture capture;
		public static Texture destroy;
	}
	
	public static class Symbols{
		public static Texture someCircle;
		public static Texture mostCircle;
		public static Texture fullCircle;
		public static Texture someTriangle;
		public static Texture mostTriangle;
		public static Texture fullTriangle;
	}
	
	public static class Icons{
		public static Texture capture;
		public static Texture destroy;
		public static Texture survive;

	}
	
	public static Texture detainingCircle;
	public static Texture missStatement;
	
	public static Texture explosion;
	public static Texture bigExplosion;
	
	public static class Mine{
		public static Texture regular;
		public static Texture speedy;
		public static Texture slow;

	}
	
	public static class Buttons{
		public static Texture fire;
		public static Texture exit;
		public static Texture greenTrim;
		public static Texture orangeTrim;
		public static Texture purpleTrim;
	}
	
	public static Texture vane;
	public static Texture vaneTrim;
	
	public static void load () {
		
		badlog = new Texture("badlogic.jpg");
		
		letterboxPoncho = new Texture("textures/letterboxPoncho.png");
		
		prettyBG=new Texture("textures/prettyBG.png");
		theShip=new Texture("textures/theShip.png");
		statusBar=new Texture("textures/statusBar.png");
		
		Shields.one=new Texture("textures/shields/shield1.png");
		Shields.two=new Texture("textures/shields/shield2.png");
		Shields.three=new Texture("textures/shields/shield3.png");
		Shields.four=new Texture("textures/shields/shield4.png");
		Shields.five=new Texture("textures/shields/shield5.png");
		
		Turrets.Triangle.normal=new Texture("textures/turrets/turret_triangle.png");
		Turrets.Triangle.firing=new Texture("textures/turrets/turret_triangle_firing.png");
		Turrets.Triangle.selected=new Texture("textures/turrets/turret_triangle_selected.png");
		Turrets.Triangle.silhouette=new Texture("textures/turrets/turret_triangle_silhouette.png");
		Turrets.Triangle.emptytop=new Texture("textures/turrets/turret_triangle_emptytop.png");
		
		Turrets.Square.normal=new Texture("textures/turrets/turret_square.png");
		Turrets.Square.firing=new Texture("textures/turrets/turret_square_firing.png");
		Turrets.Square.selected=new Texture("textures/turrets/turret_square_selected.png");
		Turrets.Square.silhouette=new Texture("textures/turrets/turret_square_silhouette.png");
		Turrets.Square.emptytop=new Texture("textures/turrets/turret_square_emptytop.png");
		
		Turrets.Pentagon.normal=new Texture("textures/turrets/turret_pentagon.png");
		Turrets.Pentagon.firing=new Texture("textures/turrets/turret_pentagon_firing.png");
		Turrets.Pentagon.selected=new Texture("textures/turrets/turret_pentagon_selected.png");
		Turrets.Pentagon.silhouette=new Texture("textures/turrets/turret_pentagon_silhouette.png");
		Turrets.Pentagon.emptytop=new Texture("textures/turrets/turret_pentagon_emptytop.png");
		
		Turrets.Hexagon.normal=new Texture("textures/turrets/turret_hexagon.png");
		Turrets.Hexagon.firing=new Texture("textures/turrets/turret_hexagon_firing.png");
		Turrets.Hexagon.selected=new Texture("textures/turrets/turret_hexagon_selected.png");
		Turrets.Hexagon.silhouette=new Texture("textures/turrets/turret_hexagon_silhouette.png");
		Turrets.Hexagon.emptytop=new Texture("textures/turrets/turret_hexagon_emptytop.png");
		
		Turrets.Octagon.normal=new Texture("textures/turrets/turret_octagon.png");
		Turrets.Octagon.firing=new Texture("textures/turrets/turret_octagon_firing.png");
		Turrets.Octagon.selected=new Texture("textures/turrets/turret_octagon_selected.png");
		Turrets.Octagon.silhouette=new Texture("textures/turrets/turret_octagon_silhouette.png");
		Turrets.Octagon.emptytop=new Texture("textures/turrets/turret_octagon_emptytop.png");
		
		Turrets.Circle.normal=new Texture("textures/turrets/turret_circle.png");
		Turrets.Circle.firing=new Texture("textures/turrets/turret_circle_firing.png");
		Turrets.Circle.selected=new Texture("textures/turrets/turret_circle_selected.png");
		Turrets.Circle.silhouette=new Texture("textures/turrets/turret_circle_silhouette.png");
		Turrets.Circle.emptytop=new Texture("textures/turrets/turret_circle_emptytop.png");
		
		ShipParts.Backs.one=new Texture("textures/ship_components/back_a.png");
		ShipParts.Fronts.one=new Texture("textures/ship_components/front_a.png");
		ShipParts.Engines.Fronts.one=new Texture("textures/ship_components/engine_a_front.png");
		ShipParts.Engines.Backs.one=new Texture("textures/ship_components/engine_a_back.png");
		
		Targets.Turret.triangle = new Texture("textures/targets/turret/target_triangle.png");
		Targets.Turret.square = new Texture("textures/targets/turret/target_square.png");
		Targets.Turret.pentagon = new Texture("textures/targets/turret/target_pentagon.png");
		Targets.Turret.hexagon = new Texture("textures/targets/turret/target_hexagon.png");
		Targets.Turret.octagon = new Texture("textures/targets/turret/target_octagon.png");
		Targets.Turret.circle = new Texture("textures/targets/turret/target_circle.png");
		
		Targets.Turret.lineDot = new Texture("textures/targets/turret/line_dot.png");
		
		Targets.Vane.triangle = new Texture("textures/targets/vane/target_triangle.png");
		Targets.Vane.square = new Texture("textures/targets/vane/target_square.png");
		Targets.Vane.pentagon = new Texture("textures/targets/vane/target_pentagon.png");
		Targets.Vane.hexagon = new Texture("textures/targets/vane/target_hexagon.png");
		Targets.Vane.octagon = new Texture("textures/targets/vane/target_octagon.png");
		Targets.Vane.circle = new Texture("textures/targets/vane/target_circle.png");
		
		Targets.Vane.lineDot = new Texture("textures/targets/vane/line_dot.png");
		
		Icons.capture = new Texture("textures/icons/iconic_capture.png");
		Icons.destroy = new Texture("textures/icons/iconic_boom.png");
		Icons.survive = new Texture("textures/icons/iconic_mine.png");
		
		Shots.capture = new Texture("textures/shots/shot_capture.png");
		Shots.destroy = new Texture("textures/shots/shot_destroy.png");
		
		
		Symbols.someCircle = new Texture("textures/vanes/energy_circle_pt1.png");
		Symbols.mostCircle = new Texture("textures/vanes/energy_circle_pt2.png");
		Symbols.fullCircle = new Texture("textures/vanes/energy_circle.png");
		
		Symbols.someTriangle = new Texture("textures/vanes/energy_triangle_pt1.png");
		Symbols.mostTriangle = new Texture("textures/vanes/energy_triangle_pt2.png");
		Symbols.fullTriangle = new Texture("textures/vanes/energy_triangle.png");
		
		Buttons.fire = new Texture("textures/buttons/ingame_button_fire.png");
		Buttons.exit = new Texture("textures/buttons/ingame_button_exit.png");
		
		
		detainingCircle = new Texture("textures/detaining_circle.png");
		missStatement = new Texture("textures/shots/shot_miss.png");

		
		explosion = new Texture("textures/explosions/explosion.png");
		bigExplosion = new Texture("textures/explosions/big_explosion.png");

		vane = new Texture("textures/vanes/vane.png");
		vaneTrim = new Texture("textures/vanes/vane_outline.png");
		
		Mine.regular = new Texture("textures/mines/mine.png");
		Mine.speedy = new Texture("textures/mines/speedy_mine.png");
		Mine.slow = new Texture("textures/mines/slow_mine.png");

	}
}