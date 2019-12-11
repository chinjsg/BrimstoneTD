package stages;

import java.util.ArrayList;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class Oasis extends MapVariant {
	/**
	 * This is the constructor for the class
	 * @param map
	 */
	public Oasis(int[][] map) {
		super(map);
	}
	/**
	 * It will create the beginning way for the map
	 */
	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord = new int[2];
		coord[0] = 11;
		coord[1] = 0;
		spots.add(coord);
		
		return spots;
	}
	/**
	 * It will map the end on the map
	 */
	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 15;
		coord[1] = 27;
		
		return coord;
	}
}
