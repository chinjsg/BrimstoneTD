package game;

import java.util.ArrayList;

public class TowersOfBrimstoneModel {
	private ArrayList<ArrayList<Tile>> grid;
	private Tile endingTile;
	
	public TowersOfBrimstoneModel() {
		grid = createBlankMap();
	}
	
	public void setEndingTile(int row, int col) {
		endingTile = grid.get(row).get(col);
	}
	public ArrayList<Tile> getRow(int row){
		return grid.get(row);
	}
	
	public ArrayList<Title> getCol(int col){
		
	}
	private ArrayList<ArrayList<Tile>> createBlankMap() {
		ArrayList<ArrayList<Tile>> grid = new ArrayList<ArrayList<Tile>>(); 
		for(int row = 0; row < 20; row++) {
			ArrayList<Tile> rows = new ArrayList<>();
			for(int col = 0; col < 28; col++) {
				rows.add(new Tile(row , col));
			}
			grid.add(row, rows);
		}
		return grid;
	}

}
