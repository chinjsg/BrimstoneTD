package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
/**
 * This is the abstract class that represent all the enemy used in the game 
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public abstract class Enemy {
	protected int health;
	protected int damage;
	protected int speed;
	protected int goldReward;
	protected Point2D position;
	protected int TileIndex;
	protected ArrayList<Tile> path;
	
	
	//protected Title tile;
	/**
	 * This is the constructor of the Enemy class 
	 * @param health
	 * @param speed
	 * @param goldReward
	 * @param pathToFollow
	 * @param damage
	 */
	public Enemy(int health, int speed, int goldReward, ArrayList<Tile> pathToFollow,int damage) {
		this.health = health;
		this.speed = speed;
		this.goldReward = goldReward;
		int xPos = (int) pathToFollow.get(0).getPos().getX();
		int yPos = (int) pathToFollow.get(0).getPos().getY();
		this.damage = damage;
		path = pathToFollow;
		TileIndex = 0;
		position = new Point2D(xPos, yPos);
	}
	/**
	 * It will return the health of the enemy
	 * @return int
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * it will return the speed of the enemy
	 * @return int
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * It will return the goldreward of the enemy
	 * @return int
	 */
	public int getGoldReward() {
		return goldReward;
	}
	/**
	 * It will return the position of the enemy
	 * @return Point2d
	 */
	public Point2D getPos() {
		return position;
	}
	/** 
	 * It will helps to keep track of the health
	 * @param damage
	 */
	public void removeHealth(int damage) {
		health -= damage;
		//System.out.println("health: " + health);
	}
	/**
	 * It will helps us to path the enemy 
	 * @return  Point2D
	 */
	public Point2D getDirection() {
		Tile targetTile = path.get(TileIndex);
		Point2D direction = targetTile.getPos().subtract(position);
		double distance = direction.magnitude();
		if(distance <= 10 && TileIndex < path.size()-1) {
			TileIndex++;
		}
		direction = direction.normalize();
		return direction;
	}
	/**
	 * It will return the damage
	 * @return int
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * It will move the enemy.
	 * @param dx
	 * @param dy
	 */
	public void move(double dx, double dy) {
		position = new Point2D(position.getX()+dx, position.getY()+dy);
		
		
	}
	/**
	 * It will get the path of the image
	 * @return String
	 */
	public abstract String getImage();
//	public abstract Image getImageAttack();
//	public abstract Image getImageDie();
//	public abstract Image getImageHurt();
//	public abstract Image getImageRun();
//	public abstract Image getImageWalk();
//	public abstract int  image_width();
//	public abstract int  image_height();
//	public abstract int count();
//	public abstract int columns();
//	public abstract double preX();
//	public abstract double prey();
//	public abstract void setX(double x);
//	public abstract void setY(double y);

}
