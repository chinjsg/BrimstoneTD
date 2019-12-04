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
import javafx.geometry.Rectangle2D;
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
    private AnchorPane base;
    private boolean togglePlacement;
    private int selectedTowerType;

    private GraphicsContext enemyGc;
    private GraphicsContext gc;
    private GraphicsContext gc2;
    private GraphicsContext towerMenuLayer;
    private Label currency;
    private int tick;
    private boolean highlighted = false;
    private int prevCol = 0;
    private int prevRow = 19;
    private Tower towerView;
    private Label tName; // temp till GUI available
    private Label tDmg; // temp till GUI available
    private Label tSell; // temp till GUI available //clickable label to sell tower
    private Label tCoords; // temp till GUI available
    private ImageView towerStatsBg; // temp till GUI available
    private GridPane towerStatsgp; // temp till GUI available

    private boolean isPaused = false;
    ImageView healthBar;
    ImageView goldBar;
    ImageView barView;
    private ImageButton play = new ImageButton("play.png", 110, 90);
    private ImageButton pause = new ImageButton("pause.png", 110, 90);
    private ImageButton forward = new ImageButton("fastforward.png", 110, 90);
    int forwardCount = 1;
    int frames = 60;

    @Override
    public void start(Stage primaryStage) throws Exception {
	model = new TowersOfBrimstoneModel();
	model.addObserver(this);
	controller = new TowersOfBrimstoneController(model);
	controller.createMap();

	currency = new Label();
	currency.setTextFill(Color.web("#ffffff", 1));
	togglePlacement = false;

	// These GUI setup components below should be placed into a function in the
	// future
	base = new AnchorPane();
	time = 1;
	StackPane root = new StackPane();
	Canvas canvas = new Canvas(1400, 1000);
	Canvas selectionCanvas = new Canvas(1400, 1000);
	Canvas enemies = new Canvas(1400, 1000);
	enemyGc = enemies.getGraphicsContext2D();
	gc = canvas.getGraphicsContext2D();
	gc2 = selectionCanvas.getGraphicsContext2D();
	gc.drawImage(new Image("mediumMap.png", 1400, 1000, false, false), 0, 0);
	healthBar = new ImageView(new Image("healthBar.png", 150, 15, false, false));
	goldBar = new ImageView(new Image("goldBar.png", 150, 15, false, false));
	barView = new ImageView(new Image("barMenu.png", 200, 150, false, false));
	towerMenuLayer = canvas.getGraphicsContext2D();

	root.getChildren().add(canvas);
	root.getChildren().add(enemies);
	root.getChildren().add(selectionCanvas);
	base.getChildren().add(root);

	base.setLeftAnchor(currency, 59.00);
	base.setTopAnchor(currency, 80.00);

	// Generate GUIs
	generateTowerStatsView(); // temp for display of Tower stats onclick
	setUpTowerMenu();
	towerMenuLayer.drawImage(new Image("menuTowerEmpty2.png"), 0, 900, 1400, 100);

	// BarView
	base.getChildren().add(barView);
	base.getChildren().add(healthBar);
	base.getChildren().add(goldBar);
	base.getChildren().add(currency); // need actual value display
	AnchorPane.setLeftAnchor(goldBar, 59.00);
	AnchorPane.setTopAnchor(goldBar, 60.00);
	AnchorPane.setLeftAnchor(healthBar, 59.00);
	AnchorPane.setTopAnchor(healthBar, 120.00);
	AnchorPane.setLeftAnchor(barView, 25.00);
	AnchorPane.setTopAnchor(barView, 25.00);

	// Game buttons
	base.getChildren().add(play);
	base.getChildren().add(pause);
	base.getChildren().add(forward);
	AnchorPane.setRightAnchor(play, 29.00);
	AnchorPane.setBottomAnchor(play, 450.00);

	AnchorPane.setRightAnchor(pause, 29.00);
	AnchorPane.setBottomAnchor(pause, 350.00);

	AnchorPane.setRightAnchor(forward, 29.00);
	AnchorPane.setBottomAnchor(forward, 550.00);

	// TEMP Code for Tower Statistic Display until GUI available - will be removed
	base.getChildren().add(towerStatsBg); // background
	base.getChildren().add(towerStatsgp); // label display
	AnchorPane.setLeftAnchor(towerStatsBg, 0.00);
	AnchorPane.setTopAnchor(towerStatsBg, 350.00);
	AnchorPane.setLeftAnchor(towerStatsgp, 25.00);
	AnchorPane.setTopAnchor(towerStatsgp, 385.00);

	ArrayList<ArrayList<Tile>> grid = model.getGrid();
	controller.getEnemyPath();
	Zombie zomb = new Zombie(0, 6, controller.getEnemyPath());

	// Temp Label to sell Selected towers
	tSell.setOnMouseClicked((event) -> {
	    if (towerView != null) {
		controller.sellTower(towerView);
		towerStatsBg.setVisible(false);
		towerStatsgp.setVisible(false);
	    }
	});

	// Tower Placement GUI feedback
	selectionCanvas.setOnMouseMoved((event) -> {
	    int row = (int) event.getY() / 50;
	    int col = (int) event.getX() / 50;

	    if (togglePlacement == true) {
		Tile tile = grid.get(row).get(col);

		if (prevCol != col || prevRow != row) {
		    if (highlighted == true) {
			highlighted = false;
			gc2.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
		    }

		    if (tile.getIsPath() == false && highlighted == false) {
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
		highlighted = false;
		gc2.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
	    }

	});

	// Main canvas for Tower Placement
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
		    gc2.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
		}
		System.out.println("Tower Placement disabled!");
	    } else

	    // Tower Placement logic
	    // int temp = 15;
	    if (togglePlacement == true) {
		Tower tower = controller.getTowerType(selectedTowerType);
		boolean isPlaced = controller.placeTower(row, col, tower);
		if (isPlaced) {
		    gc2.clearRect(50 * col, 50 * row, 50, 50);
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
		    towerStatsgp.setVisible(true);
		} else {
		    towerStatsBg.setVisible(false);
		    towerStatsgp.setVisible(false);
		}
	    }
	});

	// Animation Timer - handles ticking of game clock
	new AnimationTimer() {
	    long lastUpdate = 0;
	    int tick = 0;
	   
	    

	    @Override
	    public void handle(long now) {
		play.setOnAction(event->{
		    this.start();
		});
		
		pause.setOnAction(event->{
		    this.stop();
		});
		
		forward.setOnAction(event->{
		    forwardCount++;
		    if(forwardCount > 4) {
			forwardCount = 1;
			
		    }
		    System.out.println(forwardCount);
		    frames = 60 * forwardCount;
		});
		// TODO Auto-generated method stub
		long timeSec = (now - lastUpdate) / (1000000000 / frames); // 60 Frames every 1 sec.
		if (timeSec >= 1) {
		    controller.frameUpdate(tick, zomb);
		    lastUpdate = now;
		}
	    }
	}.start();

	// Display the scene
	Scene scene = new Scene(base, 1400, 1000);
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    private void updateEnemy(Enemy enemy, GraphicsContext d) {
	d.clearRect(0, 0, WIDTH, HEIGHT);
	enemy.move(enemy.getSpeed() * enemy.getDirection().getX(), enemy.getSpeed() * enemy.getDirection().getY());
	d.drawImage(enemy.getImage(), enemy.getPos().getX() - 25, enemy.getPos().getY() - 25);

    }

    public void generateTowerStatsView() {
	// Temporary GUI for displaying tower statistics
	towerView = null;
	towerStatsgp = new GridPane();
	towerStatsBg = new ImageView(new Image("tower_bg_stats.png", 150, 350, false, false));
	towerStatsBg.setVisible(false);
	tName = new Label();
	tDmg = new Label();
	tSell = new Label();
	tCoords = new Label();
	tName.setTextFill(Color.web("#ffffff", 1));
	tDmg.setTextFill(Color.web("#ffffff", 1));
	tSell.setTextFill(Color.web("#ffffff", 1));
	tCoords.setTextFill(Color.web("#ffffff", 1));
	towerStatsgp.add(tName, 1, 1);
	towerStatsgp.add(tDmg, 1, 2);
	towerStatsgp.add(tSell, 1, 3);
	towerStatsgp.add(tCoords, 1, 5);

	towerStatsgp.setVgap(30.00);
	towerStatsBg.setVisible(false);
	towerStatsgp.setVisible(false);
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
		frames = 30;
		System.out.println("Unimplemented Ability 1");
	    } else if (event.getSource().equals(damageboost)) {
		System.out.println("Unimplemented Ability 2");
	    }
	}
    }

    // Normal GUI frame updates go here
    private void frameUpdateGUI(ArrayList<ArrayList<Tile>> grid, int tick, Zombie zomb) {
	for (int row = 0; row < grid.size(); row++) {
	    for (int col = 0; col < grid.get(0).size(); col++) {
		Tile tile = grid.get(row).get(col);
		if (tile.getPlacedTower() != null) {
		    Tower tower = tile.getPlacedTower();
		    gc2.drawImage(tower.getImage(), 50 * col - 4, 50 * row - 15, 65, 65);
		}
	    }
	    if (tick % 20 == 0) {
		updateEnemy(zomb, enemyGc);
	    }
	    tick++;
	}
    }

    private void frameUpdateCurrency(int newVal) {
	String str = "Gold: " + newVal;
	currency.setText(str);

	// double percentage = ((double)money) / 2000.00;
	double percentage = ((double) newVal) / 2000.00;
	double width = percentage * 150.00;
	goldBar.setViewport(new Rectangle2D(0, 0, width, HEIGHT));
    }

    @Override
    public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	if (arg instanceof FrameMessage) {
	    // if you create a method that is meant to be updated by ticking, name it in the
	    // form: "frameDoSomething() {}"
	    FrameMessage msg = (FrameMessage) arg;
	    // TODO: add code for animating healthbar
	    frameUpdateCurrency(msg.getCurrency());
	    frameUpdateGUI(msg.getGrid(), msg.getTick(), msg.getZombie());
	} else if (arg instanceof int[]) {
	    // int[] coordinates = (int[]) arg;
	    // coordinates not used
	    // Removes tower from GUI after selling
	    towerView = null;
	    gc2.clearRect(0, 0, 1400, 1000);

	}
    }
}