package towers;

public class FireTower extends Tower {
	
	
	public FireTower() {
		
		// Tower stats
		//  - Damage       = 25
		//  - Rate of Fire = 1;
		//  - Area Damage  = No
		//  - Cost         = 150 gold
		//  - X/Y coordinates will be set when it is placed
		super(25, 1, false, 150, 0, 0, 2);
	}
	
	public String toString() {
		return "Fire Tower";
	}
}
