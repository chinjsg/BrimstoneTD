package towers;

public class IceTower extends Tower {
	
	public IceTower() {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 250, 0, 0, 3);
	}
}
