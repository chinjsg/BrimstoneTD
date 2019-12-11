package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class HeavyTower extends Tower {
	/**
	 * This is the constructor HeavyTower 
	 * @param row
	 * @param col
	 */
	public HeavyTower(int row, int col) {
		// [High Damge - Low RoF] 
		// Tower stats
		// - Damage       = 50
		// - Rate of Fire = 1;
		// - Area Damage  = No
		// - Cost         = 300 gold
		// - Range        = 200
		// - X/Y coordinates will be set when it is placed
		super(60, 0.5, false, 210, 200, row, col);
		texture = "tower_heavy.png";
		ammo = "heavyammo.png";
	}
	/**
	 * This will print the String of HeavyTower class.
	 */
	public String toString() {
		return "Heavy Tower";
	}
}
