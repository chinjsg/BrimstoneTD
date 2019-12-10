package stages;

import java.util.ArrayList;

public abstract class MapVariant {
	int[][] grid;
	
	public MapVariant(int[][] map) {
		this.grid = map;
	}
	
	public int[][] getPath() {
		return grid;
	}
	
	public abstract ArrayList<int[]> getAllStart();
	public abstract int[] getEnd();
}
