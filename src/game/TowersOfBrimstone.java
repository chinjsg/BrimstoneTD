package game;

import java.util.ArrayList;

import javafx.application.Application;

public class TowersOfBrimstone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
//		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
//		controller.createMap();
//		ArrayList<Tile> path = controller.getEnemyPath();
//		
//		System.out.println(path);
		
		//Application.launch(TowersOfBrimstoneView.class, args);

		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		
		
		for (int col = 0; col < grid.get(5).size(); col++) {
			grid.get(8).get(col).setIsPath(true);
		}
		
		for (int row = 0; row < grid.size(); row++) {
			for (int col = 0; col < grid.get(row).size(); col++) {
				if (grid.get(row).get(col).getIsPath() == true) {
					System.out.print("+ ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		

		//System.out.println(model.getGold());
		//Application.launch(TowersOfBrimstoneView.class, args);
	}

}
