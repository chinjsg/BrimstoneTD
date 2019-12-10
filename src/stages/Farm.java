package stages;

import java.util.ArrayList;

public class Farm extends MapVariant {

	public Farm(int[][] map) {
		super(map);
	}

	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord = new int[2];
		coord[0] = 2;
		coord[1] = 0;
		spots.add(coord);
		
		return spots;
	}

	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 8;
		coord[1] = 27;
		
		return coord;
	}
}
