package game;

import java.util.ArrayList;

import javafx.application.Application;

public class TowersOfBrimstone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap1();
		ArrayList<Tile> path = controller.getEnemyPath();
		
		System.out.println(path);
		
		//Application.launch(TowersOfBrimstoneView.class, args);

	}

}
