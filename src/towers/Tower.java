package towers;

public class Tower {
	protected int attackPower;
	protected int rateOfFire;
	protected boolean areaDamage;	// single target - aoe
	//protected image image;
	//protected Title tile;
	public Tower(int attackPower, int rateOfFire, boolean areaDamage) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
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
}
