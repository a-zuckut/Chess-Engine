package chess_parts.chess_pieces;

import chess_logic.Color;
import chess_logic.Move;
import chess_logic.Position;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Empty extends Piece {

	public Empty() {
		super(Color.NULL, new Position(0, 0), PieceTypes.NULL);
	}
	
	public Empty(Position position) {
		super(Color.NULL, position, PieceTypes.NULL);
	}
	
	public Empty(Color color, Position position) {
		super(color, position, PieceTypes.NULL);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

	@Override
	public String[] validMoves() {
		return null;
	}

	@Override
	public boolean validMove(Move move) {
		return false;
	}

}
