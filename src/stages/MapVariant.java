package stages;

import java.util.ArrayList;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public abstract class MapVariant {
	int[][] grid;
	
	/**
	 * This is the constructor for the class
	 * @param map
	 */
	public MapVariant(int[][] map) {
		this.grid = map;
	}
	/**
	 * This will return the 2d list of map
	 * 
	 */
	public int[][] getPath() {
		return grid;
	}
	
	public abstract ArrayList<int[]> getAllStart();
	public abstract int[] getEnd();
}
