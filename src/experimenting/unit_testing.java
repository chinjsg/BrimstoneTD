package experimenting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

import enemies.Enemy;
import enemies.Enemy1;
import game.FrameMessage;
import game.Tile;
import game.TowersOfBrimstoneController;
import game.TowersOfBrimstoneModel;
import stages.Map;
import stages.MapVariant;
import towers.FireTower;
import towers.Tower;

public class unit_testing {
	@Test
	public void test1() {

		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		
//		model.setEnd(4, 27);
//		model.setEndingTile(4, 27);
		
		assertTrue(controller.placeTower(5, 4, 1));
		assertTrue(controller.placeTower(12, 6, 2));
		assertTrue(controller.placeTower(12, 7, 3));
		assertTrue(controller.placeTower(7, 23, 4));
		assertTrue(controller.placeTower(5, 25, 5));
		assertTrue(controller.placeTower(5, 18, 6));
		assertFalse(controller.placeTower(0, 0, 1));
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
		System.out.println(controller.checkTower(0, 0));
		System.out.println("---");
		System.out.println(controller.checkTower(5, 4));
		System.out.println(controller.checkTower(12, 6));
		System.out.println(controller.checkTower(12, 7));
		System.out.println(controller.checkTower(7, 23));
		System.out.println(controller.checkTower(5, 25));
		System.out.println(controller.checkTower(5, 18));
		System.out.println(controller.checkTower(5, 2));
		ArrayList<Tile> enemyPath = null;
		enemyPath.add(model.getRow(0).get(0));
		System.out.println(enemyPath);
	}
	@Test
	public void test10() {

		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		ArrayList<ArrayList<Tile>> pathArrayList  = controller.get_path();
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void tower_class() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		Tower tower = new FireTower(12, 7);
		System.out.println(tower.getPos());
		assertFalse(tower.getAreaDamage());
		assertEquals(25,tower.getAttackPower());;
		assertEquals(200,tower.getRange());
		assertEquals("tower_fire.png",tower.getImage());
		controller.sellTower(tower);
		model.updateTowerMap(tower);
	}
	
	@Test
	public void map_testing() {
		Map mp = new Map();
		MapVariant mv1 = mp.getMap(1);
		MapVariant mv2 = mp.getMap(2);
		MapVariant mv3 = mp.getMap(3);
		MapVariant mv4 = mp.getMap(4);
		MapVariant mv5 = mp.getMap(5);
		MapVariant mv6 = mp.getMap(6);
		
		System.out.println(mv1.getAllStart() + " " + mv1.getEnd());
		System.out.println(mv2.getAllStart() + " " + mv2.getEnd());
		System.out.println(mv3.getAllStart() + " " + mv3.getEnd());
		System.out.println(mv4.getAllStart() + " " + mv4.getEnd());
		System.out.println(mv5.getAllStart() + " " + mv5.getEnd());
		System.out.println(mv6.getAllStart() + " " + mv6.getEnd());
	}
	
	@Test
	public void test2() {
		Tile t = new Tile(0,0);
		t.removeEnemy();
		t.getContainsEnemy();
		System.out.println(t.getTexture());
		System.out.println(t);
		Paths paths = new Paths();
	}
	
	
	public void test3(ArrayList<Tile> pathArrayList) {
		
		Enemy one   = new Enemy1(pathArrayList);
		assertEquals("Enemy 1", one);
		Enemy two   = new Enemy1(pathArrayList);
		assertEquals("Enemy 2", two);
		Enemy three = new Enemy1(pathArrayList);
		assertEquals("Enemy 3", three);
		Enemy four  = new Enemy1(pathArrayList);
		assertEquals("Enemy 4", four);
		Enemy five  = new Enemy1(pathArrayList);
		assertEquals("Enemy 5", five);
		Enemy six   = new Enemy1(pathArrayList);
		assertEquals("Enemy 6", six);
		System.out.println(one.getImage());
		System.out.println(two.getImage());
		System.out.println(three.getImage());
		System.out.println(four.getImage());
		System.out.println(five.getImage());
		System.out.println(six.getImage());
		
	}
}
