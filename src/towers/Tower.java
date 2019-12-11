package towers;

import java.util.ArrayList;
import java.util.Iterator;

import enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public abstract class Tower {
	protected int attackPower;
	protected int rateOfFire;
	protected boolean areaDamage;	// single target - aoe
	protected int cost;
	protected Point2D pos;
	protected int row;
	protected int col;
	protected int range;
	protected ArrayList<Projectile> projectiles;
	protected String texture;
	protected String ammo;
	
	//protected image image;
	//protected Title tile;
	/**
	 * This is the constructor of  the of Tower Abstract class. 
	 * @param attackPower
	 * @param rateOfFire
	 * @param areaDamage
	 * @param cost
	 * @param range
	 * @param row
	 * @param col
	 */
	public Tower(int attackPower, int rateOfFire, boolean areaDamage, int cost, int range, int row, int col) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
		this.cost = cost;
		this.row = row;
		this.col = col;
		this.range = range;
		projectiles = new ArrayList<Projectile>();
		
		pos = new Point2D(col*50+25, row*50+25);
		
	}
	/**
	 * This will return the power of the tower
	 * @return int 
	 */
	public int getAttackPower() {
		return attackPower;
	}
	/**
	 * This will return the RateofFire 
	 * @return int
	 */
	public int getRateOfFire() {
		return rateOfFire;
	}
	/**
	 * This is return whether a tower does a area damage or not.
	 * @return boolean
	 */
	public boolean getAreaDamage() {
		return areaDamage;
	}
	/**
	 * This will return the cost of the tower
	 * @return int
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * This will return the row
	 * @return int
	 */
	public int getRow() {
		return row;
	}
	/**
	 * This will return the col
	 * @return int
	 */
	public int getCol() {
		return col;
	}
	/**
	 * This will return the range
	 * @return int 
	 */
	public int getRange() {
		return range;
	}
	/**
	 * This will return the position
	 * @return Point2D
	 */
	public Point2D getPos() {
		return pos;
		
	}
	/**
	 * This will return the image 
	 * @return String
	 */
	public String getImage() {
		return texture;
	}
	/**
	 * This will help us to return the sell price for the tower
	 * @return int
	 */
	public int getSellPrice() {
		return (int) (0.8 * cost);
	}
	/**
	 * This will add enemy to the projectile
	 * @param enemy
	 */
	public void fire(Enemy enemy) {
		projectiles.add(new Projectile(enemy));
	}
	/**
	 *  This will help us to update the projectile
	 */
	public void updateProjectiles(){
		if(projectiles.size() > 0) {
			Iterator<Projectile> iterator = projectiles.iterator();
			while(iterator.hasNext()) {
				Projectile projectile = (Projectile) iterator.next();
				if(projectile.update()) {
					iterator.remove();
				}
			}
		}
	}
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public class Projectile {
		private Point2D projPoint;
		private Enemy enemy;
		private int speed = 4;
		private Projectile(Enemy target) {
			projPoint = pos;
			enemy = target;
		}
		private boolean update() {
			Point2D direction = (enemy.getPos().subtract(projPoint)).normalize();
			Point2D velocity = new Point2D(direction.getX()*speed, direction.getY()*speed);
			projPoint = new Point2D(projPoint.getX() + velocity.getX(), projPoint.getY() + velocity.getY());
			int distance = (int) enemy.getPos().distance(projPoint);
			if(distance <= 15){
				enemy.removeHealth(attackPower);
				return true;
			}
			return false;
		}
		public String getImage() {
			return ammo;
		}
		public Point2D getPos() {
			return projPoint;
		}
	}
	
}