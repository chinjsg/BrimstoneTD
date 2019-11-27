package towers;

import java.util.HashMap;

// For storage of placed towers
public class TowerMap {

	private HashMap<Integer, Tower> placedTowers;
	private int towerID;
	
	public TowerMap() {
		placedTowers = new HashMap<>();
		towerID = 1;
	}
	
	public void addTower(Tower tower) {
		placedTowers.put(towerID, tower);
		towerID++;
	}
}
