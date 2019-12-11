package towers;

import javafx.scene.image.Image;

public class FireTower extends Tower {
	
	
	public FireTower(int row, int col) {
		
		// Tower stats
		//  - Damage       = 25
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 150 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(25, 0.5, false, 150, 200, row, col);
		texture = "tower_fire.png";
		ammo = "fireammo.png";
	}
	
	public String toString() {
		return "Fire Tower";
	}
}
