package chess_logic;

public class Move {

	private String colomn;
	private int row;

	public static String colomns = "ABCDEFGH";
	public static int firstRow = 1, lastRow = 8;

	/**
	 * Move in chess
	 * 
	 * @param col
	 * @param row
	 */
	public Move(String col, int row) {
		this.colomn = col.toUpperCase();
		this.row = row;
	}

	public boolean validCol() {
		return colomns.contains(colomn);
	}

	public boolean validRow() {
		return row >= firstRow && row <= lastRow;
	}
	
	public String getColumn() {
		return colomn;
	}
	
	public int getRow() {
		return row;
	}

}
