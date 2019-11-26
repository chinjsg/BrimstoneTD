package towers;

public class FireTower extends Tower {
	
	
	public FireTower() {
		
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 150, 0, 0, 2);
	}
}
