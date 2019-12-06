package game;

import java.util.ArrayList;

import enemies.Zombie;
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
	private Zombie zomb;
	
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
		//System.out.println("ROW: "+ row + " COL: " + col);
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
	
	public boolean placeTower(int row, int col, int selectedTowerType) {
		ArrayList<ArrayList<Tile>> board = model.getGrid();
		Tile tile = board.get(row).get(col);
		Tower tower = getTowerType(row, col, selectedTowerType);
		// Check that the selected grid is not a path, isPlaceable and no tower has already been placed
		if (!tile.getIsPath() && tile.getIsPlaceable() && tile.getPlacedTower() == null) {
			int price = tower.getCost();
			if (price <= model.getGold()) {
				return model.placeTower(row, col, tower);
			}
		}
		return false;
	}

	public Tower checkTower(int row, int col) {
		ArrayList<ArrayList<Tile>> board = model.getGrid();
		Tile tile = board.get(row).get(col);
		
		if (tile.getPlacedTower() != null) {
			return tile.getPlacedTower();
		}
		return null;
		
	}
	
	private Tower getTowerType(int row, int col, int towerNum) {
		Tower tower = null;
		if (towerNum == 1) {
			tower = new StoneTower(row, col);
		} else if (towerNum == 2) {
			tower = new FireTower(row, col);
		} else if (towerNum == 3) {
			tower = new IceTower(row, col);
		} else if (towerNum == 4) {
			tower = new HeavyTower(row, col);
		} else if (towerNum == 5) {
			tower = new LightningTower(row, col);
		} else if (towerNum == 6) {
			tower = new MagicTower(row, col);
		}
		return tower;
	}
	
	public void sellTower(Tower tower) {
		int row = tower.getRow();
		int col = tower.getCol();
		int sellback = tower.getSellPrice();
		model.removeTower(row, col, sellback);
	}
	
	private void collisionDetection(int tick) {
		ArrayList<Tower> towers = model.getTowers();
		int range;
		for(Tower tower : towers) {
			range = tower.getRange();
			double distance = tower.getPos().distance(zomb.getPos());
			if(distance <= range && tick % 10 == 0) {
				tower.fire(zomb);
			}
			tower.updateProjectiles();
		}
	}
	
	
	
	public void frameUpdate(int tick, Zombie zomb) {
		this.zomb = zomb;
		collisionDetection(tick);
		model.updateFrame(tick, zomb);
		
		
	}
}
