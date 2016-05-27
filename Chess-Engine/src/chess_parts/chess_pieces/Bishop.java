package chess_parts.chess_pieces;

import chess_logic.Color;
import chess_logic.Move;
import chess_logic.Position;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Bishop extends Piece {

	public Bishop(Color color, Position position) {
		super(color, position, PieceTypes.Bishop);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

	/**
	 * IMPLEMENT
	 */
	@Override
	public String[] validMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * IMPLEMENT
	 */
	@Override
	public boolean validMove(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
