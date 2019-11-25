package enemies;

public abstract class Enemy {
	protected int health;
	protected int speed;
	protected int goldReward;
	//protected image image;
	//protected Title tile;
	
	public Enemy(int health, int speed, int goldReward) {
		this.health = health;
		this.speed = speed;
		this.goldReward = goldReward;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getGoldReward() {
		return goldReward;
	}

}
