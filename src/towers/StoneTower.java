package towers;

public class StoneTower extends Tower {
	
	public StoneTower(int row, int col) {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Range		   = 200
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 100, 200, row, col, 1);
	}
	
	public String toString() {
		return "Stone Tower";
	}
}
