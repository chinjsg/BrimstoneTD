package game;

import java.util.ArrayList;

import experimenting.ImageButton;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import towers.Tower;

public class TowersOfBrimstoneView extends Application {
	
	ImageButton stone;
	ImageButton fire;
	ImageButton ice;
	ImageButton heavy;
	ImageButton lightning;
	ImageButton magic;
	ImageButton slowdown;
	ImageButton damageboost;
	
	private TowersOfBrimstoneModel model;
    private TowersOfBrimstoneController controller;
    private int money;
    private AnchorPane base;
    private boolean togglePlacement;
	private Tower selectedTower;
	private int towerType;

    @Override
    public void start(Stage primaryStage) throws Exception {
	base = new AnchorPane();
	BorderPane root = new BorderPane();
	Canvas canvas = new Canvas(1400, 1000);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	//gc.drawImage(new Image("easyMap.png",1400,1000, false, false),0, 0);
	GraphicsContext valueLayer = canvas.getGraphicsContext2D();
	GraphicsContext towerMenuLayer = canvas.getGraphicsContext2D();

	model = new TowersOfBrimstoneModel();
	controller = new TowersOfBrimstoneController(model);
	controller.createMap();

	ArrayList<ArrayList<Tile>> grid = model.getGrid();
	System.out.println(grid);

	money = model.getGold();
	togglePlacement = false;
	towerType = 1; // temp
	selectedTower = controller.getTowerType(1); // temp

	gc.fillText("Money: " + Integer.toString(money), 100, 100);
	root.setCenter(canvas);
	base.getChildren().add(root);
	setUpTowerMenu();
	Scene scene = new Scene(base, 1400, 1000);
	canvas.setOnMouseClicked((event) -> {
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
			System.out.println("Tower Placement enabled: " + togglePlacement);
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
		long timeSec = (now - lastUpdate) / (1000000000 / 30); // 30 Frames every 1 sec.
		if (timeSec >= 1) {
		    for (int row = 0; row < grid.size(); row++) {
		    	
				for (int col = 0; col < grid.get(0).size(); col++) {
				    Tile tile = grid.get(row).get(col);
				    gc.drawImage(tile.getTexture(), 50 * col, 50 * row);
				    if (tile.getPlacedTower() != null) {
				    	Tower t = tile.getPlacedTower();
				    	gc.drawImage(t.getImage(), 50*col, 50*row, 70, 70);
				    }
				    
				}
		    }
		   
		    towerMenuLayer.drawImage(new Image("menuTowerEmpty.png"), 0, 900, 1400, 100);
		    valueLayer.fillText("Money: " + money, 200, 200);
		    lastUpdate = now;
		}

	    }

	}.start();

    }

    private void setUpTowerMenu() {
	int height = 90;
	int width = 110;
	HBox hBox = new HBox();
	stone = new ImageButton("stone.png",width, height);
	fire = new ImageButton("fire.png", width, height);
	ice = new ImageButton("ice.png", width, height);
	heavy = new ImageButton("heavy.png", width, height);
	lightning = new ImageButton("lightning.png", width, height);
	magic = new ImageButton("magic.png", width, height);
	slowdown = new ImageButton("slowdown.png", width, height);
	damageboost = new ImageButton("damageboost.png", width, height);

	hBox.setAlignment(Pos.CENTER);
	hBox.setSpacing(100);
	hBox.setPadding(new Insets(0, 0, 0, 50));
	hBox.getChildren().add(stone);
	hBox.getChildren().add(fire);
	hBox.getChildren().add(ice);
	hBox.getChildren().add(heavy);
	hBox.getChildren().add(lightning);
	hBox.getChildren().add(magic);
	hBox.getChildren().add(slowdown);
	hBox.getChildren().add(damageboost);
	base.getChildren().add(hBox);
	
	base.setBottomAnchor(hBox, 25.0);
	
	for (Node btn : hBox.getChildren()) {
		((ImageButton) btn).setOnAction(new ButtonListener());
	}
    }

    private class ButtonListener implements EventHandler<ActionEvent> {

		/**
		 * Handle logic when button is clicked
		 *
		 * @param event the ActionEvent
		 */
		@Override
		public void handle(ActionEvent event) {
			togglePlacement = true;
			System.out.println("Tower Placement enabled: " + togglePlacement);

			if (event.getSource().equals(stone)) {
				selectedTower = controller.getTowerType(1);
				System.out.println("Selected Stone tower");
			} else if (event.getSource().equals(fire)) {
				selectedTower = controller.getTowerType(2);
				System.out.println("Selected Fire tower");		
			} else if (event.getSource().equals(ice)) {
				System.out.println("ice");		
			} else if (event.getSource().equals(heavy)) {
				System.out.println("heavy");		
			} else if (event.getSource().equals(lightning)) {
				System.out.println("lightning");		
			} else if (event.getSource().equals(magic)) {
				System.out.println("magic");		
			} else if (event.getSource().equals(slowdown)) {
				System.out.println("slowdown");		
			} else if (event.getSource().equals(damageboost)) {
				System.out.println("damageboost");		
			}
			
		}	
	}
}