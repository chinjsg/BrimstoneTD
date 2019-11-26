package towers;

public class SampleTower extends Tower {

	public SampleTower() {
		// Tower stats
		//  - Damage       = 10
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 50 gold
		//  - X/Y coordinates will be set when it is placed
		super(10, 1, false, 50, 0, 0);
	}
}
