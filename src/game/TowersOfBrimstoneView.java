package game;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TowersOfBrimstoneView extends Application{
	TowersOfBrimstoneController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1550, 1000);
		GridPane gridPane = new GridPane();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap();
		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		System.out.println(grid);
		
		for(int row = 0; row < grid.size(); row++) {
			for(int col=0; col < grid.get(0).size(); col++) {
				Tile tile = grid.get(row).get(col);
				gc.drawImage(tile.getTexture(), 50*col, 50*row);
			}
		}
		Rectangle rect = new Rectangle(100, 1000);
		rect.setFill(Color.ALICEBLUE);
		gridPane.add(rect, 1, 1);
		
		root.setLeft(canvas);
		root.setRight(rect);
		Scene scene = new Scene(root, 1550, 1000);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
