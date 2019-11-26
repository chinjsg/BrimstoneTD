package game;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import towers.SampleTower;
import towers.Tower;

public class TowersOfBrimstoneView extends Application{
	private TowersOfBrimstoneController controller;
	private int money;
	private boolean togglePlacement;
	private Tower selectedTower;
	private int towerType;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1400, 1000);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		GraphicsContext valueLayer = canvas.getGraphicsContext2D();
		
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap();
		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		System.out.println(grid);
		
		
		money = model.getGold();
		togglePlacement = false;
		towerType = 1; // temp
		selectedTower = controller.getTowerType(1); // temp

		
		gc.fillText("Money: " + Integer.toString(money), 100, 100);
		root.setCenter(canvas);
		Scene scene = new Scene(root, 1400, 1000);
		canvas.setOnMouseClicked((event)->{
			int xPos = (int) event.getX();
			int yPos = (int) event.getY();
			
			int row = yPos/50;
			int col = xPos/50;

			System.out.println("ROW " + row + " COL " + col);
			
			//Check tower on this spot
			controller.checkTower(row, col);
			
			// Used to stop placement on Right Click
			if (event.getButton() == MouseButton.SECONDARY && togglePlacement == true) {
				togglePlacement = false;
			}
			
			// Tower Placement logic
			int temp = 15; //depending on where the store menu starts graphically
			if (togglePlacement == true && row < temp) {
				boolean isPlaced = controller.placeTower(row, col, selectedTower);
				if (isPlaced) {
					money = model.getGold();
					System.out.println("Tower has been placed!");
				} else {
					System.out.println("Cannot place on this spot or insufficient funds");
				}
			}
			
			// test--TEMPORARY HIDDEN BUTTON FOR TOGGLING PLACEMENT -- to be triggered when selecting a tower in the GUIMenu
			if (row == 0 && col == 27) { // Top right corner
				togglePlacement = !togglePlacement;
				System.out.println("togglePlacement is " + togglePlacement);
			}
			// test--TEMP FOR CYCLING THROUGH AVAILABLE TOWERS -- to be removed
			if (row == 1 && col == 27) { // Top right corner
				if (towerType == 1) {
					towerType = 2;
					selectedTower = controller.getTowerType(towerType);
					System.out.println(selectedTower.getAttackPower());
					System.out.println("You have selected to place Archer Towers! (" + towerType + ")");
				} else {
					towerType = 1;
					selectedTower = controller.getTowerType(towerType);
					System.out.println(selectedTower.getAttackPower());
					System.out.println("You have selected to place Sample Towers! (" + towerType + ")");
				}
			}	
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
	
		new AnimationTimer() {
			long lastUpdate = 0;
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long timeSec = (now - lastUpdate)/(1000000000/30);				// 30 Frames every 1 sec.
				if(timeSec >= 1) {
					for(int row = 0; row < grid.size(); row++) {
						for(int col=0; col < grid.get(0).size(); col++) {
							Tile tile = grid.get(row).get(col);
							gc.drawImage(tile.getTexture(), 50*col, 50*row);
						}
					}
					valueLayer.fillText("Money: " + money, 200, 200);
					lastUpdate = now;
			}
				
			}
			
		}.start();
		
	}

}
