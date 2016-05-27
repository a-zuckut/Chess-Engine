package chess_parts;

import chess_logic.Color;
import chess_logic.Move;
import chess_logic.Position;

public abstract class Piece {

	protected PieceTypes type;
	private Color color;
	private Position position;
	private String name;
	private String abrev;

	public Piece(Color color, Position position, PieceTypes type) {
		this.color = color;
		this.position = position;
		this.type = type;
		name = setPiece();
		abrev = color.abrev() + type.abrev();
	}

	/**
	 * Checks valids moves at current position.
	 * @return Array with all the possible moves from the current position.
	 */
	public abstract String[] validMoves();

	/**
	 * Given a possible move, returns if it is valid.
	 * @param move The current move.
	 * @return if the move is valid. 
	 */
	public abstract boolean validMove(Move move);

	public abstract String setPiece();

	public String toString() {
		return color.toString() + " " + name + " at " + position.toString();
	}

	public Color getColor() {
		return color;
	}

	public PieceTypes getPieceType() {
		return type;
	}

	public String abrev() {
		return abrev;
	}

	public String name() {
		return name;
	}

	public Position getPos() {
		return position;
	}
	
	public void updatePosition(Position new_pos) {
		position = new_pos;
	}

}
