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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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

    ImageButton play = new ImageButton("play.png", 110, 90);
    ImageButton pause = new ImageButton("pause.png", 110, 90);
    ImageButton forward = new ImageButton("fastforward.png", 110, 90);

    public static void main(String[] args) {
	launch(args);
    }

    public void start(Stage primaryStage) {
	StackPane root = new StackPane();

	AnchorPane menuBars = new AnchorPane();
	ImageView imageView = new ImageView(new Image("barMenu.png", 200, 150, false, false));
	ImageView healthBar = new ImageView(new Image("healthBar.png", 150, 15, false, false));
	healthBar.setOnMouseClicked(EventHandler -> {
	    width -= 5;

	    healthBar.setViewport(new Rectangle2D(0, 0, width, HEIGHT));

	});
	ImageView goldBar = new ImageView(new Image("goldBar.png", 150, 15, false, false));
	primaryStage.setTitle("The Horse in Motion");

	menuBars.getChildren().add(imageView);
	menuBars.getChildren().add(healthBar);
	menuBars.getChildren().add(goldBar);

	menuBars.getChildren().add(play);
	menuBars.getChildren().add(pause);
	menuBars.getChildren().add(forward);

	AnchorPane.setLeftAnchor(goldBar, 59.00);
	AnchorPane.setTopAnchor(goldBar, 60.00);
	AnchorPane.setLeftAnchor(healthBar, 59.00);
	AnchorPane.setTopAnchor(healthBar, 120.00);
	AnchorPane.setLeftAnchor(imageView, 25.00);
	AnchorPane.setTopAnchor(imageView, 25.00);

	AnchorPane.setRightAnchor(play, 50.00);
	AnchorPane.setBottomAnchor(play, 200.00);

	AnchorPane.setRightAnchor(pause, 50.00);
	AnchorPane.setBottomAnchor(pause, 100.00);

	AnchorPane.setRightAnchor(forward, 50.00);
	AnchorPane.setBottomAnchor(forward, 300.00);

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
	    play.setOnAction(event -> {
		isPaused = false;
		this.start();
	    });

	    pause.setOnAction(event -> {
		this.stop();
		isPaused = true;
	    });

	    forward.setOnAction(event -> {
		forwardCount++;
		if (forwardCount > 4) {
		    forwardCount = 1;

		}
		System.out.println(forwardCount);
		frames = 60 * forwardCount;
	    });
	    // TODO Auto-generated method stub
	    long timeSec = (now - lastUpdate) / (1000000000 / frames); // 60 Frames every 1 sec.
	    if (!isPaused) {

		lastUpdate = now;
	    }
	}

    }

}
