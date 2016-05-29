package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Location;
import chess_parts.Board;

public class GameTest {

	/**
	 * Simple Opening
	 */
	@Test
	public void testDoubleAdvancePawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location move = new Location(3, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("D2", pos.toString());
		assertEquals("D4", move.toString());
		assertEquals(true, board.move(pos, move));

		assertEquals(
				  "X A  B  C  D  E  F  G  H  \n"
				+ "1 WR WN WB WQ WK WB WN WR \n"
				+ "2 WP WP WP -- WP WP WP WP \n"
				+ "3 -- -- -- -- -- -- -- -- \n"
				+ "4 -- -- -- WP -- -- -- -- \n"
				+ "5 -- -- -- -- -- -- -- -- \n"
				+ "6 -- -- -- -- -- -- -- -- \n"
				+ "7 BP BP BP BP BP BP BP BP \n"
				+ "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		board = new Board();
		pos = new Location(4, 1); // e2
		move = new Location(4, 3); // e4
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("E2", pos.toString());
		assertEquals("E4", move.toString());
		assertEquals(true, board.move(pos, move));
	}
	
	/**
	 * Test case to see that you can't do improper pawn start
	 */
	@Test
	public void testInitalIllegalPawnAdvancesFail() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location move = new Location(3, 4);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("D2", pos.toString());
		assertEquals("D5", move.toString());
		assertEquals(false, board.move(pos, move));
	}
	
}
