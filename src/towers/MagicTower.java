package towers;

public class MagicTower extends Tower {
	
	public MagicTower() {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 550, 0, 0, 6);
	}
}
