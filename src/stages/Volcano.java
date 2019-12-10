package stages;

import java.util.ArrayList;

public class Volcano extends MapVariant {

	public Volcano(int[][] map) {
		super(map);
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 17;
		coord[1] = 26;
		
		return coord;
	}

}
