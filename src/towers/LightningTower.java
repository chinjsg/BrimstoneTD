package towers;

public class LightningTower extends Tower {
	
	public LightningTower() {
		// Tower stats
		//  - Damage       = 25
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 275 gold
		//  - X/Y coordinates will be set when it is placed
		super(25, 1, false, 275, 0, 0, 5);
	}
	
	public String toString() {
		return "Lightning Tower";
	}
}
