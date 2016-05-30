package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Location;
import chess_parts.Board;

public class GameTest {

	/**
	 * Simple Opening D2 -> D4
	 */
	@Test
	public void testDoubleAdvance_D_PawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location move = new Location(3, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("D2", pos.boardLocation());
		assertEquals("D4", move.boardLocation());
		assertEquals(true, board.move(pos, move));

		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- WP -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	/**
	 * Testing Pawns Opening A2 -> A4
	 */
	@Test
	public void testDoubleAdvance_A_PawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(0, 1);
		Location move = new Location(0, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("A2", pos.boardLocation());
		assertEquals("A4", move.boardLocation());
		assertEquals(true, board.move(pos, move));

		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- WP -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
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
		assertEquals("D2", pos.boardLocation());
		assertEquals("D5", move.boardLocation());
		assertEquals(false, board.move(pos, move));
	}

	@Test
	public void testWrongTurnError() {
		Board board = new Board();
		Location pos = new Location(3, 1); // D2
		Location pos1 = new Location(4, 1); // E2
		assertEquals("D2", pos.boardLocation());
		assertEquals("E2", pos1.boardLocation());
		Location move = new Location(3, 2); // D3
		Location move1 = new Location(4, 3); // E4
		assertEquals("D3", move.boardLocation());
		assertEquals("E4", move1.boardLocation());
		assertEquals(true, board.move(pos, move));
		assertEquals(false, board.move(pos1, pos));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}

}
