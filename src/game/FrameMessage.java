package game;

import java.util.ArrayList;

import enemies.Enemy;
import enemies.Zombie;

public class FrameMessage {
	
	private ArrayList<ArrayList<Tile>> grid;
	private int tick;
	private int currency;
	private ArrayList<Enemy> enemies;
	
	public FrameMessage(ArrayList<ArrayList<Tile>> grid, int tick, int currency, ArrayList<Enemy> enemies) {
    	this.grid = grid;
    	this.tick = tick;
    	this.currency = currency;
    	this.enemies = enemies;
    	// we can also use setter methods if the parameters gets too lengthy
    }
	
	public ArrayList<ArrayList<Tile>> getGrid() {
		return grid;
    }
	
	public int getTick() {
		return tick;
    }
	
	public int getCurrency() {
		return currency;
    }
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
    }
}
