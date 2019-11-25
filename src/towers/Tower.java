package towers;

public class Tower {
	protected int attackPower;
	protected int rateOfFire;
	protected boolean areaDamage;	// single target - aoe
	protected int cost;
	//protected image image;
	//protected Title tile;
	
	public Tower(int attackPower, int rateOfFire, boolean areaDamage, int cost) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
		this.cost = cost;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public int getRateOfFire() {
		return rateOfFire;
	}
	
	public boolean getAreaDamage() {
		return areaDamage;
	}
	
	public int getCost() {
		return cost;
	}
}
