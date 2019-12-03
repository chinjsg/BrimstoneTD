package game;

import enemies.Enemy;
import javafx.geometry.Point2D;
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
	private Point2D pos;
	private boolean ContainsEnemy;
	private boolean isPath;
	private boolean isPlaceable;
	private Image texture;
	

	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
		pos = new Point2D(col*50+25, row*50+25);
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
		this.tower = tower;
	}
	
	public void removeTower() {
		this.tower = null;
	}
	
	public void removeEnemy() {
		enemy = null;
		ContainsEnemy = false;
	}
	public Point2D getPos() {
		return pos;
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
