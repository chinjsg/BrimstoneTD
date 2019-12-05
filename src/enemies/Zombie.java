package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Zombie extends Enemy{
	private Image picture;
	public Zombie(int row, int col, ArrayList<Tile> path) {
		super(100, 2, 20, row, col, path);
		picture = new Image("zombie.png");
	}
	public Image getImage() {
		return picture;
	}
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
	
}
