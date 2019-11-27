package experimenting;

import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ColorHelper extends GUI {
    
    public BorderPane mainScreen;
    public BorderPane newGameScreen;
    public BorderPane Level1;
    
    public void makeMainScreen() {
	mainScreen = new BorderPane();
	VBox menuItems = new VBox();
	menuItems.setAlignment(Pos.CENTER);
	menuItems.setMaxWidth(500);
	menuItems.setMaxHeight(300);
	menuItems.setPadding(new Insets(100, 100, 100, 100));
	ImageView gameName = new ImageView("gameName.png");
	gameName.setFitWidth(800);
	gameName.setFitHeight(400);
	ImageView singlePlayer = new ImageView("singlePlayer.png");
	setupImageView(singlePlayer);
	ImageView multiPlayer = new ImageView("multiPlayer.png");
	setupImageView(multiPlayer);
	ImageView quit = new ImageView("singlePlayer.png");
	setupImageView(quit);
	Image image = new Image("bg.png",1400, 1000, false, false);
	
	BackgroundImage background = new BackgroundImage(image, null, null, null, null);
	
	Background background2 = new Background(background);
	
	menuItems.getChildren().add(gameName);
	menuItems.getChildren().add(singlePlayer);
	menuItems.getChildren().add(multiPlayer);
	menuItems.getChildren().add(quit);
	mainScreen.setMaxWidth(1400);
	mainScreen.setMaxHeight(1000);
	mainScreen.setBackground(background2);
	mainScreen.setCenter(menuItems);
	
	 singlePlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
		// setting a mouseEvent on the column in the grid
		@Override
		public void handle(MouseEvent event) {
		    makeLevel1();
		    scene = new Scene(Level1); 

		}
	    });

    }
    
    public void setupImageView(ImageView imgView) {
	imgView.setPreserveRatio(true);
	imgView.setFitWidth(500);
	imgView.setFitHeight(300);
	
    }
    
    
    public void makeLevel1() {
	Level1 = new BorderPane();
	
	Image img = new Image("assets/easyMap2-01.png");
	Canvas map = new Canvas();
	
	map.getGraphicsContext2D().drawImage(img, 0, 0,1400,1000);
	Image image = new Image("assets/UI/label/menuTowerEmpty.png",1400, 200, false, false);
	
	BackgroundImage background = new BackgroundImage(image, null, null, null, null);
	
	Background background2 = new Background(background);
	HBox hBox = new HBox();
	
	
	
	hBox.setBackground(background2);
	
	ImageButton stone = new ImageButton("assets/UI/buttons/stone.png",125,125);
	ImageButton fire = new ImageButton("assets/UI/buttons/fire.png",125,125);
	ImageButton ice = new ImageButton("assets/UI/buttons/ice.png",125,125);
	ImageButton heavy = new ImageButton("assets/UI/buttons/heavy.png",125,125);
	ImageButton lightning = new ImageButton("assets/UI/buttons/lightning.png",125,125);
	ImageButton magic = new ImageButton("assets/UI/buttons/magic.png",125,125);
	ImageButton slowdown = new ImageButton("assets/UI/buttons/slowdown.png",125,125);
	ImageButton damageboost = new ImageButton("assets/UI/buttons/damageboost.png",125,125);
	
	
	hBox.getChildren().add(stone);
	hBox.getChildren().add(fire);
	hBox.getChildren().add(ice);
	hBox.getChildren().add(heavy);
	hBox.getChildren().add(lightning);
	hBox.getChildren().add(magic);
	hBox.getChildren().add(slowdown);
	hBox.getChildren().add(damageboost);
	Level1.setCenter(map);
	Level1.setBottom(hBox);
	
	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
