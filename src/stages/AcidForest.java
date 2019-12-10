package stages;

import java.util.ArrayList;

public class AcidForest extends MapVariant {

	public AcidForest(int[][] map) {
		super(map);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getAllStart() {
		ArrayList<int[]> spots = new ArrayList<int[]>();
		int[] coord = new int[2];
		coord[0] = 15;
		coord[1] = 0;
		spots.add(coord);
		
		return spots;
	}

	@Override
	public int[] getEnd() {
		int[] coord = new int[2];
		coord[0] = 17;
		coord[1] = 25;
		
		return coord;
	}

}
