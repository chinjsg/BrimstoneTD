package towers;

public class ArcherTower extends Tower {
	
	public ArcherTower() {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 100, 0, 0, "tower_1@4x.png");
	}
}
