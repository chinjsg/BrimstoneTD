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
	

}
