package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Queue;

import enemies.Enemy;
import enemies.Zombie;
import towers.Tower;
import towers.TowerMap;

public class TowersOfBrimstoneModel extends Observable {
	private ArrayList<ArrayList<Tile>> grid;
	private ArrayList<Tower> towers;
	private ArrayList<Enemy> enemies;
	private	ArrayList<Queue<Enemy>> waves;
	private int waveNum;
	private Tile endingTile;
	private int gold;
	private TowerMap towerMap;
	
	public TowersOfBrimstoneModel() {
		grid = createBlankMap();
		towerMap = new TowerMap();
		towers = new ArrayList<Tower>();
		enemies = new ArrayList<Enemy>();
		waveNum = 0;
		gold = 2000;
	}
	
	public void setEndingTile(int row, int col) {
		endingTile = grid.get(row).get(col);
	}
	
	public ArrayList<Tile> getRow(int row){
		return grid.get(row);
	}
	
	public ArrayList<Tile> getCol(int col){
		ArrayList<Tile> column = new ArrayList<Tile>();
		for(int row = 0; row < grid.size(); row++) {
			column.add(row, grid.get(row).get(col));
		}
		return column;
	}
	
	public Tile getTile(int row, int col) {
		return grid.get(row).get(col);
	} 
	
	public ArrayList<ArrayList<Tile>> getGrid() {
		return grid;
	}
	
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
	
	private void addGold(int amount) {
		gold = gold + amount;
	} 
	
	private boolean subtractGold(int amount) {
		if (amount > gold) {
			return false;
		}
		gold = gold - amount;
		return true;
	}
	
	public void setEnd(int row, int col) {
		endingTile = grid.get(row).get(col);
	}
	
	public Tile getEnd() {
		return endingTile;
	}
	
	public int getGold() {
		return gold;
	}

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
	public void setWaves(ArrayList<Queue<Enemy>> waves) {
		this.waves = waves;
	}
	public ArrayList<Queue<Enemy>> getWaves(){
		return waves;
	}
	public int getWaveNum() {
		return waveNum;
	}
	public void incrementWaveNum() {
		waveNum++;
	}
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
		notifyObservers(enemy);
	}
	public ArrayList<Tower> getTowers(){
		return towers;
	}
	public ArrayList<Enemy> getEnemy(){
		return enemies;
	}
	
	public void updateTowerMap(Tower tower) {
		towerMap.addTower(tower);
	}
	
	public void updateFrame(int tick, Zombie zomb) {
		FrameMessage update = new FrameMessage(getGrid(), tick, getGold(), zomb);
		setChanged();
		notifyObservers(update);
	}
}
