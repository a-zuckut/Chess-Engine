package chess_parts.chess_pieces;

import chess_logic.Color;
import chess_logic.Move;
import chess_logic.Position;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Knight extends Piece {

	public Knight(Color color, Position position) {
		super(color, position, PieceTypes.Knight);
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
		return new String[]{""};
	}

	/**
	 * IMPLEMENT
	 */
	@Override
	public boolean validMove(Move move) {
		return false;
	}

}