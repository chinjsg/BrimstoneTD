package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class LightningTower extends Tower {
	/**
	 * This is the constructor for the Lightning tower
	 * @param row
	 * @param col
	 */
	public LightningTower(int row, int col) {
		// [Average Damage - Fast RoF]
		// Tower stats
		// - Damage       = 25
		// - Rate of Fire = 1;
		// - Area Damage  = No
		// - Cost         = 275 gold
		// - Range        = 200
		// - X/Y coordinates will be set when it is placed
		super(24, 0.2, false, 275, 200, row, col);
		texture = "tower_lightning.png";
		ammo = "lightningammo.png";
	}
	/**
	 * This will return the String of class.
	 */
	public String toString() {
		return "Lightning Tower";
	}
}
