package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Enemy6 extends Enemy{
	private Image picture;
	public Enemy6(ArrayList<Tile> path) {
		super(130, 2, 35, path);
		picture = new Image("assets/desert/enemies/6/desert6.png");
	}
	@Override
	public Image getImage() {
		return picture;
	}
	public String toString() {
		return "Enemy 6";
		
	}
}
