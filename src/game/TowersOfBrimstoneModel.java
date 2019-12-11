package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Queue;

import enemies.Enemy;
import towers.Tower;
import towers.TowerMap;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class TowersOfBrimstoneModel extends Observable {
	private ArrayList<ArrayList<Tile>> grid;
	private ArrayList<Tower> towers;
	private ArrayList<Enemy> enemies;
	private int health;
	private	ArrayList<Queue<Enemy>> waves;
	private int waveNum;
	private Tile endingTile;
	private int gold;
	private TowerMap towerMap;
	private boolean won;
	/**
	 * This is the constructor of the model class.
	 * It will help us to initialize the our basic 
	 */
	public TowersOfBrimstoneModel() {
		grid = createBlankMap();
		towerMap = new TowerMap();
		towers = new ArrayList<Tower>();
		enemies = new ArrayList<Enemy>();
		waveNum = 0;
		health = 100;
		won = false;
		gold = 2000;
	}
	/**
	 *  This will set the end title on the map
	 *  
	 * @param row
	 * @param col
	 */
	public void setEndingTile(int row, int col) {
		endingTile = grid.get(row).get(col);
	}
	/** 
	 * This will return a Array list of title  with the particular row number.
	 * @param row
	 * @return ArrayList<Tile>
	 */
	public ArrayList<Tile> getRow(int row){
		return grid.get(row);
	}
	/**
	 * This will return a Array list of title  with the particular column number.
	 * @param col
	 * @return ArrayList<Tile>
	 */
	public ArrayList<Tile> getCol(int col){
		ArrayList<Tile> column = new ArrayList<Tile>();
		for(int row = 0; row < grid.size(); row++) {
			column.add(row, grid.get(row).get(col));
		}
		return column;
	}
	/**
	 * This  will return the title at a particular row and column
	 * @param row
	 * @param col
	 * @return Tile
	 */
	public Tile getTile(int row, int col) {
		return grid.get(row).get(col);
	} 
	/**
	 * This will return the grid which we make with the title objects 
	 * @return ArrayList<ArrayList<Tile>>
	 */
	public ArrayList<ArrayList<Tile>> getGrid() {
		return grid;
	}
	/**
	 * This will create an empty blank grid of title objects with the same size of
	 * our map
	 * @return ArrayList<ArrayList<Tile>>
	 */
	private ArrayList<ArrayList<Tile>> createBlankMap() {
		ArrayList<ArrayList<Tile>> grid = new ArrayList<ArrayList<Tile>>(); 
		for(int row = 0; row < 20; row++) {
			ArrayList<Tile> rows = new ArrayList<>();
			for(int col = 0; col < 28; col++) {
				rows.add(new Tile(row , col));
			}
			grid.add(row, rows);
		}
		return grid;
	}
	/**
	 * This function will help us to add the total amount of gold in the game
	 * @param amount
	 */
	public void addGold(int amount) {
		gold = gold + amount;
	} 
	/**
	 *  This function will help us to subtract the gold amount and keep track of 
	 *  negative balance by returning a boolean result.
	 * @param amount
	 * @return boolean
	 */
	private boolean subtractGold(int amount) {
		if (amount > gold) {
			return false;
		}
		gold = gold - amount;
		return true;
	}
	/**
	 * This will set the end tile that is the path ending in the map. 
	 * @param row
	 * @param col
	 */
	public void setEnd(int row, int col) {
		endingTile = grid.get(row).get(col);
	}
	/**
	 * This will return the end tile
	 * @return Tile
	 */
	public Tile getEnd() {
		return endingTile;
	}
	/**
	 * This will return the amount of gold we have.
	 * @return int
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * This will help us to place the tower and return a boolean result to tell if
	 * tower is placed successfully or not.
	 * @param row
	 * @param col
	 * @param tower
	 * @return boolean
	 */
	public boolean placeTower(int row, int col, Tower tower) {
		boolean valid = subtractGold(tower.getCost());
		if (valid) {
			Tile tile = getTile(row, col);
			tile.placeTower(tower);
			towers.add(tower);
			//updateTowerMap()
			return true;
		}
		return false;
	}
	/**
	 * This will help us to remove tower from the map
	 * @param row
	 * @param col
	 * @param sellback
	 */
	public void removeTower(int row, int col, int sellback) {
		Tile tile = getTile(row, col);
		Tower tower = tile.getPlacedTower();
		towers.remove(tower);
		tile.removeTower();
		towers.remove(tower);
		addGold(sellback);
		//updateTowerMap()
		System.out.println("Tower sold for " + sellback + " gold");
		
		int[] temp = new int[2];
		temp[0] = row;
		temp[1] = col;
		setChanged();
		notifyObservers(temp);
	}
	/**
	 * This will set the waves of enemy 
	 * @param waves
	 */
	public void setWaves(ArrayList<Queue<Enemy>> waves) {
		this.waves = waves;
	}
	/**
	 * This will return the waves which is a ArrayList
	 * @return ArrayList<Queue<Enemy>>
	 */
	public ArrayList<Queue<Enemy>> getWaves(){
		return waves;
	}
	/**
	 * This will helps to know the Wavenum and know which wave of enemy is 
	 * moving.
	 * @return int
	 */
	public int getWaveNum() {
		return waveNum;
	}
	/**
	 * This will add the Wavenum
	 */
	public void incrementWaveNum() {
		waveNum++;
	}
	/**
	 * This will add the enemy object to the ArrayList of enemies
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
		notifyObservers(enemy);
	}
	/**
	 * When the enemy die we remove him from the queue.
	 * @param enemy
	 */
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
		System.out.println("ENEMIES: " + enemies);
		
	}
	/** 
	 * This will help us to get array of Towers
	 * @return ArrayList<Tower>
	 */
	public ArrayList<Tower> getTowers(){
		return towers;
	}
	/**
	 * This will help us to get Array of Enemy
	 * @return ArrayList<Enemy>
	 */
	public ArrayList<Enemy> getEnemy(){
		return enemies;
	}
	/**
	 * This will help us to subtract the health 
	 * @param damage
	 */
	public void subtractHealth(int damage) {
		health -= damage;
	}
	/**
	 * This will return the health
	 * @return int
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * This function will help us to add tower to the TowerMap class
	 * @param tower
	 */
	public void updateTowerMap(Tower tower) {
		towerMap.addTower(tower);
	}
	/**
	 * This will send the all the game state to the view.
	 * @param tick
	 */
	public void updateFrame(int tick) {
		FrameMessage update = new FrameMessage(getGrid(), getGold(), enemies, health);
		setChanged();
		notifyObservers(update);
	}
	/**
	 * This function will tell that we won
	 */
	public void setWon() {
		won = true;
		setChanged();
		notifyObservers(true);
	}
	/**
	 * This function will tell that we lost
	 */
	public void setLost() {
		won = false;
		setChanged();
		notifyObservers(false);
	}
}
