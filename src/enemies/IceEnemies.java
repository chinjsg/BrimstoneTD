package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class IceEnemies extends Enemy{
	
	private   Image texture;
	protected String image_pathAttack;
	protected String image_pathDie;
	protected String image_pathHurt;
	protected String image_pathRun;
	protected String image_pathWalk;
	private   int width;
	private   int height;
	private   int count;
	private   int columns = 5;
	private   double x;
	private   double y;
	
	// Pass 0 for enemy if you don't want a specific one
	// Pass 1 for enemy if you want Enemy 1
	// Pass 2 for enemy if you want Enemy 2
	// Pass 3 for enemy if you want Enemy 3
	// Pass 4 for enemy if you want Enemy 4
	// Pass 5 for enemy if you want Enemy 5
	// Pass 6 for enemy if you want Enemy 6
	public IceEnemies(ArrayList<Tile> pathToFollow , int enemy) {
		super(120, 2, 40, pathToFollow);
		x = 0;
		y = 0;
		if (enemy == 0) {
			this.texture = new Image("assets/ice/enemies/IceCommon.png");
		} else if (enemy == 1) {
			image_pathAttack = "assets/ice/enemies/1/ice1Attack.png";
			image_pathDie    = "assets/ice/enemies/1/ice1Die.png";
			image_pathHurt   = "assets/ice/enemies/1/ice1Hurt.png";
			image_pathRun    = "assets/ice/enemies/1/ice1run.png";
			image_pathWalk   = "assets/ice/enemies/1/ice1Walk.png";
			width   = 304;
			height  = 316;
			count   = 10;
			columns = 2;
		} else if (enemy == 2) {
			image_pathAttack = "assets/ice/enemies/2/ice2Attack.png";
			image_pathDie    = "assets/ice/enemies/2/ice2Die.png";
			image_pathHurt   = "assets/ice/enemies/2/ice2Hurt.png";
			image_pathRun    = "assets/ice/enemies/2/ice2run.png";
			image_pathWalk   = "assets/ice/enemies/2/ice2Walk.png";
			width   = 374;
			height  = 390;
			count   = 10;
			columns = 2;
		} else if (enemy == 3) {
			image_pathAttack = "assets/ice/enemies/3/ice3Attack.png";
			image_pathDie    = "assets/ice/enemies/3/ice3Die.png";
			image_pathHurt   = "assets/ice/enemies/3/ice3Hurt.png";
			image_pathRun    = "assets/ice/enemies/3/ice3run.png";
			image_pathWalk   = "assets/ice/enemies/3/ice3Walk.png";
			width   = 396;
			height  = 406;
			count   = 10;
			columns = 2;
		} else if (enemy == 4) {
			image_pathAttack = "assets/ice/enemies/4/ice4Attack.png";
			image_pathDie    = "assets/ice/enemies/4/ice4Die.png";
			image_pathHurt   = "assets/ice/enemies/4/ice4Hurt.png";
			image_pathRun    = "assets/ice/enemies/4/ice4run.png";
			image_pathWalk   = "assets/ice/enemies/4/ice4Walk.png";
			width  = 334;
			height = 314;
			count  = 20;
		} else if (enemy == 5) {
			image_pathAttack = "assets/ice/enemies/5/ice5Attack.png";
			image_pathDie    = "assets/ice/enemies/5/ice5Die.png";
			image_pathHurt   = "assets/ice/enemies/5/ice5Hurt.png";
			image_pathRun    = "assets/ice/enemies/5/ice5run.png";
			image_pathWalk   = "assets/ice/enemies/5/ice5Walk.png";
			width  = 347;
			height = 293;
			count  = 20;
		}else if (enemy == 6){
			image_pathAttack = "assets/ice/enemies/6/ice6Attack.png";
			image_pathDie    = "assets/ice/enemies/6/ice6Die.png";
			image_pathHurt   = "assets/ice/enemies/6/ice6Hurt.png";
			image_pathRun    = "assets/ice/enemies/6/ice6run.png";
			image_pathWalk   = "assets/ice/enemies/6/ice6Walk.png";
			width  = 339;
			height = 285;
			count  = 20;
		}
	}

	public Image getImage() {
		return texture;
	}

	public Image getImageAttack() {
		this.texture = new Image(image_pathAttack);
		return texture;
	}

	public Image getImageDie() {
		this.texture = new Image(image_pathDie);
		return texture;
	}


	public Image getImageHurt() {
		this.texture = new Image(image_pathHurt);
		return texture;
	}


	public Image getImageRun() {
		this.texture = new Image(image_pathRun);
		return texture;
	}


	public Image getImageWalk() {
		this.texture = new Image(image_pathWalk);
		return texture;
	}


	public int image_width() {
		return width;
	}


	public int image_height() {
		return height;
	}

	public int count() {
		return count;
	}


	public int columns() {
		return columns;
	}

	public double preX() {
		return x;
	}

	public double prey() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}