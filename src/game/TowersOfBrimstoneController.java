package game;

import java.util.ArrayList;

public class TowersOfBrimstoneController {
	
	private TowersOfBrimstoneModel model;
	private ArrayList<Tile> enemyPath;
	
	public TowersOfBrimstoneController(TowersOfBrimstoneModel model) {
		model = this.model;
	}
	
	public void placeTower() {
		
	}	
	
	public void createMap1() {
		enemyPath = new ArrayList<Tile>();
		int pathOrder = 0;
		ArrayList<ArrayList<Tile>> board = model.getGrid();
		for(int row = 0; row < board.size(); row++) {
			for(int col=0; col < board.get(0).size(); col++) {
				if(row == 14) {
					Tile path = board.get(row).get(col);
					path.setIsPath(true);
					enemyPath.add(pathOrder, path);
					pathOrder++;
				}
				else {
					Tile path = board.get(row).get(col);
					path.setIsPath(false);
				}
			}
		}
	}
	
	public ArrayList<Tile> getEnemyPath() {
		return enemyPath;
	}

}
