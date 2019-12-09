package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy1 extends Enemy{
	private Image picture;
	public Enemy1(ArrayList<Tile> path) {
		super(100, 2, 20, path);
		picture = new Image("assets/desert/enemies/1/desert1.png");
	}
	@Override
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 1";
		
	}

}
