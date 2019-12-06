package towers;

import java.util.ArrayList;
import java.util.Iterator;

import enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

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
	private Image texture;
	protected String image_path;
	//protected image image;
	//protected Title tile;
	
	public Tower(int attackPower, int rateOfFire, boolean areaDamage, int cost, int range, int row, int col, int imageNum) {
		this.attackPower = attackPower;
		this.rateOfFire = rateOfFire;
		this.areaDamage = areaDamage;
		this.cost = cost;
		this.row = row;
		this.col = col;
		this.range = range;
		projectiles = new ArrayList<Projectile>();
		
		pos = new Point2D(col*50+25, row*50+25);
		
		if (imageNum == 1) {
			image_path = "tower_stone.png";
		} else if (imageNum == 2) {
			image_path = "tower_fire.png";
		} else if (imageNum == 3) {
			image_path = "tower_ice.png";
		} else if (imageNum == 4) {
			image_path = "tower_heavy.png";
		} else if (imageNum == 5) {
			image_path = "tower_lightning.png";
		} else {
			image_path = "tower_magic.png";
		}
		this.texture = new Image(image_path);
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
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	public int getRange() {
		return range;
	}
	
	public Point2D getPos() {
		return pos;
		
	}
	
	public Image getImage() {
		return texture;
	}
	
	public int getSellPrice() {
		return (int) (0.8 * cost);
	}
	
	public void fire(Enemy enemy) {
		projectiles.add(new Projectile(enemy));
	}
	
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
		private int speed = 10;
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
		public Image getImage() {
			return new Image("fireball.png");
		}
		public Point2D getPos() {
			return projPoint;
		}
	}
	
}