package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class StoneTower extends Tower {
	/**
	 * This is the constructor of the StoneTower Class.
	 * @param row
	 * @param col
	 */
	public StoneTower(int row, int col) {
		// [Low Damage - Very Fast RoF] 
		// Tower stats
		// - Damage       = 15
		// - Rate of Fire = 1;
		// - Area Damage  = No
		// - Cost         = 100 gold
		// - Range		  = 200
		// - X/Y coordinates will be set when it is placed
		super(18, 0.1, false, 100, 160, row, col);
		texture = "tower_stone.png";				// 65 x 65
		ammo = "stoneammo.png";					// 30 x 30
	}
	/**
	 * This will return the String of the class.
	 */
	public String toString() {
		return "Stone Tower";
	}
}
