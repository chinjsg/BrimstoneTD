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
	
	public Tower(int attackPower, int rateOfFire, boolean areaDamage, int cost, int row, int col, String image_path) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
		this.cost = cost;
		this.row = row;
		this.col = col;
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
