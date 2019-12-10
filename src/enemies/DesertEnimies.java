package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class DesertEnimies extends Enemy{
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
	

	public DesertEnimies( ArrayList<Tile> pathToFollow , int enemy) {
		super(100, 2, 20, pathToFollow);
		x = 0;
		y = 0;		
		if (enemy == 0) {
			this.texture = new Image("DesertCommon.png");
			System.out.println(texture.isError());
		}else if (enemy == 1) {
			image_pathAttack = "assets/desert/enemies/1/desert1Attack.png";
			image_pathDie    = "assets/desert/enemies/1/desert1Die.png";
			image_pathHurt   = "assets/desert/enemies/1/desert1Hurt.png";
			image_pathRun    = "assets/desert/enemies/1/desert1run.png";
			image_pathWalk   = "assets/desert/enemies/1/desert1Walk.png";
			width   = 337;
			height  = 294;
			count   = 20;
		} else if (enemy == 2) {
			image_pathAttack = "assets/desert/enemies/2/desert2Attack.png";
			image_pathDie    = "assets/desert/enemies/2/desert2Die.png";
			image_pathHurt   = "assets/desert/enemies/2/desert2Hurt.png";
			image_pathRun    = "assets/desert/enemies/2/desert2run.png";
			image_pathWalk   = "assets/desert/enemies/2/desert2Walk.png";
			width  = 331;
			height = 299;
			count  = 20;
		} else if (enemy == 3) {
			image_pathAttack = "assets/desert/enemies/3/desert3Attack.png";
			image_pathDie    = "assets/desert/enemies/3/desert3Die.png";
			image_pathHurt   = "assets/desert/enemies/3/desert3Hurt.png";
			image_pathRun    = "assets/desert/enemies/3/desert3run.png";
			image_pathWalk   = "assets/desert/enemies/3/desert3Walk.png";
			width  = 346;
			height = 370;
			count  = 10;
		} else if (enemy == 4) {
			image_pathAttack = "assets/desert/enemies/4/desert4Attack.png";
			image_pathDie    = "assets/desert/enemies/4/desert4Die.png";
			image_pathHurt   = "assets/desert/enemies/4/desert4Hurt.png";
			image_pathRun    = "assets/desert/enemies/4/desert4run.png";
			image_pathWalk   = "assets/desert/enemies/4/desert4Walk.png";
			width  = 320;
			height = 323;
			count  = 10;
		} else if (enemy == 5) {
			image_pathAttack = "assets/desert/enemies/5/desert5Attack.png";
			image_pathDie    = "assets/desert/enemies/5/desert5Die.png";
			image_pathHurt   = "assets/desert/enemies/5/desert5Hurt.png";
			image_pathRun    = "assets/desert/enemies/5/desert5run.png";
			image_pathWalk   = "assets/desert/enemies/5/desert5Walk.png";
			width  = 349;
			height = 291;
			count  = 20;
		}else if (enemy == 6){
			image_pathAttack = "assets/desert/enemies/6/desert6Attack.png";
			image_pathDie    = "assets/desert/enemies/6/desert6Die.png";
			image_pathHurt   = "assets/desert/enemies/6/desert6Hurt.png";
			image_pathRun    = "assets/desert/enemies/6/desert6run.png";
			image_pathWalk   = "assets/desert/enemies/6/desert6Walk.png";
			width  = 254;
			height = 205;
			count  = 20;
		}
	}
	
	@Override
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
		this.x = x ;
	}

	public void setY(double y) {
		this.y = y;
	}	
}

