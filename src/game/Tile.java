package game;

import enemies.Enemy;
import towers.Tower;

public class Tile {
	private int row;
	private int col;
	private Enemy enemy;
	private Tower tower;
	private boolean ContainsEnemy;
	private boolean isPath;
	private boolean isPlaceable;
	
	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public boolean getIsPath() {
		return isPath;
	}
	public void setIsPath(boolean path) {
		isPath = path;
	}
	
	public boolean getContainsEnemy() {
		return ContainsEnemy;
	}
	
	public void placeEnemy(Enemy enemy) {
		this.enemy = enemy;
		ContainsEnemy = true;
	}
	
	public void setIsPlaceable(boolean placeAble) {
		isPlaceable = placeAble;
	}
	public boolean placeTower(Tower tower) {
		if(isPlaceable) {
			this.tower = tower;
		}
		return isPlaceable;
	}
	
	public void removeEnemy() {
		enemy = null;
		ContainsEnemy = false;
	}
	public String toString() {
		return "row: " + row + " col: " + col;
	}

}
