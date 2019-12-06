package towers;

public class IceTower extends Tower {
	
	public IceTower(int row, int col) {
		// Tower stats
		//  - Damage       = 20
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 250 gold
		//  - Range        = 200
		//  - X/Y coordinates will be set when it is placed
		super(20, 1, false, 250, 200, row, col, 3);
	}
	
	public String toString() {
		return "Ice Tower";
	}
}
