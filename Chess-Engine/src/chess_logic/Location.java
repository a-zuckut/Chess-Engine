package chess_logic;

import java.util.Arrays;

public class Location {

	private int column;
	private int row;

	public static int firstRow = 1, lastRow = 8;

	/**
	 * Move in chess
	 * 
	 * @param col from 0 - 7 (a-h)
	 * @param row from 0 - 7 (1-8)
	 */
	public Location(int col, int row) {
		this.column = col;
		this.row = row;
	}

	public boolean validCol() {
		return column + 1 >= firstRow && column + 1 <= lastRow;
	}

	public boolean validRow() {
		return row + 1 >= firstRow && row + 1 <= lastRow;
	}
	
	/**
	 * Column
	 * @return
	 */
	public int getX() {
		return column;
	}
	
	/**
	 * Row
	 * @return
	 */
	public int getY() {
		return row;
	}
	
	public String toString() {
		return OpeningAndHelpers.convertColToLetter(column) + (row + 1);
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Location) {
			return (column == ((Location)object).column && row == ((Location)object).row);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
	    return (int)(3 * 13 * column + 41 * 37 * row + Math.pow(4, 10));
	}
	
	
}
