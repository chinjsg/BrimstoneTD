package towers;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Tower {
	public static final String GRASS = "grass.jpeg";
	
	protected int attackPower;
	protected int rateOfFire;
	protected boolean areaDamage;	// single target - aoe
	protected int cost;
	protected Point2D pos;
	protected int row;
	protected int col;
	private Image texture;
	protected String image_path;
	//protected image image;
	//protected Title tile;
	
	public Tower(int attackPower, int rateOfFire, boolean areaDamage, int cost, int row, int col, int imageNum) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
		this.cost = cost;
		this.row = row;
		this.col = col;
		if (imageNum == 1) {
			image_path = "tower_stone.png";
		} else if (imageNum == 2) {
			image_path = "tower_fire.png";
		} else if (imageNum == 3) {
			image_path = "tower_ice.png";
		} else if (imageNum == 4) {
			image_path = "tower_heavy.png";
		} else if (imageNum == 5) {
			image_path = "tower_lightning.png";
		} else {
			image_path = "tower_magic.png";
		}
		this.texture = new Image(image_path);
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public int getRateOfFire() {
		return rateOfFire;
	}
	
	public boolean getAreaDamage() {
		return areaDamage;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setPlacementCoordinates(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Image getImage() {
		return texture;
	}
}