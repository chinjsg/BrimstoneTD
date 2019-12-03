package towers;

public class IceTower extends Tower {
	
	public IceTower() {
		// Tower stats
		//  - Damage       = 20
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 250 gold
		//  - X/Y coordinates will be set when it is placed
		super(20, 1, false, 250, 0, 0, 3);
	}
	
	public String toString() {
		return "Ice Tower";
	}
}
