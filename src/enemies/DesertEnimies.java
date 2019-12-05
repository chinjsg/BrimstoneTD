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
		
	// Pass 0 for enemy if you don't want a specific one
	// Pass 1 for enemy if you want Enemy 1
	// Pass 2 for enemy if you want Enemy 2
	// Pass 3 for enemy if you want Enemy 3
	// Pass 4 for enemy if you want Enemy 4
	// Pass 5 for enemy if you want Enemy 5
	// Pass 6 for enemy if you want Enemy 6
	
	public DesertEnimies(int health, int speed, int goldReward, int row, int col,
			ArrayList<Tile> pathToFollow , int enemy) {
		super(health, speed, goldReward, row, col, pathToFollow);
		
		if (enemy == 0) {
			this.texture = new Image("DesertCommon.png");
		}else if (enemy == 1) {
			image_pathAttack = "desert1Attack.png";
			image_pathDie    = "desert1Die.png";
			image_pathHurt   = "desert1Hurt.png";
			image_pathRun    = "desert1run.png";
			image_pathWalk   = "desert1Walk.png";
			width   = 337;
			height  = 294;
			count   = 20;
		} else if (enemy == 2) {
			image_pathAttack = "desert2Attack.png";
			image_pathDie    = "desert2Die.png";
			image_pathHurt   = "desert2Hurt.png";
			image_pathRun    = "desert2run.png";
			image_pathWalk   = "desert2Walk.png";
			width  = 331;
			height = 299;
			count  = 20;
		} else if (enemy == 3) {
			image_pathAttack = "desert3Attack.png";
			image_pathDie    = "desert3Die.png";
			image_pathHurt   = "desert3Hurt.png";
			image_pathRun    = "desert3run.png";
			image_pathWalk   = "desert3Walk.png";
			width  = 346;
			height = 370;
			count  = 10;
		} else if (enemy == 4) {
			image_pathAttack = "desert4Attack.png";
			image_pathDie    = "desert4Die.png";
			image_pathHurt   = "desert4Hurt.png";
			image_pathRun    = "desert4run.png";
			image_pathWalk   = "desert4Walk.png";
			width  = 320;
			height = 323;
			count  = 10;
		} else if (enemy == 5) {
			image_pathAttack = "desert5Attack.png";
			image_pathDie    = "desert5Die.png";
			image_pathHurt   = "desert5Hurt.png";
			image_pathRun    = "desert5run.png";
			image_pathWalk   = "desert5Walk.png";
			width  = 349;
			height = 291;
			count  = 20;
		}else if (enemy == 6){
			image_pathAttack = "desert6Attack.png";
			image_pathDie    = "desert6Die.png";
			image_pathHurt   = "desert6Hurt.png";
			image_pathRun    = "desert6run.png";
			image_pathWalk   = "desert6Walk.png";
			width  = 254;
			height = 205;
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
		System.out.println(texture.isError());
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
