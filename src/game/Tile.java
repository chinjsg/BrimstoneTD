package game;

import enemies.Enemy;
import javafx.scene.image.Image;
import towers.Tower;

public class Tile {
	public static final String GRASS = "grass.jpeg";
	public static final String PLACE = "brick.jpeg";
	public static final String PATH = "sand.png";
	private int row;
	private int col;
	private Enemy enemy;
	private Tower tower;
	private boolean ContainsEnemy;
	private boolean isPath;
	private boolean isPlaceable;
	private Image texture;
	

	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
		isPath = false;
		isPlaceable = false;
		texture = new Image(GRASS);
		tower = null;
	}

	public Image getTexture() {
		return texture;
	}
	public boolean getIsPath() {
		return isPath;
	}
	public void setIsPath() {
		isPath = true;
		texture = new Image(PATH);
	}
	
	public boolean getContainsEnemy() {
		return ContainsEnemy;
	}
	
	public void placeEnemy(Enemy enemy) {
		this.enemy = enemy;
		ContainsEnemy = true;
	}
	
	public void setIsPlaceable() {
		isPlaceable = true;
		texture = new Image(PLACE);
	}
	public void placeTower(Tower tower) {
		//if(isPlaceable) {
			this.tower = tower;
		//}
		//return isPlaceable;
	}
	
	public void removeEnemy() {
		enemy = null;
		ContainsEnemy = false;
	}
	public String toString() {
		return "row: " + row + " col: " + col;
	}

	public Tower getPlacedTower() {
		return tower;
	}
	
	public boolean getIsPlaceable() {
		return isPlaceable;
	}

	


}
