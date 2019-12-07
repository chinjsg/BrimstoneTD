package towers;

import javafx.scene.image.Image;

public class MagicTower extends Tower {
	
	public MagicTower(int row, int col) {
		// Tower stats
		//  - Damage       = 80
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Range        = 200
		//  - Cost         = 550 gold
		//  - X/Y coordinates will be set when it is placed
		super(80, 1, false, 550, 200, row, col);
		texture = new Image("tower_magic.png");
	}
	
	public String toString() {
		return "Magic Tower";
	}
}
