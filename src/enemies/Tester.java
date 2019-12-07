package enemies;
//import org.junit.Test;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.util.Duration;
//
//public class Tester {
//	
//	@Test
//	public void test1() {
//		Image image   = new Image("volacano1Attack.png");
//		ImageView iv1 = new ImageView(image);
//		
//		Duration ddDuration = new Duration(3000);
//		Animator animator  = new Animator(iv1, ddDuration, 10, 2, 0, 0, 411, 360);
//	}
//
//}

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import game.Tile;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Tester extends Application {

	private static Image IMAGE;
	 
	private static int COLUMNS;
    private static int COUNT;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;
    private static int WIDTH;
    private static int HEIGHT;
    
    private ArrayList<Tile> enemyPath; 
    
    TimeUnit time = TimeUnit.SECONDS; 
 
    public static void main(String[] args) {
        launch(args);
    }
 
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The Horse in Motion");
        
        //TowersOfBrimstoneController df = new TowersOfBrimstoneController(null);
        //enemyPath = df.getEnemyPath();
        
        DesertEnimies desert = new DesertEnimies(0,1,10,10,10,enemyPath,4);  
        IMAGE = desert.getImageAttack();
       
        COLUMNS = desert.columns();
        COUNT   = desert.count();
        WIDTH   = desert.image_width();
        HEIGHT  = desert.image_height();
        
        ImageView imageView = new ImageView(IMAGE);
        
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
 
        final Animation animation = new Animator(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        
        animation.setCycleCount(Animation.INDEFINITE);
        /**
         * This is controlling the rate of the animation.
         */
        animation.setRate(0.5);
        animation.play();
 
        primaryStage.setScene(new Scene(new Group(imageView),1000,1400));
        primaryStage.show();
    }
}