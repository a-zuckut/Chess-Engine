package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class RookTests {

	@Test
	public void testingWhiteRooks() {
		Board board = new Board();
		assertEquals(PieceTypes.Rook, board.getPiece(new Location(0, 0)).getPieceType());
		assertEquals(Color.WHITE, board.getPiece(new Location(0, 0)).getColor());
		assertEquals(PieceTypes.Rook, board.getPiece(new Location(7, 0)).getPieceType());
		assertEquals(Color.WHITE, board.getPiece(new Location(7, 0)).getColor());
		
		Piece rook1 = board.getPiece(new Location(0, 0));
		rook1.validMoves(board);
		assertEquals(true, rook1.possibleMovesDependingOnBoard.isEmpty());
		assertEquals(true, board.move(new Location(0, 1), new Location(0, 3)));
		rook1.validMoves(board);
		assertEquals(false, rook1.possibleMovesDependingOnBoard.isEmpty());
		assertEquals(true, board.move(new Location(3, 6), new Location(3, 5)));
		assertEquals(true, board.move(new Location(0, 0), new Location(0, 2)));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 -- WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP WP \n"
				   + "3 WR -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- BP -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		assertEquals(true, board.move(new Location(7, 6), new Location(7, 4)));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 -- WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP WP \n"
				   + "3 WR -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- BP \n"
				   + "6 -- -- -- BP -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		assertEquals(true, board.move(new Location(0, 2), new Location(7, 2)));
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 4)));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				+ "1 -- WN WB WQ WK WB WN WR \n"
				+ "2 -- WP WP WP WP WP WP WP \n"
				+ "3 -- -- -- -- -- -- -- WR \n"
				+ "4 WP -- -- -- -- -- -- -- \n"
				+ "5 -- -- -- -- BP -- -- BP \n"
				+ "6 -- -- -- BP -- -- -- -- \n"
				+ "7 BP BP BP -- -- BP BP -- \n"
				+ "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		assertEquals(true, board.move(new Location(7, 2), new Location(7, 4)));
		board.getPiece(new Location(7, 7)).validMoves(board);
		assertEquals(false, board.getPiece(new Location(7, 7)).possibleMovesDependingOnBoard.isEmpty());
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 -- WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- BP -- -- WR \n"
				   + "6 -- -- -- BP -- -- -- -- \n"
				   + "7 BP BP BP -- -- BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingRooksTakingPieces() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(0, 1), new Location(0, 3)));
		assertEquals(true, board.move(new Location(7, 6), new Location(7, 4)));
		assertEquals(true, board.move(new Location(0, 3), new Location(0, 4)));
		assertEquals(true, board.move(new Location(7, 4), new Location(7, 3)));
		assertEquals(true, board.move(new Location(0, 4), new Location(0, 5)));
		assertEquals(true, board.move(new Location(7, 3), new Location(7, 2)));
		assertEquals(true, board.move(new Location(6, 1), new Location(7, 2)));
		assertEquals(true, board.move(new Location(1, 6), new Location(0, 5)));
		assertEquals(true, board.move(new Location(0, 0), new Location(0, 5)));
		assertEquals(true, board.move(new Location(7, 7), new Location(7, 2)));
		assertEquals(true, board.move(new Location(0, 5), new Location(0, 6)));
		assertEquals(true, board.move(new Location(7, 2), new Location(7, 1)));
		assertEquals(true, board.move(new Location(0, 6), new Location(0, 7)));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 -- WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP -- BR \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- -- BP BP BP BP BP -- \n"
				   + "8 WR BN BB BQ BK BB BN -- \n",
				board.toString());
		
		assertEquals(true, board.move(new Location(7, 1), new Location(7, 0)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 -- WN WB WQ WK WB WN BR \n"
				   + "2 -- WP WP WP WP WP -- -- \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- -- BP BP BP BP BP -- \n"
				   + "8 WR BN BB BQ BK BB BN -- \n",
				board.toString());
	}
	

}
