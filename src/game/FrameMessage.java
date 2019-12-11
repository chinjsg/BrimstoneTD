package game;

import java.util.ArrayList;

import enemies.Enemy;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class FrameMessage {
	
	private ArrayList<ArrayList<Tile>> grid;
	private int tick;
	private int currency;
	private int health;
	private ArrayList<Enemy> enemies;
	/**
	 * This is the constructor of the FrameMessage class.
	 * @param grid
	 * @param currency
	 * @param enemies
	 * @param health
	 */
	public FrameMessage(ArrayList<ArrayList<Tile>> grid, int currency, ArrayList<Enemy> enemies, int health) {
    	this.grid = grid;
    	this.tick = tick;
    	this.health = health;
    	this.currency = currency;
    	this.enemies = enemies;
    	// we can also use setter methods if the parameters gets too lengthy
    }
	
	/**
	 * This is will return the grid
	 * @return ArrayList<ArrayList<Tile>>
	 */
	public ArrayList<ArrayList<Tile>> getGrid() {
		return grid;
    }
	/**
	 * This is return the health
	 * @return int
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * This will return tick
	 * @return int
	 */
	public int getTick() {
		return tick;
    }
	/**
	 * This will return the currency 
	 * @return int
	 */
	public int getCurrency() {
		return currency;
    }
	/**
	 * This is ArrayList of enemy
	 * @return ArrayList<Enemy>
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
    }
}
