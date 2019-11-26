package game;

import java.util.ArrayList;

import experimenting.ImageButton;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TowersOfBrimstoneView extends Application {
    private TowersOfBrimstoneController controller;
    private int money;
    private boolean TowerSelected;
    private AnchorPane base;

    @Override
    public void start(Stage primaryStage) throws Exception {
	base = new AnchorPane();
	BorderPane root = new BorderPane();
	Canvas canvas = new Canvas(1400, 1000);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	 gc.drawImage(new Image("easyMap.png",1400,1000, false, false),0, 0);
	GraphicsContext valueLayer = canvas.getGraphicsContext2D();
	GraphicsContext towerMenuLayer = canvas.getGraphicsContext2D();

	TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
	TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
	controller.createMap();

	ArrayList<ArrayList<Tile>> grid = model.getGrid();
	System.out.println(grid);

	money = 5000;

//	gc.fillText("Money: " + Integer.toString(money), 100, 100);
	root.setCenter(canvas);
	base.getChildren().add(root);
	setUpTowerMenu();
	Scene scene = new Scene(base, 1400, 1000);
	canvas.setOnMouseClicked((event) -> {
	    int xPos = (int) event.getX();
	    int yPos = (int) event.getY();
	    // if click on tower in store
	    //
	    //
	    //
	    //
	    System.out.println("ROW " + yPos / 50 + " COL " + xPos / 50);
	    money -= 50;
	});
	primaryStage.setScene(scene);
	primaryStage.show();

	new AnimationTimer() {
	    long lastUpdate = 0;

	    @Override
	    public void handle(long now) {
		// TODO Auto-generated method stub
		long timeSec = (now - lastUpdate) / (1000000000 / 30); // 30 Frames every 1 sec.
		if (timeSec >= 1) {
//		    for (int row = 0; row < grid.size(); row++) {
//			for (int col = 0; col < grid.get(0).size(); col++) {
//			    Tile tile = grid.get(row).get(col);
//			    gc.drawImage(tile.getTexture(), 50 * col, 50 * row);
//			}
//		    }
		   
		    towerMenuLayer.drawImage(new Image("menuTowerEmpty.png"), 0, 900, 1400, 100);
		    valueLayer.fillText("Money: " + money, 200, 200);
		    lastUpdate = now;
		}

	    }

	}.start();

    }

    private void setUpTowerMenu() {
	int height = 90;
	int width = 110;
	HBox hBox = new HBox();
	ImageButton stone = new ImageButton("stone.png",width, height);
	ImageButton fire = new ImageButton("fire.png", width, height);
	ImageButton ice = new ImageButton("ice.png", width, height);
	ImageButton heavy = new ImageButton("heavy.png", width, height);
	ImageButton lightning = new ImageButton("lightning.png", width, height);
	ImageButton magic = new ImageButton("magic.png", width, height);
	ImageButton slowdown = new ImageButton("slowdown.png", width, height);
	ImageButton damageboost = new ImageButton("damageboost.png", width, height);

	hBox.setAlignment(Pos.CENTER);
	hBox.setSpacing(100);
	hBox.setPadding(new Insets(0, 0, 0, 50));
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
    }

}