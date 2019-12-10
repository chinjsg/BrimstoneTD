package stages;

import java.util.ArrayList;

public class Desert extends MapVariant {
	
	public Desert(int[][] map) {
		super(map);
	}

	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord = new int[2];
		coord[0] = 6;
		coord[1] = 0;
		spots.add(coord);
		
		return spots;
	}

	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 4;
		coord[1] = 27;
		
		return coord;
	}

}
