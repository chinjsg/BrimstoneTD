package game;

import java.util.ArrayList;

import towers.StoneTower;
import towers.FireTower;
import towers.HeavyTower;
import towers.IceTower;
import towers.LightningTower;
import towers.MagicTower;
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
		ArrayList<ArrayList<Tile>> board = model.getGrid();
	
		int[][] path = 
		{ 	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 2, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 1, 0, 2, 0, 0},
			{1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
				}
				else if(path[row][col] == 2) {
					tile.setIsPlaceable();
				}
			}
		}
		model.setEnd(4, 27);
		createPath(6, 0);
	}
	public boolean createPath(int row, int col) {
		boolean found = false;
		System.out.println("ROW: "+ row + " COL: " + col);
		if(col < model.getRow(row).size() && row < model.getCol(col).size()) {
		if(model.getRow(row).get(col).equals(model.getEnd())) {
			enemyPath.add(model.getRow(row).get(col));
			found = true;
			return found;
		}
		if(enemyPath.contains(model.getRow(row).get(col))) {
			return false;
		}
		if(model.getRow(row).get(col).getIsPath()) {
			enemyPath.add(model.getRow(row).get(col));
			if(!found)
				found = createPath(row, col+1);
			if(!found)
				found = createPath(row+1, col);
			if(!found)
				found = createPath(row-1, col);
			if(!found)
				found = createPath(row, col-1);
		}
		}
		return found;
	}

	public ArrayList<Tile> getEnemyPath(){
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
			System.out.println("The price of this " + String.valueOf(tower.getCost()) + " gold "
					+ "and it is placed on Row: " + tower.getRow() + " and Col:" + tower.getCol());
		}
		
	}
	
	public Tower getTowerType(int towerNum) {
		Tower tower = null;
		if (towerNum == 1) {
			tower = new StoneTower();
		} else if (towerNum == 2) {
			tower = new FireTower();
		} else if (towerNum == 3) {
			tower = new IceTower();
		} else if (towerNum == 4) {
			tower = new HeavyTower();
		} else if (towerNum == 5) {
			tower = new LightningTower();
		} else if (towerNum == 6) {
			tower = new MagicTower();
		}
		return tower;
	}
}
