package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

import enemies.*;
import game.FrameMessage;
import game.Tile;
import game.TowersOfBrimstoneController;
import game.TowersOfBrimstoneModel;
import stages.Map;
import stages.MapVariant;
import towers.FireTower;
import towers.Tower;
/**
 * This is the unit testing all the non gui class.
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class unit_testing {

	@Test
	public void test_model_controller() {

		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		System.out.println("PATH");
		System.out.println(controller.get_path());
		model.addGold(10000);
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
		System.out.println(controller.checkTower(5, 4));
		System.out.println(controller.checkTower(12, 6));
		System.out.println(controller.checkTower(12, 7));
		System.out.println(controller.checkTower(7, 23));
		System.out.println(controller.checkTower(5, 25));
		System.out.println(controller.checkTower(5, 18));
		System.out.println(controller.checkTower(5, 2));
	}
	
	@Test
	public void checks_tower() {

		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		System.out.println("PATH");
		System.out.println(controller.get_path());
		model.addGold(10000);		
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
		System.out.println(controller.checkTower(5, 4));
		System.out.println(controller.checkTower(12, 6));
		System.out.println(controller.checkTower(12, 7));
		System.out.println(controller.checkTower(7, 23));
		System.out.println(controller.checkTower(5, 25));
		System.out.println(controller.checkTower(5, 18));
		System.out.println(controller.checkTower(5, 2));
	}
	
	@Test
	public void test_map_1() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		ArrayList<ArrayList<Tile>> pathArrayList  = controller.get_path();
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void test_map_2() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(2);
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void test_map_3() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(3);
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void test_map_4() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(4);
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void test_map_5() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(5);
		for (int i = 0 ; i < 200000 ; i++) {
			controller.frameUpdate(i);
		}		
	}
	
	@Test
	public void test_map_6() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(6);
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
		assertEquals(26,tower.getAttackPower());;
		assertEquals(180,tower.getRange());
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
	public void test_enemy_classes() {
		TowersOfBrimstoneModel model = new TowersOfBrimstoneModel();
		TowersOfBrimstoneController controller = new TowersOfBrimstoneController(model);
		controller.createMap(1);
		ArrayList<Tile> pathArrayList = controller.get_path().get(0);
		
		Enemy one   = new Enemy1(pathArrayList);
		assertEquals("Enemy 1", one.toString());
		Enemy two   = new Enemy2(pathArrayList);
		assertEquals("Enemy 2", two.toString());
		Enemy three = new Enemy3(pathArrayList);
		assertEquals("Enemy 3", three.toString());
		Enemy four  = new Enemy4(pathArrayList);
		assertEquals("Enemy 4", four.toString());
		Enemy five  = new Enemy5(pathArrayList);
		assertEquals("Enemy 5", five.toString());
		Enemy six   = new Enemy6(pathArrayList);
		assertEquals("Enemy 6", six.toString());
		assertTrue(one.getImage().contains("1"));
		assertTrue(two.getImage().contains("2"));
		assertTrue(three.getImage().contains("3"));
		assertTrue(four.getImage().contains("4"));
		assertTrue(five.getImage().contains("5"));
		assertTrue(six.getImage().contains("6"));

		
	}

}
