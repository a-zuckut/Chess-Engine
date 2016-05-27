package chess_logic;

public class Position {

	int x;
	int y;
	
	/**
	 * Position on chess board
	 * @param x Corresponds to Letter. (col)
	 * @param y Corresponds to number. (row)
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return x + " " + y;
	}
	
}
