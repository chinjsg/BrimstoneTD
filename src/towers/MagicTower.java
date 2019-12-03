package towers;

public class MagicTower extends Tower {
	
	public MagicTower() {
		// Tower stats
		//  - Damage       = 80
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 550 gold
		//  - X/Y coordinates will be set when it is placed
		super(80, 1, false, 550, 0, 0, 6);
	}
	
	public String toString() {
		return "Magic Tower";
	}
}
