package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Zombie extends Enemy{
	private Image picture;
	public Zombie(ArrayList<Tile> path) {
		super(100, 2, 20, path);
		picture = new Image("zombie.png");
	}
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "ZOMBIE";
		
	}
	@Override
	public Image getImageAttack() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImageDie() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImageHurt() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImageRun() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Image getImageWalk() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int image_width() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int image_height() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int columns() {
		// TODO Auto-generated method stub
		return 0;
	}

}
