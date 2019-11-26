package game;

import java.util.ArrayList;

import towers.ArcherTower;
import towers.SampleTower;
import towers.Tower;
import towers.TowerMap;

public class TowersOfBrimstoneController {
	
	private TowersOfBrimstoneModel model;
	private ArrayList<Tile> enemyPath;
	
	public TowersOfBrimstoneController(TowersOfBrimstoneModel model) {
		this.model = model;
	}
	
	public void createMap() {
		enemyPath = new ArrayList<Tile>();
		int pathOrder = 0;
		ArrayList<ArrayList<Tile>> board = model.getGrid();
	
		int[][] path = 
		{ 	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 2, 2, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 1, 1, 1, 1, 2, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		};
		
		for(int row = 0; row < path.length; row++) {
			for(int col = 0; col < path[0].length; col++) {
				Tile tile = board.get(row).get(col);
				if(path[row][col] == 1) {
					tile.setIsPath();
					enemyPath.add(pathOrder, tile);
					pathOrder++;
				}
				else if(path[row][col] == 2) {
					tile.setIsPlaceable();
				}
			}
		}
	}

	public ArrayList<Tile> getEnemyPath() {
		return enemyPath;
	}
	
	public boolean placeTower(int row, int col, Tower tower) {
		ArrayList<ArrayList<Tile>> board = model.getGrid();
		Tile tile = board.get(row).get(col);
		
		// Check that the selected grid is not a path, isPlaceable and no tower has already been placed
		if (!tile.getIsPath() && tile.getIsPlaceable() && tile.getPlacedTower() == null) {
			int price = tower.getCost();
			if (price <= model.getGold()) {
				tower.setPlacementCoordinates(row, col);
				tile.placeTower(tower);
				model.spendGold(price);
				model.updateTowerMap(tower);
				return true;
			}
		}
		return false;
	}
	
	public void checkTower(int row, int col) {
		ArrayList<ArrayList<Tile>> board = model.getGrid();
		Tile tile = board.get(row).get(col);
		
		if (tile.getPlacedTower() != null) {
			Tower tower = tile.getPlacedTower();
			System.out.println("This tower has " + String.valueOf(tower.getAttackPower()) + " AP "
					+ "and it is placed on Row: " + tower.getRow() + " and Col:" + tower.getCol());
		}
		
	}
	
	public Tower getTowerType(int towerNum) {
		Tower tower = null;
		if (towerNum == 1) {
			tower = new SampleTower();
		} else if (towerNum == 2) {
			tower = new ArcherTower();
		}
		return tower;
	}
}
