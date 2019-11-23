package enemies;

public abstract class Enemy {
	protected int health;
	protected int speed;
	//protected image image;
	//protected Title tile;
	public Enemy(int health, int speed) {
		this.health = health;
		this.speed = speed;
	}
	
	public int getHealth() {
		return health;
	}
	public int getSpeed() {
		return speed;
	}
	

}
