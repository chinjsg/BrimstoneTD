package enemies;

import javafx.geometry.Point2D;

public abstract class Enemy {
	protected int health;
	protected int speed;
	protected int goldReward;
	protected Point2D position;
	//protected image image;
	//protected Title tile;
	
	public Enemy(int health, int speed, int goldReward, int row, int col) {
		this.health = health;
		this.speed = speed;
		this.goldReward = goldReward;
		int xPos = row*50+25;
		int yPos = col*50+25;
		position = new Point2D(xPos, yPos);
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
