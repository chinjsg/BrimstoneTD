package towers;

import javafx.scene.image.Image;

public class LightningTower extends Tower {
	
	public LightningTower(int row, int col) {
		// Tower stats
		//  - Damage       = 25
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 275 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(25, 1, false, 275, 200, row, col);
		texture = "tower_lightning.png";
		ammo = "lightningammo.png";
	}
	
	public String toString() {
		return "Lightning Tower";
	}
}
