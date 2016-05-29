package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Bishop extends Piece {

	public Bishop(Color color, Location position) {
		super(color, position, PieceTypes.Bishop);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

	/**
	 * Adding possible moves to ArrayList possibleGenericMoves Then
	 */
	@Override
	public ArrayList<Location> validMoves(Board board) {
		return null;
	}

	@Override
	public ArrayList<Location> possibleGenericMoves() {
		return null;
	}

	@Override
	public boolean validMove(Location move, Color turn) {
		return false;
	}

}
