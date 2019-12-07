package experimenting;

import java.io.InputStream;
import java.util.ArrayList;

import enemies.Enemy;
import enemies.Zombie;
import game.Tile;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {

    private static final int COLUMNS = 5;
    private static final int COUNT = 20;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;
    private static int width = 150;
    private static final int HEIGHT = 15;
    private boolean isPaused = true;
    public BorderPane mainScreen;
    public BorderPane newGameScreen;
    public BorderPane Level1;

    public Scene scene;
    AnchorPane levelPane = new AnchorPane();

    private Text tName = new Text("Defence Tower"); // temp till GUI available

    private Text tDmg = new Text("DPS: 50");; // temp till GUI available
    private volatile ArrayList<Enemy> enemiesList = new ArrayList<>();
    private Text tSell = new Text("Sell for: \n 220");; // temp till GUI available //clickable label to sell tower
    private Text tCoords = new Text("Row - 0,\nCol - 0");; // temp till GUI available
    ImageButton sell = new ImageButton("sell.png", 110, 90);
    ImageButton pause = new ImageButton("pause.png", 110, 90);
    ImageButton forward = new ImageButton("fastforward.png", 110, 90);

    public static void main(String[] args) {
	launch(args);
    }

    private ArrayList<ArrayList<Tile>> createBlankMap() {
	ArrayList<ArrayList<Tile>> grid = new ArrayList<ArrayList<Tile>>();
	for (int row = 0; row < 20; row++) {
	    ArrayList<Tile> rows = new ArrayList<>();
	    for (int col = 0; col < 28; col++) {
		rows.add(new Tile(row, col));
	    }
	    grid.add(row, rows);
	}
	return grid;
    }

    public void start(Stage primaryStage) {
	StackPane root = new StackPane();
	root.getStylesheets().add("test.css");
	tDmg.getStyleClass().add("shopLabel");
	tName.getStyleClass().add("shopLabel");
	tSell.getStyleClass().add("shopLabel");
	tCoords.getStyleClass().add("shopLabel");
	AnchorPane menuBars = new AnchorPane();
	ImageView imageView = new ImageView(new Image("levelSelectionMenu.png", 1400, 1000, false, false));
	ImageButton sellButton = new ImageButton("sell.png", 60, 50);
	sellButton.setOnAction(event -> {
	    System.out.print("lalalallala");
	});

//	ImageView level1 = new ImageView(new Image("desertTab.png", 300, 300, false, false));
//	ImageView level2 = new ImageView(new Image("iceTab.png", 300, 300, false, false));
//	ImageView level3 = new ImageView(new Image("volcanoTab.png", 300, 300, false, false));
//	ImageView level4 = new ImageView(new Image("oasis.png", 300, 300, false, false));
//	ImageView level5 = new ImageView(new Image("acidForest.png", 300, 300, false, false));
//	ImageView level6 = new ImageView(new Image("farm.png", 300, 300, false, false));
	primaryStage.setTitle("The Horse in Motion");
	KeyFrame tLine = new KeyFrame(Duration.millis(2000), evt -> {
	    Zombie tempEnemy = new Zombie(0, 6, new ArrayList<Tile>());
	    enemiesList.add(tempEnemy);
	    System.out.println(enemiesList.size());
	});

	// Animation Timer - handles ticking of game clock
//	

	menuBars.getChildren().add(imageView);
//	menuBars.getChildren().add(sellButton);
//	menuBars.getChildren().add(tDmg);
//	menuBars.getChildren().add(tName);
//	menuBars.getChildren().add(tSell);
//	menuBars.getChildren().add(tCoords);
//	menuBars.getChildren().add(healthBar);
//	menuBars.getChildren().add(goldBar);
//	AnchorPane.setRightAnchor(imageView, 100.00);
	AnchorPane.setRightAnchor(sellButton, 265.00);
	AnchorPane.setTopAnchor(sellButton, 192.50);
	AnchorPane.setTopAnchor(tDmg, 160.50);
	AnchorPane.setRightAnchor(tDmg, 155.00);

	AnchorPane.setTopAnchor(tName, 110.00);
	AnchorPane.setRightAnchor(tName, 240.00);

	AnchorPane.setTopAnchor(tSell, 140.50);
	AnchorPane.setRightAnchor(tSell, 255.00);

	AnchorPane.setTopAnchor(tCoords, 140.50);
	AnchorPane.setRightAnchor(tCoords, 380.00);

//	menuBars.getChildren().add(sell);
//	menuBars.getChildren().add(pause)
//	menuBars.getChildren().add(forward);
//
//	AnchorPane.setLeftAnchor(goldBar, 59.00);
//	AnchorPane.setTopAnchor(goldBar, 60.00);
//	AnchorPane.setLeftAnchor(healthBar, 59.00);
//	AnchorPane.setTopAnchor(healthBar, 120.00);
//	AnchorPane.setLeftAnchor(imageView, 25.00);
//	AnchorPane.setTopAnchor(imageView, 25.00);

//	AnchorPane.setRightAnchor(sell, 50.00);
//	AnchorPane.setBottomAnchor(sell, 200.00);
//
//	AnchorPane.setRightAnchor(pause, 50.00);
//	AnchorPane.setBottomAnchor(pause, 100.00);
//
//	AnchorPane.setRightAnchor(forward, 50.00);
//	AnchorPane.setBottomAnchor(forward, 300.00);

	setUpLevelPane();
	
	root.getChildren().add(levelPane);
//	AnimationTimer clock = new Clock();
//	clock.start();

//        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

//        final Animation animation = new SpriteAnimation(
//                imageView,
//                Duration.millis(2000),
//                COUNT, COLUMNS,
//                OFFSET_X, OFFSET_Y,
//                WIDTH, HEIGHT
//        );
//        animation.setCycleCount(Animation.INDEFINITE);
//        animation.play();

//        ColorHelper cHelper = new ColorHelper();
//        cHelper.makeMainScreen();

//        cHelper.mainScreen.setRight(imageView);
	scene = new Scene(root, 1400, 1000);

	primaryStage.setScene(scene);
	primaryStage.show();
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
	
	ImageButton level1 = new ImageButton("desertTab.png", 250, 250);
	level1.getStyleClass().add("levelButton");
	ImageButton level2 = new ImageButton("iceTab.png", 250, 250);
	level2.getStyleClass().add("levelButton");
	ImageButton level3 = new ImageButton("volcanoTab.png", 250, 250);
	level3.getStyleClass().add("levelButton");
	ImageButton level4 = new ImageButton("oasis.png", 250, 250);
	level4.getStyleClass().add("levelButton");
	ImageButton level5 = new ImageButton("acidForest.png", 250, 250);
	level5.getStyleClass().add("levelButton");
	ImageButton level6 = new ImageButton("farm.png", 250, 250);
	level6.getStyleClass().add("levelButton");
	ImageView imageView = new ImageView(new Image("levelSelectionMenu-01.png", 1400, 1000, false, false));
	
	HBox hBox1 = new HBox();
	HBox hBoxLabel1 = new HBox();
	HBox hBox2 = new HBox();
	HBox hBoxLabel2 = new HBox();
	
	hBox1.setPadding(new Insets(0,0,0,190));
	hBox1.setSpacing(115);
	hBoxLabel1.setPadding(new Insets(0,0,0,270));
	
	hBoxLabel1.setSpacing(270);
	hBox1.getChildren().add(level1);
	hBox1.getChildren().add(level2);
	hBox1.getChildren().add(level3);
	hBoxLabel1.getChildren().add(l1);
	hBoxLabel1.getChildren().add(l2);
	hBoxLabel1.getChildren().add(l3);
	hBoxLabel1.setAlignment(Pos.CENTER);
	
	hBox2.setPadding(new Insets(0,0,0,190));
	hBox2.setSpacing(115);
	hBoxLabel2.setPadding(new Insets(0,0,0,270));
//	hBoxLabel2.setAlignment(Pos.CENTER);
	hBoxLabel2.setSpacing(270);
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
	AnchorPane.setTopAnchor(hBoxLabel1, 430.00);
	AnchorPane.setTopAnchor(hBox2, 550.00);
	AnchorPane.setTopAnchor(hBoxLabel2, 830.00);	
	
    }

    private class Clock extends AnimationTimer {
	long lastUpdate = 0;
	int tick = 0;
	int forwardCount = 1;
	int frames = 60;

	@Override
	public void handle(long now) {
	    sell.setOnAction(event -> {
		isPaused = false;
		this.start();
	    });

	    if (!isPaused) {

		lastUpdate = now;
	    }
	}

    }
    
   
    
   
    

}
