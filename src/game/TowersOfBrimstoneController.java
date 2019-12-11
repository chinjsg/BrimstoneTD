package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import com.sun.javafx.geom.Point2D;

import enemies.Enemy;
import enemies.Enemy1;
import enemies.Enemy2;
import enemies.Enemy3;
import enemies.Enemy4;
import enemies.Enemy5;
import enemies.Enemy6;
import stages.Map;
import stages.MapVariant;
import towers.StoneTower;
import towers.FireTower;
import towers.HeavyTower;
import towers.IceTower;
import towers.LightningTower;
import towers.MagicTower;
import towers.Tower;

/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class TowersOfBrimstoneController {

    private TowersOfBrimstoneModel model;
    private ArrayList<Tile> enemyPath;
    private ArrayList<ArrayList<Tile>> allEnemyPaths;
    private Map map;

    /**
     * This is the controller of our Game
     * 
     * @param model
     */
    public TowersOfBrimstoneController(TowersOfBrimstoneModel model) {
	this.model = model;
    }

    /**
     * This function will help us to create our map based on the Map number we get
     * when the user select it
     * 
     * @param mapNum
     */
    public void createMap(int mapNum) {
		enemyPath = new ArrayList<Tile>();
		allEnemyPaths = new ArrayList<ArrayList<Tile>>();
		ArrayList<ArrayList<Tile>> board = model.getGrid();
	
		map = new Map();
		MapVariant mv = map.getMap(mapNum);
		int[][] path = mv.getPath();
	
		for (int row = 0; row < path.length; row++) {
		    for (int col = 0; col < path[0].length; col++) {
		    	Tile tile = board.get(row).get(col);
				if (path[row][col] == 1) {
				    tile.setIsPath();
				} else if (path[row][col] == 2) {
				    tile.setIsPlaceable();
				}
		    }
		}
		int[] coordEnd = mv.getEnd();
		model.setEnd(coordEnd[0], coordEnd[1]);
	
		ArrayList<int[]> possibleSpots = mv.getAllStart();
		for (int[] coord : possibleSpots) {
		    createPath(coord[0], coord[1]);
		}
	
		model.setWaves(createWaveMap(mapNum));
    }

	/**
	 * This function will help us to create the wave of enemy
	 * @return ArrayList<Queue<Enemy>>
	 */
	private ArrayList<Queue<Enemy>> createWaveMap(int mapNum){
		ArrayList<Queue<Enemy>> waves = new ArrayList<Queue<Enemy>>();;
		if (mapNum == 1) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 3, 1, 2, 1, 1)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 2, 1, 1, 1, 2, 3)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 1, 3, 6, 3, 3)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
		} else if (mapNum == 2) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 1, 1, 2, 3, 3, 1)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(3, 2, 2, 2, 1, 3, 4, 1, 3)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(3, 6, 2, 3, 3, 3, 3, 5, 3)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
		} else if (mapNum == 3) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1, 4, 2, 2, 3, 1)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(6, 1, 3, 3, 1, 4, 4, 2, 3)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(4, 3, 3, 1, 5, 3, 2, 6, 5)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
		} else if (mapNum == 4) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 1, 3, 1, 3, 3, 1, 3, 1)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(4, 4, 2, 1, 1, 3, 3, 3, 1)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 1, 3, 3, 4, 4, 1, 5, 3)), allEnemyPaths);
			Queue<Enemy> wave4 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(6, 6, 2, 2, 3, 3, 3, 2, 5)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
			waves.add(wave4);
		} else if (mapNum == 5) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 3, 1, 1, 3, 2, 4, 3, 2)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(3, 3, 4, 4, 1, 6, 2, 5, 3)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(1, 1, 3, 3, 4, 2, 2, 4, 5)), allEnemyPaths);
			Queue<Enemy> wave4 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(2, 2, 6, 6, 5, 6, 2, 2, 4)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
			waves.add(wave4);
		} else if (mapNum == 6) {
			Queue<Enemy> wave1 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 3, 4, 1, 3)), allEnemyPaths);
			Queue<Enemy> wave2 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(3, 1, 6, 4, 1, 6, 2, 3, 3)), allEnemyPaths);
			Queue<Enemy> wave3 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(3, 3, 4, 5, 5, 4, 1, 3, 4)), allEnemyPaths);
			Queue<Enemy> wave4 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(2, 2, 6, 6, 5, 6, 2, 4, 4)), allEnemyPaths);
			Queue<Enemy> wave5 = createEnemyObjects(new ArrayList<Integer>(Arrays.asList(6, 6, 6, 2, 2, 6, 3, 2, 5)), allEnemyPaths);
			waves.add(wave1);
			waves.add(wave2);
			waves.add(wave3);
			waves.add(wave4);
			waves.add(wave5);
		}
		return waves;
	}
	
	/**
	 * This function will help us to create the object of the enemy passed in it.
	 * 
	 * @param enemies
	 * @param allPaths
	 * @return Queue<Enemy>
	 */
	private Queue<Enemy> createEnemyObjects(ArrayList<Integer> enemies, ArrayList<ArrayList<Tile>> allPaths){
		Queue<Enemy> wave = new LinkedList<Enemy>();
		Random rand = new Random();
		for(Integer enemyType: enemies) {
			ArrayList<Tile> path = allPaths.get(rand.nextInt(allPaths.size()));
			if(enemyType == 1) {
				wave.add(new Enemy1(path));
			}
			if(enemyType == 2) {
				wave.add(new Enemy2(path));
			}
			if(enemyType == 3) {
				wave.add(new Enemy3(path));
			}
			if(enemyType == 4) {
				wave.add(new Enemy4(path));
			}
			if(enemyType == 5) {
				wave.add(new Enemy5(path));
			}
			if(enemyType == 6) {
				wave.add(new Enemy6(path));
			}
			
		}
		return wave;
	}
	
	/**
	 * This will place Tile in the location provided.
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean createPath(int row, int col) {
		boolean found = false;
		//System.out.println("ROW: "+ row + " COL: " + col);
		if(col < model.getRow(row).size() && row < model.getCol(col).size()) {
			if(model.getRow(row).get(col).equals(model.getEnd())) {
				enemyPath.add(model.getRow(row).get(col));
				found = true;
				allEnemyPaths.add(enemyPath);
				enemyPath = new ArrayList<Tile>();
				return found;
			}
			if(enemyPath.contains(model.getRow(row).get(col))) {
				return false;
			}
			if(model.getRow(row).get(col).getIsPath()) {
				enemyPath.add(model.getRow(row).get(col));
				if(!found)
					found = createPath(row, col+1);
				if(!found)
					found = createPath(row+1, col);
				if(!found)
					found = createPath(row-1, col);
				if(!found)
					found = createPath(row, col-1);
			}
		}
		return found;
    }

    /**
     * Check that the selected grid is not a path, isPlaceable and no tower has
     * already been placed
     * 
     * @param row
     * @param col
     * @param selectedTowerType
     * @return boolean
     */
    public boolean placeTower(int row, int col, int selectedTowerType) {
	ArrayList<ArrayList<Tile>> board = model.getGrid();
	Tile tile = board.get(row).get(col);
	Tower tower = getTowerType(row, col, selectedTowerType);
	// Check that the selected grid is not a path, isPlaceable and no tower has
	// already been placed
	if (!tile.getIsPath() && tile.getIsPlaceable() && tile.getPlacedTower() == null) {
	    int price = tower.getCost();
	    if (price <= model.getGold()) {
		return model.placeTower(row, col, tower);
	    }
	}
	return false;
    }

    /**
     * This will return the tower at the position specified by row and col.
     * 
     * @param row
     * @param col
     * @return Tower
     */
    public Tower checkTower(int row, int col) {
	ArrayList<ArrayList<Tile>> board = model.getGrid();
	Tile tile = board.get(row).get(col);

	if (tile.getPlacedTower() != null) {
	    return tile.getPlacedTower();
	}
	return null;

    }

    /**
     * This will help us to get the towertype at a particular position.
     * 
     * @param row
     * @param col
     * @param towerNum
     * @return Tower
     */
    private Tower getTowerType(int row, int col, int towerNum) {
	Tower tower = null;
	if (towerNum == 1) {
	    tower = new StoneTower(row, col);
	} else if (towerNum == 2) {
	    tower = new FireTower(row, col);
	} else if (towerNum == 3) {
	    tower = new IceTower(row, col);
	} else if (towerNum == 4) {
	    tower = new HeavyTower(row, col);
	} else if (towerNum == 5) {
	    tower = new LightningTower(row, col);
	} else if (towerNum == 6) {
	    tower = new MagicTower(row, col);
	}
	return tower;
    }

    /**
     * This function will keep in track the tower sell and remove from the list.
     * 
     * @param tower
     */
    public void sellTower(Tower tower) {
	int row = tower.getRow();
	int col = tower.getCol();
	int sellback = tower.getSellPrice();
	model.removeTower(row, col, sellback);
    }

    /**
     * This function will calculate the distance between two points. Basically
     * calculated the distance of the enemy from the tower.
     * 
     * @param tick
     */
    private void collisionDetection(int tick) {
	ArrayList<Tower> towers = model.getTowers();
	int range;
	double distance;
	for (Tower tower : towers) {
	    ArrayList<Enemy> enemies = model.getEnemy();
	    Iterator<Enemy> iterator = enemies.iterator();
	    while (iterator.hasNext()) {
		Enemy enemy = iterator.next();
		if (enemy.getHealth() <= 0) {
		    model.addGold(enemy.getGoldReward());
		    iterator.remove();
		} else if (enemy.getHealth() > 0 && tick % 10 == 0) {
		    range = tower.getRange();
		    distance = tower.getPos().distance(enemy.getPos());
		    if (distance <= range) {
			if (tower.canFire() == true) {
			    tower.fire(enemy);
			}

			tower.updateProjectiles();
			break;
		    }
		}

	    }
	    tower.updateProjectiles();
	}
	if (model.getHealth() <= 0) {
	    model.setLost();
	}
    }

    /**
     * This will helps us to update the enemy wave
     * 
     * @param tick
     */
    private void updateWave(int tick) {
	ArrayList<Queue<Enemy>> waves = model.getWaves();
	ArrayList<Enemy> enemies = model.getEnemy();
	int waveNum = model.getWaveNum();
	if (waves.size() == waveNum) {
	    model.setWon();
	} else {
	    Queue<Enemy> curWave = waves.get(waveNum);
	    if (curWave.size() != 0) { // Pop queue
		model.addEnemy(curWave.remove());
	    } else if (enemies.size() == 0) {
		model.incrementWaveNum();
	    }
	}
    }

    /**
     * This function is literally controlling our Game.
     * 
     * @param tick
     */
    public void frameUpdate(int tick) {

	if (tick % 100 == 5) {
	    updateWave(tick);
	}
	moveEnemy();
	collisionDetection(tick);
	enemyAtEnd();
	model.updateFrame(tick);

    }

    /**
     * This will check if the enemy has reached the end of the path
     */
    private void enemyAtEnd() {
	double distance;
	ArrayList<Enemy> enemies = model.getEnemy();
	Iterator<Enemy> iterator = enemies.iterator();
	while (iterator.hasNext()) {
	    Enemy enemy = iterator.next();
	    distance = (model.getEnd().getPos()).distance(enemy.getPos());
	    if (distance < 10) {
		model.subtractHealth(enemy.getDamage());
		System.out.println("HEALTH:" + model.getHealth());
		iterator.remove();
	    }
	}

    }

    /**
     * It will return the ArrayList of path
     * 
     * @return ArrayList<ArrayList<Tile>>
     */
    public ArrayList<ArrayList<Tile>> get_path() {
	return allEnemyPaths;
    }

    /**
     * This will update the position of the enemy.
     */
    private void moveEnemy() {
	// TODO Auto-generated method stub
	for (Enemy enemy : model.getEnemy()) {
	    enemy.move(enemy.getSpeed() * enemy.getDirection().getX(), enemy.getSpeed() * enemy.getDirection().getY());
	}
    }
}
