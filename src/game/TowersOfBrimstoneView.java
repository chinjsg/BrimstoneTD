package game;

import java.util.ArrayList;

import enemies.Enemy;
import enemies.Zombie;
import javafx.animation.AnimationTimer;
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
	private TowersOfBrimstoneController controller;
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1000;
	private int time;
	private int money;
	
	private boolean TowerSelected;
	@Override
	public void start(Stage primaryStage) throws Exception {
		time = 1;
		BorderPane root = new BorderPane();
		Canvas canvas = new Canvas(1400, 1000);
		Canvas enemies = new Canvas(1400,1000);
		GraphicsContext enemyGc = enemies.getGraphicsContext2D();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		GraphicsContext valueLayer = canvas.getGraphicsContext2D();
		
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap();
		
		ArrayList<ArrayList<Tile>> grid = model.getGrid();
		controller.getEnemyPath();
		
		money = 5000;

		
		gc.fillText("Money: " + Integer.toString(money), 100, 100);
		
		Scene scene = new Scene(root, 1400, 1000);
		canvas.setOnMouseClicked((event)->{
			int xPos = (int) event.getX();
			int yPos = (int) event.getY();
			//if click on tower in store
			//
			//
			//
			//
			System.out.println("ROW " + yPos/50 + " COL " + xPos/50);
			money -= 50;
		});
		Zombie zomb = new Zombie(0,6, controller.getEnemyPath());
		
		
		root.getChildren().add(canvas);
		root.getChildren().add(enemies);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new AnimationTimer() {
			long lastUpdate = 0;
			int tick = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long timeSec = (now - lastUpdate)/(1000000000/60);				// 30 Frames every 1 sec.
				if(timeSec >= 1) {
					for(int row = 0; row < grid.size(); row++) {
						for(int col=0; col < grid.get(0).size(); col++) {
							Tile tile = grid.get(row).get(col);
							gc.drawImage(tile.getTexture(), 50*col, 50*row);
						}
						if(tick%20 == 0) {
							updateEnemy(zomb, enemyGc);
						}
						tick++;
					}
					valueLayer.fillText("Money: " + money, 200, 200);
					lastUpdate = now;
					
			}
				
			}
			
		}.start();
		
	}
	private void updateEnemy(Enemy enemy, GraphicsContext d) {
		d.clearRect(0, 0, WIDTH, HEIGHT);
		enemy.move(enemy.getSpeed()*enemy.getDirection().getX(), enemy.getSpeed()*enemy.getDirection().getY());
		d.drawImage(enemy.getImage(), enemy.getPos().getX()-25, enemy.getPos().getY()-25);
		
	}

}
