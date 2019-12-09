package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Zombie extends Enemy{
	private   double x;
	private   double y;
	private Image picture;
	public Zombie(ArrayList<Tile> path) {
		super(100, 2, 20, path);
		picture = new Image("DesertCommon.png");
	}
	public Image getImage() {
		return picture;
	}
<<<<<<< HEAD
	public String toString() {
		return "ZOMBIE";
		
	}
=======
	@Override
	public Image getImageAttack() {
		return null;
	}
	@Override
	public Image getImageDie() {
		return null;
	}
	@Override
	public Image getImageHurt() {
		return null;
	}
	@Override
	public Image getImageRun() {
		return null;
	}
	@Override
	public Image getImageWalk() {
		return null;
	}
	@Override
	public int image_width() {
		return 0;
	}
	@Override
	public int image_height() {
		return 0;
	}
	@Override
	public int count() {
		return 0;
	}
	@Override
	public int columns() {
		return 0;
	}
	
>>>>>>> Map_Path_Array
}
