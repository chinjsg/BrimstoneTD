package enemies;

import java.util.ArrayList;

import game.Tile;
import javafx.scene.image.Image;

public class Map1Enemy extends Enemy{
	
	private Image picture;
	public Map1Enemy(int health, int speed, int goldReward,
			ArrayList<Tile> pathToFollow,int enemyType) {
		super(health, speed, goldReward, pathToFollow);
		System.out.println(enemyType+ "-------------------");
		if (enemyType == 1) {
			picture = new Image("assets/desert/enemies/1/desert1.png");
		}if (enemyType == 2) {
			picture = new Image("assets/desert/enemies/2/desert2.png");
		}if (enemyType == 3) {
			picture = new Image("assets/desert/enemies/3/desert3.png");
		}if (enemyType == 4) {
			picture = new Image("assets/desert/enemies/4/desert4.png");
		}if (enemyType == 5) {
			picture = new Image("assets/desert/enemies/5/desert5.png");
		}else {
			picture = new Image("assets/desert/enemies/6/desert6.png");
		}	
	}

	@Override
	public Image getImage() {
		return picture;
	}

}
