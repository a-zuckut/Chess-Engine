package chess_parts.chess_pieces;

import chess_logic.Color;
import chess_logic.Position;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Queen extends Piece {

	public Queen(Color color, Position position) {
		super(color, position, PieceTypes.Queen);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

}
