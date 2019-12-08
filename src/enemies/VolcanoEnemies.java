package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class VolcanoEnemies extends Enemy{
		
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
	
		// Pass 0 for enemy if you don't want a specific one
		// Pass 1 for enemy if you want Enemy 1
		// Pass 2 for enemy if you want Enemy 2
		// Pass 3 for enemy if you want Enemy 3
		// Pass 4 for enemy if you want Enemy 4
		// Pass 5 for enemy if you want Enemy 5
		// Pass 6 for enemy if you want Enemy 6
	public VolcanoEnemies(ArrayList<Tile> pathToFollow , int enemy) {
		super(150, 2, 60, pathToFollow);
		
		if (enemy == 0) {
			this.texture = new Image("assets/volcano/enemies/VolcanoCommon.png");
		} else if (enemy == 1) {
			image_pathAttack = "assets/volcano/enemies/1/volcano1Attack.png";
			image_pathDie    = "assets/volcano/enemies/1/volcano1Die.png";
			image_pathHurt   = "assets/volcano/enemies/1/volcano1Hurt.png";
			image_pathRun    = "assets/volcano/enemies/1/volcano1run.png";
			image_pathWalk   = "assets/volcano/enemies/1/volcano1Walk.png";
			width   = 411;
			height  = 360;
			count   = 10;
			columns = 2;
		} else if (enemy == 2) {
			image_pathAttack = "assets/volcano/enemies/2/volcano2Attack.png";
			image_pathDie    = "assets/volcano/enemies/2/volcano2Die.png";
			image_pathHurt   = "assets/volcano/enemies/2/volcano2Hurt.png";
			image_pathRun    = "assets/volcano/enemies/2/volcano2run.png";
			image_pathWalk   = "assets/volcano/enemies/2/volcano2Walk.png";
			width  = 294;
			height = 275;
			count  = 20;
		} else if (enemy == 3) {
			image_pathAttack = "assets/volcano/enemies/3/volcano3Attack.png";
			image_pathDie    = "assets/volcano/enemies/3/volcano3Die.png";
			image_pathHurt   = "assets/volcano/enemies/3/volcano3Hurt.png";
			image_pathRun    = "assets/volcano/enemies/3/volcano3run.png";
			image_pathWalk   = "assets/volcano/enemies/3/volcano3Walk.png";
			width  = 294;
			height = 248;
			count  = 20;
		} else if (enemy == 4) {
			image_pathAttack = "assets/volcano/enemies/4/volcano4Attack.png";
			image_pathDie    = "assets/volcano/enemies/4/volcano4Die.png";
			image_pathHurt   = "assets/volcano/enemies/4/volcano4Hurt.png";
			image_pathRun    = "assets/volcano/enemies/4/volcano4run.png";
			image_pathWalk   = "assets/volcano/enemies/4/volcano4Walk.png";
			width  = 380;
			height = 332;
			count  = 20;
		} else if (enemy == 5) {
			image_pathAttack = "assets/volcano/enemies/5/volcano5Attack.png";
			image_pathDie    = "assets/volcano/enemies/5/volcano5Die.png";
			image_pathHurt   = "assets/volcano/enemies/5/volcano5Hurt.png";
			image_pathRun    = "assets/volcano/enemies/5/volcano5run.png";
			image_pathWalk   = "assets/volcano/enemies/5/volcano5Walk.png";
			width  = 445;
			height = 420;
			count  = 20;
		}else if (enemy == 6){
			image_pathAttack = "assets/volcano/enemies/6/volcano6Attack.png";
			image_pathDie    = "assets/volcano/enemies/6/volcano6Die.png";
			image_pathHurt   = "assets/volcano/enemies/6/volcano6Hurt.png";
			image_pathRun    = "assets/volcano/enemies/6/volcano6run.png";
			image_pathWalk   = "assets/volcano/enemies/6/volcano6Walk.png";
			width  = 384;
			height = 338;
			count  = 20;
		}
		
	}

	@Override
	public Image getImage() {
		return texture;
	}

	@Override
	public Image getImageAttack() {
		this.texture = new Image(image_pathAttack);
		return texture;
	}

	@Override
	public Image getImageDie() {
		this.texture = new Image(image_pathDie);
		return texture;
	}

	@Override
	public Image getImageHurt() {
		this.texture = new Image(image_pathHurt);
		return texture;
	}

	@Override
	public Image getImageRun() {
		this.texture = new Image(image_pathRun);
		return texture;
	}

	@Override
	public Image getImageWalk() {
		this.texture = new Image(image_pathWalk);
		return texture;
	}

	@Override
	public int image_width() {
		return width;
	}

	@Override
	public int image_height() {
		return height;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int columns() {
		return columns;
	}

}