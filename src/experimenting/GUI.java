package experimenting;

import java.io.InputStream;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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

    public Scene scene;

    private Text tName = new Text("Defence Tower"); // temp till GUI available
    
    private Text tDmg = new Text("DPS: 50"); ; // temp till GUI available
    
    private Text tSell = new Text("Sell for: \n 220"); ; // temp till GUI available //clickable label to sell tower
    private Text tCoords = new Text("Row - 0,\nCol - 0"); ; // temp till GUI available
    ImageButton sell = new ImageButton("sell.png", 110, 90);
    ImageButton pause = new ImageButton("pause.png", 110, 90);
    ImageButton forward = new ImageButton("fastforward.png", 110, 90);

    public static void main(String[] args) {
	launch(args);
    }

    public void start(Stage primaryStage) {
	StackPane root = new StackPane();
	root.getStylesheets().add("test.css");
	tDmg.getStyleClass().add("shopLabel");
	tName.getStyleClass().add("shopLabel");
	tSell.getStyleClass().add("shopLabel");
	tCoords.getStyleClass().add("shopLabel");
	AnchorPane menuBars = new AnchorPane();
	ImageView imageView = new ImageView(new Image("shopMenuBlank.png", 400, 250, false, false));
	ImageButton sellButton = new ImageButton("sell.png", 60, 50);
	sellButton.setOnAction(event->{
	    System.out.print("lalalallala");
	});
	
	ImageView goldBar = new ImageView(new Image("goldBar.png", 150, 15, false, false));
	primaryStage.setTitle("The Horse in Motion");

	menuBars.getChildren().add(imageView);
	menuBars.getChildren().add(sellButton);
	menuBars.getChildren().add(tDmg);
	menuBars.getChildren().add(tName);
	menuBars.getChildren().add(tSell);
	menuBars.getChildren().add(tCoords);
//	menuBars.getChildren().add(healthBar);
//	menuBars.getChildren().add(goldBar);
	AnchorPane.setRightAnchor(imageView,100.00);
	AnchorPane.setRightAnchor(sellButton,265.00);
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

	root.getChildren().add(menuBars);
	AnimationTimer clock = new Clock();
	clock.start();

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
