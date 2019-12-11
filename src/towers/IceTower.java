package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class IceTower extends Tower {
	/**
	 * This is the constructor of IceTower
	 * @param row
	 * @param col
	 */
	public IceTower(int row, int col) {
		// [Medium Damage - Average firing]
		// Tower stats
		// - Damage       = 20
		// - Rate of Fire = 1;
		// - Area Damage  = No
		// - Cost         = 250 gold
		// - Range        = 200
		// - X/Y coordinates will be set when it is placed
		super(38, 0.3, false, 180, 250, row, col);
		texture = "tower_ice.png";
		ammo = "iceammo.png";
	}
	/**
	 * This will  return the IceTower String.
	 */
	public String toString() {
		return "Ice Tower";
	}
}
