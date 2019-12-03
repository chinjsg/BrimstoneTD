package towers;

public class HeavyTower extends Tower {
	
	public HeavyTower() {
		// Tower stats
		//  - Damage       = 50
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 300 gold
		//  - X/Y coordinates will be set when it is placed
		super(50, 1, false, 300, 0, 0, 4);
	}
	
	public String toString() {
		return "Heavy Tower";
	}
}
