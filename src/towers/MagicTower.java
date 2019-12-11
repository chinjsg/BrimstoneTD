package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class MagicTower extends Tower {
	/**
	 * This is the constructor of the MagicTower class
	 * @param row
	 * @param col
	 */
	public MagicTower(int row, int col) {
		// Tower stats
		//  - Damage       = 80
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Range        = 200
		//  - Cost         = 550 gold
		//  - X/Y coordinates will be set when it is placed
		super(80, 1, false, 550, 200, row, col);
		texture = "tower_magic.png";
		ammo = "magicammo.png";
	}
	/**
	 * This will return the String of the class.
	 */
	public String toString() {
		return "Magic Tower";
	}
}