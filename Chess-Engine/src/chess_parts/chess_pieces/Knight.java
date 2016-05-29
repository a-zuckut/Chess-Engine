package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Knight extends Piece {

	public Knight(Color color, Location position) {
		super(color, position, PieceTypes.Knight);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

	@Override
	public ArrayList<Location> validMoves(Board board) {
		return null;
	}

	@Override
	public boolean validMove(Location move, Color turn) {
		return false;
	}

	@Override
	public ArrayList<Location> possibleGenericMoves() {
		return null;
	}

}
