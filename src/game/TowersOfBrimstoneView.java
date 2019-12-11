package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import enemies.Enemy;
import enemies.ImageLoader;
import game.ImageButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import towers.Tower;
import towers.Tower.Projectile;

public class TowersOfBrimstoneView extends Application implements Observer {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 1000;

    private ImageButton stone;
    private ImageButton fire;
    private ImageButton ice;
    private ImageButton heavy;
    private ImageButton lightning;
    private ImageButton magic;
    private ImageButton slowdown;
    private ImageButton damageboost;

    private AnchorPane mainScreen;
    private AnchorPane levelPane = new AnchorPane();
    private Scene mainscreen;
    private Scene levelSelection;
    private Scene game;
    private Stage window;
    private ImageLoader loader;
    private TowersOfBrimstoneModel model;
    private TowersOfBrimstoneController controller;

    private AnchorPane base;
    private boolean togglePlacement;
    private int selectedTowerType;

    private GraphicsContext enemyGc;
    private GraphicsContext baseContext;
    private GraphicsContext selectionContext;
    private GraphicsContext towerContext;

    private boolean isPaused = true;
    private boolean highlighted = false;

    private int forwardCount = 1;
    private int tick;
    private int prevCol = 0;
    private int prevRow = 19;
    private int prevCCol = 0;
    private int prevCRow = 0;
    private int prevCSize = 0;
    private Tower towerView;
    private Label currency;
    private Label tName;
    private Label tDmg;
    private Label tSell;
    private Label tCoords;
    private ImageView towerStatsBg;

    private ImageView healthBar;
    private ImageView goldBar;
    private ImageView barView;
    private ImageView towerMenuL;

    private ImageButton play = new ImageButton("assets/UI/buttons/play.png", 110, 90);
    private ImageButton pause = new ImageButton("assets/UI/buttons/pause.png", 110, 90);
    private ImageButton forward = new ImageButton("assets/UI/buttons/fastforward.png", 110, 90);
    private ImageButton sellButton = new ImageButton("assets/UI/labels/sell.png", 60, 50);
    private ImageButton restart = new ImageButton("assets/UI/buttons/restart.png", 90, 110);
    private ImageButton menu = new ImageButton("assets/UI/buttons/menu.png", 90, 110);

    private volatile Timeline timeline;

    @Override
    public void start(Stage primaryStage) throws Exception {
	window = primaryStage;
	makeMainScreen();
	loader = new ImageLoader();
	model = new TowersOfBrimstoneModel();
	model.addObserver(this);
	controller = new TowersOfBrimstoneController(model);

	currency = new Label();
	currency.setTextFill(Color.web("#ffffff", 1));
	togglePlacement = false;

	// GUI setup components
	base = new AnchorPane();
	base.getStylesheets().add("test.css");
	StackPane root = new StackPane();
	Canvas canvas = new Canvas(WIDTH, HEIGHT);
	Canvas selectionCanvas = new Canvas(WIDTH, HEIGHT);
	Canvas towerCanvas = new Canvas(WIDTH, HEIGHT);
	Canvas enemies = new Canvas(WIDTH, HEIGHT);
	towerContext = towerCanvas.getGraphicsContext2D();
	enemyGc = enemies.getGraphicsContext2D();
	baseContext = canvas.getGraphicsContext2D();
	selectionContext = selectionCanvas.getGraphicsContext2D();

	healthBar = new ImageView(new Image("assets/UI/bars/healthBar.png", 150, 15, false, false));
	goldBar = new ImageView(new Image("assets/UI/bars/goldBar.png", 150, 15, false, false));
	barView = new ImageView(new Image("assets/UI/menus/barMenu.png", 200, 150, false, false));
	towerMenuL = new ImageView(new Image("assets/UI/menus/menuTowerEmpty.png", 1400, 100, false, false));

	// Adding canvases to StackPane
	root.getChildren().add(canvas);
	root.getChildren().add(selectionCanvas);
	root.getChildren().add(towerCanvas);
	root.getChildren().add(enemies);

	canvas.toBack();
	selectionCanvas.toFront();
	base.getChildren().add(root);

	AnchorPane.setLeftAnchor(currency, 59.00);
	AnchorPane.setTopAnchor(currency, 80.00);

	// Generate GUIs
	generateTowerStatsView();
	setUpTowerMenu();

	// BarView
	base.getChildren().add(barView);
	base.getChildren().add(healthBar);
	base.getChildren().add(goldBar);
	base.getChildren().add(currency);
	base.getChildren().add(towerMenuL);

	AnchorPane.setLeftAnchor(goldBar, 59.00);
	AnchorPane.setTopAnchor(goldBar, 60.00);
	AnchorPane.setLeftAnchor(healthBar, 59.00);
	AnchorPane.setTopAnchor(healthBar, 120.00);
	AnchorPane.setLeftAnchor(barView, 25.00);
	AnchorPane.setTopAnchor(barView, 25.00);
	AnchorPane.setTopAnchor(towerMenuL, 900.00);

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

	// Tower Statistic Display
	base.getChildren().add(towerStatsBg);
	sellButton.setVisible(false);
	base.getChildren().add(sellButton);
	base.getChildren().add(tDmg);
	base.getChildren().add(tName);
	base.getChildren().add(tSell);
	base.getChildren().add(tCoords);
	AnchorPane.setRightAnchor(towerStatsBg, 100.00);
	AnchorPane.setTopAnchor(towerStatsBg, -50.00);
	AnchorPane.setRightAnchor(sellButton, 265.00);
	AnchorPane.setTopAnchor(sellButton, 150.50);
	AnchorPane.setTopAnchor(tDmg, 100.00);
	AnchorPane.setRightAnchor(tDmg, 155.00);

	AnchorPane.setTopAnchor(tName, 60.00);
	AnchorPane.setRightAnchor(tName, 250.00);

	AnchorPane.setTopAnchor(tSell, 90.00);
	AnchorPane.setRightAnchor(tSell, 270.00);

	AnchorPane.setTopAnchor(tCoords, 90.00);
	AnchorPane.setRightAnchor(tCoords, 380.00);
	ArrayList<ArrayList<Tile>> grid = model.getGrid();

	// Button to sell selected tower
	sellButton.setOnMouseClicked((event) -> {
	    if (towerView != null) {

		controller.sellTower(towerView);
		hideTowerInfo();

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
			// hover effect
			selectionContext.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
		    }

		    if (tile.getIsPath() == false && highlighted == false) {
			highlighted = true;
			String imagePath;
			if (tile.getIsPlaceable() && tile.getPlacedTower() == null) {
			    imagePath = "assets/UI/towerSelection/green-sq.png";
			} else {
			    imagePath = "assets/UI/towerSelection/red-sq.png";
			}
			selectionContext.drawImage(new Image(imagePath), 50 * col, 50 * row, 50, 50);
			prevCol = col;
			prevRow = row;
		    }
		}

	    } else if (highlighted == true) {
		highlighted = false;
		selectionContext.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
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
		    towerContext.clearRect(50 * prevCol, 50 * prevRow, 50, 50);
		}
		System.out.println("Tower Placement disabled!");
	    } else

	    // Tower Placement logic
	    if (togglePlacement == true) {
		boolean isPlaced = controller.placeTower(row, col, selectedTowerType);
		if (isPlaced) {
		    selectionContext.clearRect(50 * col, 50 * row, 50, 50);
		    selectionContext.drawImage(new Image("assets/UI/towerSelection/red-sq.png"), 50 * col, 50 * row, 50,
			    50);
		    System.out.println("Tower has been placed!");
		    controller.frameUpdate(tick);
		} else {
		    System.out.println("Cannot place on this spot or insufficient funds");
		}
	    } else {
		// Check tower on this spot
		towerView = controller.checkTower(row, col);
		if (towerView != null) {
		    selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		    int radius = towerView.getRange();
		    int size = (radius * 2) + 50;
		    int coordCol = 50 * col - radius;
		    int coordRow = 50 * row - radius;
		    prevCCol = coordCol;
		    prevCRow = coordRow;
		    prevCSize = size;
		    selectionContext.drawImage(
			    new Image("assets/UI/towerSelection/selection-highlight.png", 50, 50, false, false),
			    coordCol, coordRow, size, size);
		    tDmg.getStyleClass().add("shopLabel");
		    tName.getStyleClass().add("shopLabel");
		    tSell.getStyleClass().add("shopLabel");
		    tCoords.getStyleClass().add("shopLabel");
		    tName.setText(towerView.toString());
		    tDmg.setText("DPS: " + towerView.getAttackPower());
		    tSell.setText("Sell for\n" + towerView.getSellPrice() + "?");
		    tCoords.setText("Row - " + towerView.getRow() + "\n Col - " + towerView.getCol());

		    showTowerInfo();
		} else {

		    hideTowerInfo();

		}
	    }
	});

	// Animation Timer - handles ticking of game clock
	timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {

	    controller.frameUpdate(tick);
	    tick++;

	}));

	timeline.setCycleCount(Animation.INDEFINITE);
	play.setOnAction(e -> {
	    isPaused = false;
	    System.out.println("Game is being played!");
	    timeline.play();

	});

	pause.setOnAction(e -> {
	    if (!isPaused) {
		timeline.stop();
		timeline.stop();

		System.out.println("Game is paused!");
		isPaused = true;
	    }

	});

	forward.setOnAction(e -> {
	    forwardCount++;
	    if (forwardCount > 4) {
		forwardCount = 1;

	    }
	    System.out.println("Rate of the game is:" + forwardCount);
	    timeline.setRate(forwardCount);

	});

	menu.setOnAction(event -> {
	    model = new TowersOfBrimstoneModel();
	    model.addObserver(this);
	    healthBar.setVisible(true);
	    controller = new TowersOfBrimstoneController(model);
	    towerContext.clearRect(0, 0, WIDTH, HEIGHT);
	    enemyGc.clearRect(0, 0, WIDTH, HEIGHT);
	    prevCol = 0;
	    prevRow = 19;
	    prevCCol = 0;
	    prevCRow = 0;
	    prevCSize = 0;
	    frameUpdateHealth(model.getHealth());
	    setUpLevelPane();
	    window.setScene(levelSelection);
	});

	restart.setOnAction(event -> {
	    model = new TowersOfBrimstoneModel();
	    model.addObserver(this);
	    healthBar.setVisible(true);
	    controller = new TowersOfBrimstoneController(model);
	    towerContext.clearRect(0, 0, WIDTH, HEIGHT);
	    enemyGc.clearRect(0, 0, WIDTH, HEIGHT);
	    prevCol = 0;
	    prevRow = 19;
	    prevCCol = 0;
	    prevCRow = 0;
	    prevCSize = 0;
	    frameUpdateHealth(model.getHealth());
	    makeMainScreen();
	    window.setScene(mainscreen);
	});

	// Display the scene
	game = new Scene(base, WIDTH, HEIGHT);
	primaryStage.setMaxWidth(WIDTH);
	primaryStage.setMaxHeight(HEIGHT);
	primaryStage.setMinWidth(WIDTH);
	primaryStage.setMinHeight(HEIGHT);
	primaryStage.setScene(mainscreen);
	primaryStage.show();
    }

    private void hideTowerInfo() {
	towerStatsBg.setVisible(false);
	sellButton.setVisible(false);
	tName.setVisible(false);
	tDmg.setVisible(false);
	tSell.setVisible(false);
	tCoords.setVisible(false);
	selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
    }

    private void showTowerInfo() {
	towerStatsBg.setVisible(true);
	sellButton.setVisible(true);
	tName.setVisible(true);
	tDmg.setVisible(true);
	tSell.setVisible(true);
	tCoords.setVisible(true);
    }

    public void generateTowerStatsView() {
	// GUI for displaying tower statistics
	towerView = null;
	towerStatsBg = new ImageView(new Image("assets/UI/menus/shopMenu_1.png", 400, 250, false, false));
	towerStatsBg.setVisible(false);
	tName = new Label();
	tDmg = new Label();
	tSell = new Label();
	tCoords = new Label();
	hideTowerInfo();
    }

    private void setUpTowerMenu() {
	int height = 90;
	int width = 110;
	HBox hBox = new HBox();

	stone = new ImageButton("assets/UI/buttons/stone.png", width, height);
	fire = new ImageButton("assets/UI/buttons/fire.png", width, height);
	ice = new ImageButton("assets/UI/buttons/ice.png", width, height);
	heavy = new ImageButton("assets/UI/buttons/heavy.png", width, height);
	lightning = new ImageButton("assets/UI/buttons/lightning.png", width, height);
	magic = new ImageButton("assets/UI/buttons/magic.png", width, height);
	slowdown = new ImageButton("assets/UI/buttons/slowdown.png", width, height);

	hBox.setAlignment(Pos.CENTER);
	hBox.setSpacing(75);
	hBox.setPadding(new Insets(0, 0, 0, 130));
	hBox.getChildren().add(stone);
	hBox.getChildren().add(fire);
	hBox.getChildren().add(ice);
	hBox.getChildren().add(heavy);
	hBox.getChildren().add(lightning);
	hBox.getChildren().add(magic);
	hBox.getChildren().add(slowdown);

	base.getChildren().add(hBox);

	AnchorPane.setBottomAnchor(hBox, 25.0);

	for (Node btn : hBox.getChildren()) {
	    ((ImageButton) btn).setOnAction(new ButtonListener());
	}
    }

    public void setUpLevelPane() {

	Label l1 = new Label("LEVEL 1");
	l1.getStyleClass().add("levelLabel");
	Label l2 = new Label("LEVEL 2");
	l2.getStyleClass().add("levelLabel");
	Label l3 = new Label("LEVEL 3");
	l3.getStyleClass().add("levelLabel");
	Label l4 = new Label("LEVEL 4");
	l4.getStyleClass().add("levelLabel");
	Label l5 = new Label("LEVEL 5");
	l5.getStyleClass().add("levelLabel");
	Label l6 = new Label("LEVEL 6");
	l6.getStyleClass().add("levelLabel");

	ImageButton level1 = new ImageButton("assets/desert/desertTab.png", 280, 250);
	level1.getStyleClass().add("levelButton");
	ImageButton level2 = new ImageButton("assets/ice/iceTab.png", 280, 250);
	level2.getStyleClass().add("levelButton");
	ImageButton level3 = new ImageButton("assets/volcano/volcanoTab.png", 280, 250);
	level3.getStyleClass().add("levelButton");
	ImageButton level4 = new ImageButton("assets/oasis/oasisTab.png", 280, 250);
	level4.getStyleClass().add("levelButton");
	ImageButton level5 = new ImageButton("assets/forest/forestTab.png", 280, 250);
	level5.getStyleClass().add("levelButton");
	ImageButton level6 = new ImageButton("assets/farm/farmTab.png", 280, 250);
	level6.getStyleClass().add("levelButton");

	ImageView imageView = new ImageView(
		new Image("assets/UI/menus/levelSelectionMenu-01.png", WIDTH, HEIGHT, false, false));

	level1.setOnAction(event -> {
	    controller.createMap(1);
	    baseContext.drawImage(new Image("assets/desert/desertMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});
	level2.setOnAction(event ->

	{
	    controller.createMap(2);
	    baseContext.drawImage(new Image("assets/ice/iceMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});

	level3.setOnAction(event -> {
	    controller.createMap(3);
	    baseContext.drawImage(new Image("assets/volcano/volcanoMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});

	level4.setOnAction(event -> {
	    controller.createMap(4);
	    baseContext.drawImage(new Image("assets/oasis/oasisMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});

	level5.setOnAction(event -> {
	    controller.createMap(5);
	    baseContext.drawImage(new Image("assets/forest/forestMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});

	level6.setOnAction(event -> {
	    controller.createMap(6);
	    baseContext.drawImage(new Image("assets/farm/farmMap.png", WIDTH, HEIGHT, false, false), 0, 0);
	    setUpTowerMenu();
	    window.setScene(game);
	});

	HBox hBox1 = new HBox();
	HBox hBoxLabel1 = new HBox();
	HBox hBox2 = new HBox();
	HBox hBoxLabel2 = new HBox();

	hBox1.setPadding(new Insets(0, 0, 0, 120));
	hBox1.setSpacing(115);
	hBoxLabel1.setPadding(new Insets(0, 0, 0, 220));
	hBoxLabel1.setSpacing(300);

	hBox1.getChildren().add(level1);
	hBox1.getChildren().add(level2);
	hBox1.getChildren().add(level3);
	hBoxLabel1.getChildren().add(l1);
	hBoxLabel1.getChildren().add(l2);
	hBoxLabel1.getChildren().add(l3);
	hBoxLabel1.setAlignment(Pos.CENTER);

	hBox2.setPadding(new Insets(0, 0, 0, 120));
	hBox2.setSpacing(115);
	hBoxLabel2.setPadding(new Insets(0, 0, 0, 220));
	hBoxLabel2.setSpacing(300);

	hBox2.getChildren().add(level4);
	hBox2.getChildren().add(level5);
	hBox2.getChildren().add(level6);
	hBoxLabel2.getChildren().add(l4);
	hBoxLabel2.getChildren().add(l5);
	hBoxLabel2.getChildren().add(l6);
	hBoxLabel2.setAlignment(Pos.CENTER);

	levelPane.getStylesheets().add("test.css");
	levelPane.getChildren().add(imageView);
	levelPane.getChildren().add(hBoxLabel1);
	levelPane.getChildren().add(hBoxLabel2);
	levelPane.getChildren().add(hBox1);
	levelPane.getChildren().add(hBox2);

	AnchorPane.setTopAnchor(hBox1, 140.00);
	AnchorPane.setTopAnchor(hBoxLabel1, 350.00);
	AnchorPane.setTopAnchor(hBox2, 550.00);
	AnchorPane.setTopAnchor(hBoxLabel2, 780.00);
    }

    private void updateProjectiles(ArrayList<Tower> towers, GraphicsContext enemyBackground) {
	for (Tower tower : towers) {
	    for (Projectile projectile : tower.getProjectiles()) {
		Image image = loader.getImage(projectile.getImage());
		int xpos = (int) projectile.getPos().getX();
		int ypos = (int) projectile.getPos().getY();
		enemyBackground.drawImage(image, xpos, ypos);
	    }
	}
    }

    public void makeMainScreen() {
	mainScreen = new AnchorPane();

	ImageView gameName = new ImageView("assets/UI/labels/gameTitle.png");
	gameName.setFitWidth(1000);
	gameName.setFitHeight(550);

	ImageButton newGame = new ImageButton("assets/UI/labels/playNow.png", 900, 500);
	Image image = new Image("assets/UI/bg.png", WIDTH, HEIGHT, false, false);
	BackgroundImage background = new BackgroundImage(image, null, null, null, null);
	Background background2 = new Background(background);

	mainScreen.setMaxWidth(WIDTH);
	mainScreen.setMaxHeight(HEIGHT);
	mainScreen.setBackground(background2);
	mainScreen.getChildren().add(gameName);
	mainScreen.getChildren().add(newGame);
	AnchorPane.setTopAnchor(gameName, 0.00);
	AnchorPane.setLeftAnchor(gameName, 200.00);
	AnchorPane.setTopAnchor(newGame, 320.00);
	AnchorPane.setLeftAnchor(newGame, 350.00);

	mainscreen = new Scene(mainScreen, WIDTH, HEIGHT);
	newGame.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    // setting a mouseEvent on the column in the grid
	    @Override
	    public void handle(MouseEvent event) {
		setUpLevelPane();
		if (levelSelection == null) {
		    levelSelection = new Scene(levelPane);
		} else if (levelSelection.getRoot() == null) {
		    levelSelection = new Scene(levelPane);
		}
		window.setScene(levelSelection);
	    }
	});

    }

    private class ButtonListener implements EventHandler<ActionEvent> {
	/**
	 * Handle logic when button is clicked
	 *
	 * @param event the ActionEvent
	 */

	public void handle(ActionEvent event) {
	    togglePlacement = true;
	    System.out.println("Tower Placement enabled: " + togglePlacement);

	    if (event.getSource().equals(stone)) {
		selectedTowerType = 1;
		System.out.println("Selected Stone tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(fire)) {
		selectedTowerType = 2;
		System.out.println("Selected Fire tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(ice)) {
		selectedTowerType = 3;
		System.out.println("Selected Ice tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(heavy)) {
		selectedTowerType = 4;
		System.out.println("Selected Heavy tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(lightning)) {
		selectedTowerType = 5;
		System.out.println("Selected Lightning tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(magic)) {
		selectedTowerType = 6;
		System.out.println("Selected Magic tower");
		selectionContext.clearRect(prevCCol, prevCRow, prevCSize, prevCSize);
		hideTowerInfo();
	    } else if (event.getSource().equals(slowdown)) {
		double temp = timeline.getRate();
		new Thread(new Runnable() {
		    @Override
		    public void run() {
			timeline.setRate(timeline.getRate() / 2);
			try {
			    Thread.sleep(5000);
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
			timeline.setRate(temp);
		    }
		}).start();
		System.out.println("Slowdown Enemies for 5 seconds");
	    }

	}
    }

    // Normal GUI frame updates go here
    private void frameUpdateGUI(ArrayList<ArrayList<Tile>> grid, int tick, ArrayList<Enemy> enemies,
	    TowersOfBrimstoneModel model) {
	for (int row = 0; row < grid.size(); row++) {
	    for (int col = 0; col < grid.get(0).size(); col++) {
		Tile tile = grid.get(row).get(col);
		if (tile.getPlacedTower() != null) {
		    Tower tower = tile.getPlacedTower();
		    towerContext.clearRect(50 * col - 4, 50 * row - 15, 65, 65);
		    towerContext.drawImage(loader.getImage(tower.getImage()), 50 * col - 4, 50 * row - 15);
		}
	    }
	    updateEnemies(enemies, enemyGc);
	    updateProjectiles(model.getTowers(), enemyGc);
	}
    }

    private void frameUpdateCurrency(int newVal) {
	String str = "Gold: " + newVal;
	currency.setText(str);

	double percentage = ((double) newVal) / 2000.00;
	double width = percentage * 150.00;
	goldBar.setViewport(new Rectangle2D(0, 0, width, HEIGHT));
    }

    private void frameUpdateHealth(int newVal) {

	if (newVal > 0) {
	    double percentage = ((double) newVal) / 300.0;
	    double width = percentage * 150.00;
	    healthBar.setViewport(new Rectangle2D(0, 0, width, HEIGHT));
	} else {
	    newVal = 0;

	}
    }

    public void setupWinMenu() {
	AnchorPane winMenu = new AnchorPane();
	Image image = new Image("assets/UI/bg.png", 1400, 1000, false, false);

	BackgroundImage background = new BackgroundImage(image, null, null, null, null);

	Background background2 = new Background(background);
	timeline.stop();

	winMenu = new AnchorPane();

	ImageView imageView = new ImageView(new Image("assets/UI/menus/levelWin.png", 650, 800, false, false));
	winMenu.getChildren().add(imageView);
	winMenu.getChildren().add(restart);
	winMenu.getChildren().add(menu);
	winMenu.setBackground(background2);
	AnchorPane.setTopAnchor(imageView, 90.00);
	AnchorPane.setLeftAnchor(imageView, 400.00);
	AnchorPane.setTopAnchor(restart, 800.00);
	AnchorPane.setRightAnchor(restart, 520.00);
	AnchorPane.setTopAnchor(menu, 800.00);
	AnchorPane.setLeftAnchor(menu, 570.00);

	Scene win = new Scene(winMenu, WIDTH, HEIGHT);
	window.setScene(win);
    }

    public void setupLoseMenu() {
	AnchorPane looseMenu = new AnchorPane();
	Image image = new Image("assets/UI/bg.png", WIDTH, HEIGHT, false, false);

	BackgroundImage background = new BackgroundImage(image, null, null, null, null);

	Background background2 = new Background(background);
	timeline.stop();

	looseMenu = new AnchorPane();
	ImageView imageView = new ImageView(new Image("assets/UI/menus/levelFail.png", 650, 800, false, false));
	looseMenu.getChildren().add(imageView);
	looseMenu.getChildren().add(restart);
	looseMenu.getChildren().add(menu);
	looseMenu.setBackground(background2);
	AnchorPane.setTopAnchor(imageView, 90.00);
	AnchorPane.setLeftAnchor(imageView, 400.00);
	AnchorPane.setTopAnchor(restart, 800.00);
	AnchorPane.setRightAnchor(restart, 520.00);
	AnchorPane.setTopAnchor(menu, 800.00);
	AnchorPane.setLeftAnchor(menu, 570.00);

	Scene win = new Scene(looseMenu, WIDTH, HEIGHT);
	window.setScene(win);

    }

    /**
     * Update.
     *
     * @param o   the o
     * @param arg the arg
     */
    @Override
    public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	if (arg instanceof FrameMessage) {
	    FrameMessage msg = (FrameMessage) arg;
	    frameUpdateCurrency(msg.getCurrency());
	    frameUpdateHealth(msg.getHealth());
	    frameUpdateGUI(msg.getGrid(), msg.getTick(), msg.getEnemies(), (TowersOfBrimstoneModel) o);
	} else if (arg instanceof int[]) {
	    int[] arr = (int[]) arg;
	    towerView = null;
	    towerContext.clearRect(50 * arr[1] - 4, 50 * arr[0] - 15, 65, 65);

	} else if ((Boolean) arg) {
	    setupWinMenu();
	} else if (!(Boolean) arg) {
	    frameUpdateHealth(0);
	    setupLoseMenu();
	}
    }

    private void updateEnemies(ArrayList<Enemy> enemies, GraphicsContext d) {
	if (!isPaused) {
	    d.clearRect(0, 0, WIDTH, HEIGHT);
	    for (Enemy enemy : enemies) {
		d.drawImage(loader.getImage(enemy.getImage()), enemy.getPos().getX() - 25, enemy.getPos().getY() - 25);
	    }
	}
    }
}