package game;

import java.util.ArrayList;
import java.util.Observable;

import enemies.Zombie;
import towers.Tower;
import towers.TowerMap;

public class TowersOfBrimstoneModel extends Observable {
	private ArrayList<ArrayList<Tile>> grid;
	private Tile endingTile;
	private int gold;
	private TowerMap towerMap;
	
	public TowersOfBrimstoneModel() {
		grid = createBlankMap();
		towerMap = new TowerMap();
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
	
	public void addGold(int amount) {
		gold = gold + amount;
	} 
	
	public boolean spendGold(int amount) {
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

	public void updateTowerMap(Tower tower) {
		towerMap.addTower(tower);
	}
	
	public void updateFrame(int tick, Zombie zomb) {
		FrameMessage update = new FrameMessage(getGrid(), tick, getGold(), zomb);
		
		setChanged();
		notifyObservers(update);
	}
}
