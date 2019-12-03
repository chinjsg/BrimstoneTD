package towers;

public class LightningTower extends Tower {
	
	public LightningTower() {
		// Tower stats
		//  - Damage       = 15
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 100 gold
		//  - X/Y coordinates will be set when it is placed
		super(15, 1, false, 275, 0, 0, 5);
	}
	
	public String toString() {
		return "Lightning Tower";
	}
}
