package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy4 extends Enemy{
	private Image picture;
	public Enemy4(ArrayList<Tile> path) {
		super(115, 2, 30, path);
		picture = new Image("assets/desert/enemies/4/desert4.png");
	}
	@Override
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 4";
		
	}
}
