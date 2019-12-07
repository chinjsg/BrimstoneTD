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
		super(25, 1, false, 150, 200, row, col);
		texture = new Image("tower_fire.png");
	}
	
	public String toString() {
		return "Fire Tower";
	}
}
