package towers;

import javafx.scene.image.Image;

public class StoneTower extends Tower {
	
	public StoneTower(int row, int col) {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Range		   = 200
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(2, 1, false, 100, 200, row, col);
		texture = "tower_stone.png";				// 65 x 65
		ammo = "stoneammo.png";					// 30 x 30
	}
	
	public String toString() {
		return "Stone Tower";
	}
}
