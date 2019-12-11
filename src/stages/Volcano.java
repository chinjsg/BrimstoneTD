package stages;

import java.util.ArrayList;
/**
 * @author Glen Chin
 * @author Marko Kreso
 * @author Abhishek Sharma
 * @author Abhishek Agarwal
 *
 */
public class Volcano extends MapVariant {
	/**
	 * This is the constructor for the class
	 * @param map
	 */
	public Volcano(int[][] map) {
		super(map);
		// TODO Auto-generated constructor stub
	}
	/**
	 * It will create the beginning way for the map
	 */
	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord_one = new int[2];
		coord_one[0] = 6;
		coord_one[1] = 0;
		int[] coord_two = new int[2];
		coord_two[0] = 0;
		coord_two[1] = 9;
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
		coord[0] = 17;
		coord[1] = 26;
		
		return coord;
	}

}
