package game;

import enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import towers.Tower;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
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
	
	/**
	 * This is the constructor for tile class.
	 * @param row
	 * @param col
	 */

	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
		pos = new Point2D(col*50+25, row*50+25);
		isPath = false;
		isPlaceable = false;
		tower = null;
	}
	
	/**
	 * @return Image
	 */
	
	public Image getTexture() {
		return texture;
	}
	/**
	 * This will return a boolean result if there is a path at a location or no.
	 * @return boolean
	 */
	public boolean getIsPath() {
		return isPath;
	}
	/**
	 * This will set the path to true to signify that there is a path at the location.
	 */
	public void setIsPath() {
		isPath = true;
	}
	/**
	 * This will tells us whether a enemy is present on the location or no.
	 * @return boolean
	 */
	public boolean getContainsEnemy() {
		return ContainsEnemy;
	}
	/**
	 * This will place the enemy at the location 
	 * @param enemy
	 */
	public void placeEnemy(Enemy enemy) {
		this.enemy = enemy;
		ContainsEnemy = true;
	}
	/**
	 * This will help us to identify if we can place the tower at the location or not.
	 */
	public void setIsPlaceable() {
		isPlaceable = true;
	}
	/**
	 * This will help us to place the tower
	 * @param tower
	 */
	public void placeTower(Tower tower) {
		this.tower = tower;
	}
	/**
	 * This will help us to remove the tower
	 */
	public void removeTower() {
		this.tower = null;
	}
	/**
	 * This will help us to remove the enemy
	 */
	public void removeEnemy() {
		enemy = null;
		ContainsEnemy = false;
	}
	/**
	 * This will return the position
	 * @return Point2D
	 */
	public Point2D getPos() {
		return pos;
	}
	/**
	 * This will return the String version of the row , col of the tile class.
	 */
	public String toString() {
		return "row: " + row + " col: " + col;
	}
	/**
	 * It will return the tower placed.
	 * @return Tower
	 */
	public Tower getPlacedTower() {
		return tower;
	}
	/**
	 * This will return if the tower is placeable or no.
	 * @return boolean
	 */
	public boolean getIsPlaceable() {
		return isPlaceable;
	}
}
