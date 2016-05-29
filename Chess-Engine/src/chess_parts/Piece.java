package chess_parts;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;

public abstract class Piece {

	protected PieceTypes type;
	public Location position;
	public Color color;
	private String name;
	private String abrev;
	
	public ArrayList<Location> possibleGenericMoves;
	public ArrayList<Location> possibleMovesDependingOnBoard;

	public Piece(Color color, Location position, PieceTypes type) {
		this.color = color;
		this.position = position;
		this.type = type;
		name = setPiece();
		abrev = color.abrev() + type.abrev();
		
		possibleGenericMoves = new ArrayList<>();
		possibleMovesDependingOnBoard = new ArrayList<>();
	}

	/**
	 * Checks the validity moves at current position.
	 * @return Array with all the possible moves from the current position.
	 */
	public abstract ArrayList<Location> possibleGenericMoves();
	
	public abstract ArrayList<Location> validMoves(Board board);

	/**
	 * Given a possible move, returns if it is valid.
	 * @param move The current move.
	 * @param turn TODO
	 * @return if the move is valid. 
	 */
	public abstract boolean validMove(Location move, Color turn);
	
	public void update(Location new_pos, Board board) {
		position = new_pos;
		possibleGenericMoves = possibleGenericMoves();
		possibleMovesDependingOnBoard = validMoves(board);
	}

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

	public Location getPos() {
		return position;
	}
	
	public void updatePosition(Location new_pos) {
		position = new_pos;
	}

}
