package towers;

public class HeavyTower extends Tower {
	
	public HeavyTower(int row, int col) {
		// Tower stats
		//  - Damage       = 50
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 300 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(50, 1, false, 300, 200, row, col, 4);
	}
	
	public String toString() {
		return "Heavy Tower";
	}
}
