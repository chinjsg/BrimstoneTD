package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
import javafx.scene.image.ImageView;
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

public class TowersOfBrimstoneView extends Application implements Observer {

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
	//private int money;
	private AnchorPane base;
	private boolean togglePlacement;
	private int selectedTowerType;
	
	private GraphicsContext enemyGc;
	private GraphicsContext gc;
	private GraphicsContext gc2;
	private GraphicsContext towerMenuLayer;
	private Label currency;
	int tick;
	boolean highlighted = false;
	int prevCol = 0;
	int prevRow = 19;
	private AnchorPane towerStatMenu;
	GraphicsContext towerStatView;
	private boolean isSelected;
	private Tower towerView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		towerStatMenu = new AnchorPane();
		base = new AnchorPane();
		time = 1;
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1400, 1000);
		Canvas selectionCanvas = new Canvas(1400, 1000);
		Canvas enemies = new Canvas(1400,1000);
		enemyGc = enemies.getGraphicsContext2D();
		gc = canvas.getGraphicsContext2D();
		gc2 = selectionCanvas.getGraphicsContext2D();
		gc.drawImage(new Image("test-easyMapSmallerFixedSpots.png", 1400, 1000, false, false), 0, 0);
		towerMenuLayer = canvas.getGraphicsContext2D();
		
		//towerview
		towerView = null;
		GridPane gp = new GridPane();
		Canvas td = new Canvas(150, 350);
		towerStatView = td.getGraphicsContext2D();
		towerStatView.drawImage(new Image("tower_bg_stats.png"), 0, 0);
		gp.setPickOnBounds(false);;
		ImageView towerStatsBg = new ImageView(new Image("tower_bg_stats.png", 150, 350, false, false));
		//towerStatsBg.setVisible(false);
		Label tName = new Label();
		Label tDmg = new Label();
		Label tSell = new Label();
		Label tCoords = new Label();
		tName.setTextFill(Color.web("#ffffff", 1));
		tDmg.setTextFill(Color.web("#ffffff", 1));
		tSell.setTextFill(Color.web("#ffffff", 1));
		tCoords.setTextFill(Color.web("#ffffff", 1));
		gp.add(tName, 1, 1);
		gp.add(tDmg, 1, 2);
		gp.add(tSell, 1, 3);
		gp.add(tCoords, 1, 5);
		
		gp.setVgap(30.00);
		towerStatsBg.setVisible(false);
		gp.setVisible(false);
		
		tSell.setOnMouseClicked((event) -> {
			System.out.println("SELL");
			if (towerView != null) {
				controller.sellTower(towerView);
				towerStatsBg.setVisible(false);
				gp.setVisible(false);
			}
		});
		
		

		model = new TowersOfBrimstoneModel();
		model.addObserver(this);
		
		//money = model.getGold();
		controller = new TowersOfBrimstoneController(model);
		controller.createMap();
		
		String str = "Gold: " + Integer.toString(model.getGold());
		currency = new Label(str);
		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		//boolean highlight = false;
		selectionCanvas.setOnMouseMoved((event) -> {
			int row = (int) event.getY() / 50;
			int col = (int) event.getX() / 50;
			
			if (togglePlacement == true) {
					
				Tile tile = grid.get(row).get(col);
				
				if (prevCol != col || prevRow != row) {
					if (highlighted == true) {
						//System.out.println("remov");
						highlighted = false;
						gc2.clearRect(50*prevCol, 50*prevRow, 50, 50);
					}
					
					if (tile.getIsPath() == false && highlighted == false) {
						//System.out.println("drawn new sq");
						highlighted = true;
						String imagePath;
						if (tile.getIsPlaceable() && tile.getPlacedTower() == null) {
							imagePath = "green-sq.png";
						} else {
							imagePath = "red-sq.png";
						}
						gc2.drawImage(new Image(imagePath), 50 * col, 50 * row, 50, 50);
						prevCol = col;
						prevRow = row;
					}
				}		
				
			} else if (highlighted == true) {
				//System.out.println("remove prev sq");
				highlighted = false;
				gc2.clearRect(50*prevCol, 50*prevRow, 50, 50);
			}
			
		});
		
		controller.getEnemyPath();
		
		togglePlacement = false;
		//selectedTower = controller.getTowerType(1); // temp

		root.getChildren().add(canvas);
		root.getChildren().add(enemies);
		root.getChildren().add(selectionCanvas);
		base.getChildren().add(root);
		base.getChildren().add(currency);
		
		base.setTopAnchor(currency, 200.00);
		base.setLeftAnchor(currency, 200.00);
		
		// Code for tower statisTAK
		base.getChildren().add(towerStatsBg);
		base.getChildren().add(gp);
		AnchorPane.setLeftAnchor(towerStatsBg, 0.00);
		AnchorPane.setTopAnchor(towerStatsBg, 350.00);
		AnchorPane.setLeftAnchor(gp, 25.00);
		AnchorPane.setTopAnchor(gp, 385.00);
		
		setUpTowerMenu();
		Scene scene = new Scene(base, 1400, 1000);
		
		selectionCanvas.setOnMouseClicked((event) -> {
			int xPos = (int) event.getX();
			int yPos = (int) event.getY();
			int row = yPos / 50;
			int col = xPos / 50;

			System.out.println("ROW " + row + " COL " + col);


			// Used to stop placement on Right Click
			if (event.getButton() == MouseButton.SECONDARY && togglePlacement == true) {
				togglePlacement = false;
				if (highlighted == true) {
					gc2.clearRect(50*prevCol, 50*prevRow, 50, 50);
				}
				System.out.println("Tower Placement disabled!");
			} else

			// Tower Placement logic
			//int temp = 15; // depending on where the store menu starts graphically
			if (togglePlacement == true) {
				Tower tower = controller.getTowerType(selectedTowerType);
				boolean isPlaced = controller.placeTower(row, col, tower);
				if (isPlaced) {
					//money = model.getGold();
					gc2.clearRect(50*col, 50*row, 50, 50);
					gc2.drawImage(new Image("red-sq.png"), 50 * col, 50 * row, 50, 50);
					System.out.println("Tower has been placed!");
				} else {
					System.out.println("Cannot place on this spot or insufficient funds");
				}
			} else {
				// Check tower on this spot
				towerView = controller.checkTower(row, col);
				if (towerView != null) {
					tName.setText(towerView.toString());
					tDmg.setText("DPS: " + towerView.getAttackPower());
					tSell.setText("Sell for " + towerView.getSellPrice() + "?");
					tCoords.setText("Row:" + towerView.getRow() + " Col: " + towerView.getCol());
					towerStatsBg.setVisible(true);
					gp.setVisible(true);
				} else {
					towerStatsBg.setVisible(false);
					gp.setVisible(false);
				}
			}
		});

		Zombie zomb = new Zombie(0,6, controller.getEnemyPath());
		towerMenuLayer.drawImage(new Image("menuTowerEmpty2.png"), 0, 900, 1400, 100);
		

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
					controller.frameUpdate(tick, zomb);			
					lastUpdate = now;
				}				
			}
		}.start();
	}
						
	private void frameUpdateGUI(ArrayList<ArrayList<Tile>> grid, int tick, Zombie zomb) {
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
	}
	
	private void frameUpdateCurrency(int newVal) {
		String str = "Gold: " + newVal;
		currency.setText(str);
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
				selectedTowerType = 1;
				System.out.println("Selected Stone tower");
			} else if (event.getSource().equals(fire)) {
				selectedTowerType = 2;
				System.out.println("Selected Fire tower");
			} else if (event.getSource().equals(ice)) {
				selectedTowerType = 3;
				System.out.println("Selected Ice tower");
			} else if (event.getSource().equals(heavy)) {
				selectedTowerType = 4;
				System.out.println("Selected Heavy tower");
			} else if (event.getSource().equals(lightning)) {
				selectedTowerType = 5;
				System.out.println("Selected Lightning tower");
			} else if (event.getSource().equals(magic)) {
				selectedTowerType = 6;
				System.out.println("Selected Magic tower");
			} else if (event.getSource().equals(slowdown)) {
				System.out.println("Unimplemented Ability 1");
			} else if (event.getSource().equals(damageboost)) {
				System.out.println("Unimplemented Ability 2");
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof FrameMessage) {
			FrameMessage msg = (FrameMessage) arg;
			
			frameUpdateCurrency(msg.getCurrency());
			frameUpdateGUI(msg.getGrid(), msg.getTick(), msg.getZombie());	
		} else if (arg instanceof int[]) {
			int[] coordinates = (int[]) arg;
			//coordinates not used
			towerView = null;
			gc2.clearRect(0, 0, 1400, 1000);
			System.out.println("cleared rect");
			
		}
	}
}