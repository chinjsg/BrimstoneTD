package experimenting;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {

    private static final Image IMAGE = new Image("assets/ice/enemies/1/ice1Attack.png");

    private static final int COLUMNS  =   5;
    private static final int COUNT    =  20;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 337;
    private static final int HEIGHT   = 294;

    public Scene scene;
    
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("The Horse in Motion");

        final ImageView imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(2000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        ColorHelper cHelper = new ColorHelper();
        cHelper.makeMainScreen();
        Parent root;
//        cHelper.mainScreen.setRight(imageView);
	scene = new Scene(cHelper.mainScreen,1400,1000);
	
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}