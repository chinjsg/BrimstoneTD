package stages;

import java.util.ArrayList;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class Ice extends MapVariant {
	/**
	 * This is the constructor for the class
	 * @param map
	 */
	public Ice(int[][] map) {
		super(map);
	}
	/**
	 * It will create the beginning way for the map
	 */
	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord_one = new int[2];
		coord_one[0] = 13;
		coord_one[1] = 0;
		int[] coord_two = new int[2];
		coord_two[0] = 4;
		coord_two[1] = 10;
		spots.add(coord_one);
		spots.add(coord_two);
		
		return spots;
	}
	/**
	 * It will map the end on the map
	 */
	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 2;
		coord[1] = 24;
		
		return coord;
	}

}
