package towers;

import javafx.scene.image.Image;

public class HeavyTower extends Tower {
	
	public HeavyTower(int row, int col) {
		// Tower stats
		//  - Damage       = 50
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 300 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(50, 1, false, 300, 200, row, col);
		texture = new Image("tower_heavy.png",65,65,false,false);
		ammo = new Image("heavyammo.png",30,20,false,false);
	}
	
	public String toString() {
		return "Heavy Tower";
	}
}
