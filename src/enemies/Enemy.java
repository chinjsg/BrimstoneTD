package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Enemy {
	protected int health;
	protected int speed;
	protected int goldReward;
	protected Point2D position;
	protected int TileIndex;
	protected ArrayList<Tile> path;
	
	
	//protected Title tile;
	
	public Enemy(int health, int speed, int goldReward, int row, int col, ArrayList<Tile> pathToFollow) {
		this.health = health;
		this.speed = speed;
		this.goldReward = goldReward;
		int xPos = row*50+25;
		int yPos = col*50+25;
		path = pathToFollow;
		TileIndex = 0;
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
	public Point2D getPos() {
		return position;
	}
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
	public void move(double d, double e) {
		position = new Point2D(position.getX()+d, position.getY()+e);
		
	}
	public abstract Image getImage();
	public abstract Image getImageAttack();
	public abstract Image getImageDie();
	public abstract Image getImageHurt();
	public abstract Image getImageRun();
	public abstract Image getImageWalk();
	public abstract int  image_width();
	public abstract int  image_height();
	public abstract int count();
	public abstract int columns();
	
}
