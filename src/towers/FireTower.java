package towers;

import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class FireTower extends Tower {
	/** 
	 * This is the constructor of the FireTower
	 * @param row
	 * @param col
	 */
	public FireTower(int row, int col) {
		
		// Tower stats
		//  - Damage       = 25
		//  - Rate of Fire = 1;  1 ~ 5 sec 0.5 ~ 2.5sec
		//  - Area Damage  = No
		//  - Cost         = 150 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(25, 1, false, 150, 200, row, col);
		texture = "tower_fire.png";
		ammo = "fireammo.png";
	}
	/**
	 * This will print Fire Tower String
	 */
	public String toString() {
		return "Fire Tower";
	}
}
