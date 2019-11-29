package game;

import java.util.ArrayList;


import enemies.Enemy;
import enemies.Zombie;
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
import javafx.scene.control.Label;
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
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1000;
	private int time;
	private int money;
	private AnchorPane base;
	private boolean togglePlacement;
	private Tower selectedTower;



	@Override
	public void start(Stage primaryStage) throws Exception {
		base = new AnchorPane();
		time = 1;
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1400, 1000);
		Canvas selectionCanvas = new Canvas(1400, 1000);
		Canvas enemies = new Canvas(1400,1000);
		GraphicsContext enemyGc = enemies.getGraphicsContext2D();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		GraphicsContext gc2 = selectionCanvas.getGraphicsContext2D();
		gc.drawImage(new Image("test-easyMapSmallerFixedSpots.png", 1400, 1000, false, false), 0, 0);
		GraphicsContext towerMenuLayer = canvas.getGraphicsContext2D();

		
		

		model = new TowersOfBrimstoneModel();
		money = model.getGold();
		controller = new TowersOfBrimstoneController(model);
		controller.createMap();
		
		String str = "Gold: " + Integer.toString(money);
		Label gold = new Label(str);
		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		
		controller.getEnemyPath();
		
		System.out.println(grid);

		
		togglePlacement = false;
		selectedTower = controller.getTowerType(1); // temp

		root.getChildren().add(canvas);
		root.getChildren().add(enemies);
		root.getChildren().add(selectionCanvas);
		base.getChildren().add(root);
		base.getChildren().add(gold);
		
		base.setTopAnchor(gold, 200.00);
		base.setLeftAnchor(gold, 200.00);
		setUpTowerMenu();
		Scene scene = new Scene(base, 1400, 1000);
		selectionCanvas.setOnMouseClicked((event) -> {
			int xPos = (int) event.getX();
			int yPos = (int) event.getY();
			int row = yPos / 50;
			int col = xPos / 50;

			System.out.println("ROW " + row + " COL " + col);

			// Check tower on this spot
			controller.checkTower(row, col);

			// Used to stop placement on Right Click
			if (event.getButton() == MouseButton.SECONDARY
					&& togglePlacement == true) {
				togglePlacement = false;
				System.out.println("Tower Placement disabled!");
			}

			// Tower Placement logic
			int temp = 15; // depending on where the store menu starts graphically
			if (togglePlacement == true && row < temp) {
				boolean isPlaced = controller.placeTower(row, col, selectedTower);
				if (isPlaced) {
					money = model.getGold();
					System.out.println("Tower has been placed!");
				} else {
					System.out.println(
							"Cannot place on this spot or insufficient funds");
				}
			}
		});

		Zombie zomb = new Zombie(0,6, controller.getEnemyPath());
		
		

		primaryStage.setScene(scene);
		primaryStage.show();
		
		new AnimationTimer() {
			long lastUpdate = 0;
			int tick = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long timeSec = (now - lastUpdate)/(1000000000/60);				// 60 Frames every 1 sec.
				if(timeSec >= 1) {
					for (int row = 0; row < grid.size(); row++) {
						for (int col = 0; col < grid.get(0).size(); col++) {
							Tile tile = grid.get(row).get(col);
							if (tile.getPlacedTower() != null) {
								Tower tower = tile.getPlacedTower();
								gc2.drawImage(tower.getImage(), 50 * col - 4, 50 * row - 15, 65, 65);
							}
						}
						if(tick%20 == 0) {
							updateEnemy(zomb, enemyGc);
						}
						tick++;
					}
					towerMenuLayer.drawImage(new Image("menuTowerEmpty2.png"), 0, 900, 1400, 100);
					String str = "Gold: " + money;
					gold.setText(str);
					lastUpdate = now;
				}
				

			}

		}.start();

	}
						
						
						
						
	private void updateEnemy(Enemy enemy, GraphicsContext d) {
		d.clearRect(0, 0, WIDTH, HEIGHT);
		enemy.move(enemy.getSpeed()*enemy.getDirection().getX(), enemy.getSpeed()*enemy.getDirection().getY());
		d.drawImage(enemy.getImage(), enemy.getPos().getX()-25, enemy.getPos().getY()-25);
		
	}

	private void setUpTowerMenu() {
		int height = 90;
		int width = 110;
		HBox hBox = new HBox();
		stone = new ImageButton("stone.png", width, height);
		fire = new ImageButton("fire.png", width, height);
		ice = new ImageButton("ice.png", width, height);
		heavy = new ImageButton("heavy.png", width, height);
		lightning = new ImageButton("lightning.png", width, height);
		magic = new ImageButton("magic.png", width, height);
		slowdown = new ImageButton("slowdown.png", width, height);
		damageboost = new ImageButton("damageboost.png", width, height);

		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(75);
		hBox.setPadding(new Insets(0, 0, 0, 35));
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
				selectedTower = controller.getTowerType(3);
				System.out.println("Selected Ice tower");
			} else if (event.getSource().equals(heavy)) {
				selectedTower = controller.getTowerType(4);
				System.out.println("Selected Heavy tower");
			} else if (event.getSource().equals(lightning)) {
				selectedTower = controller.getTowerType(5);
				System.out.println("Selected Lightning tower");
			} else if (event.getSource().equals(magic)) {
				selectedTower = controller.getTowerType(6);
				System.out.println("Selected Magic tower");
			} else if (event.getSource().equals(slowdown)) {
				System.out.println("Unimplemented Ability 1");
			} else if (event.getSource().equals(damageboost)) {
				System.out.println("Unimplemented Ability 2");
			}
		}
	}
}