package game;

import java.util.ArrayList;

import enemies.Enemy;

public class FrameMessage {
	
	private ArrayList<ArrayList<Tile>> grid;
	private int tick;
	private int currency;
	private int health;
	private ArrayList<Enemy> enemies;
	
	public FrameMessage(ArrayList<ArrayList<Tile>> grid, int currency, ArrayList<Enemy> enemies, int health) {
    	this.grid = grid;
    	this.tick = tick;
    	this.health = health;
    	this.currency = currency;
    	this.enemies = enemies;
    	// we can also use setter methods if the parameters gets too lengthy
    }
	
	
	public ArrayList<ArrayList<Tile>> getGrid() {
		return grid;
    }
	public int getHealth() {
		return health;
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
