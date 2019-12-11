package towers;

import java.util.HashMap;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
// For storage of placed towers
public class TowerMap {

	private HashMap<Integer, Tower> placedTowers;
	private int towerID;
	/**
	 *  This is the constructor for the TowerMap class
	 */
	public TowerMap() {
		placedTowers = new HashMap<>();
		towerID = 1;
	}
	/**
	 * This will add the tower object in a HashMap.
	 * @param tower
	 */
	public void addTower(Tower tower) {
		placedTowers.put(towerID, tower);
		towerID++;
	}
}
