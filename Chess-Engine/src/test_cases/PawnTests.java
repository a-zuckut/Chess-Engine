package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Location;
import chess_parts.Board;

public class PawnTests {

	/**
	 * Simple Opening D2 -> D4
	 */
	@Test
	public void testDoubleAdvance_D_PawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location move = new Location(3, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("D2", pos.toString());
		assertEquals("D4", move.toString());
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
		assertEquals("A2", pos.toString());
		assertEquals("A4", move.toString());
		assertEquals(true, board.move(pos, move));

		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testDoubleAdvance_H_PawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(7, 1);
		Location move = new Location(7, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("H2", pos.toString());
		assertEquals("H4", move.toString());
		assertEquals(true, board.move(pos, move));

		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP WP WP WP WP -- \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- WP \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testDoubleAdvance_F_PawnsSucceed() {
		Board board = new Board();
		Location pos = new Location(5, 1);
		Location move = new Location(5, 3);
		assertEquals("WP", board.getPiece(pos).abrev());
		assertEquals("F2", pos.toString());
		assertEquals("F4", move.toString());
		assertEquals(true, board.move(pos, move));

		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP WP WP -- WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- WP -- -- \n"
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
		assertEquals("D2", pos.toString());
		assertEquals("D5", move.toString());
		assertEquals(false, board.move(pos, move));
	}

	@Test
	public void testWrongTurnError() {
		Board board = new Board();
		Location pos = new Location(3, 1); // D2
		Location pos1 = new Location(4, 1); // E2
		assertEquals("D2", pos.toString());
		assertEquals("E2", pos1.toString());
		Location move = new Location(3, 2); // D3
		Location move1 = new Location(4, 3); // E4
		assertEquals("D3", move.toString());
		assertEquals("E4", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(false, board.move(pos1, move1));
		
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
	
	@Test
	public void testing_D4_D5_Opening() {
		Board board = new Board();
		Location pos = new Location(3, 1); // D2 for white
		Location pos1 = new Location(3, 6); // D7 for black
		assertEquals("D2", pos.toString());
		assertEquals("D7", pos1.toString());
		Location move = new Location(3, 3); // D4 for white
		Location move1 = new Location(3, 4); // D5 for black
		assertEquals("D4", move.toString());
		assertEquals("D5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- WP -- -- -- -- \n"
				   + "5 -- -- -- BP -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testing_G4_G5_Opening() {
		Board board = new Board();
		Location pos = new Location(6, 1);
		Location pos1 = new Location(6, 6);
		assertEquals("G2", pos.toString());
		assertEquals("G7", pos1.toString());
		Location move = new Location(6, 3);
		Location move1 = new Location(6, 4);
		assertEquals("G4", move.toString());
		assertEquals("G5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP WP WP WP -- WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- WP -- \n"
				   + "5 -- -- -- -- -- -- BP -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingIllegalBlackOpeningError() {
		Board board = new Board();
		Location pos = new Location(3, 6); // D7 for white
		Location move = new Location(3, 4); // D5 for white
		assertEquals("D7", pos.toString());
		assertEquals("D5", move.toString());
		assertEquals(false, board.move(pos, move));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP WP WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}

	@Test
	public void testing_3_Move_Opening() {
		Board board = new Board();
		Location pos0 = new Location(3, 1);
		Location pos1 = new Location(3, 6);
		Location pos2 = new Location(4, 1);
		assertEquals("D2", pos0.toString());
		assertEquals("D7", pos1.toString());
		assertEquals("E2", pos2.toString());
		Location move0 = new Location(3, 3);
		Location move1 = new Location(3, 4);
		Location move2 = new Location(4, 2);
		assertEquals("D4", move0.toString());
		assertEquals("D5", move1.toString());
		assertEquals("E3", move2.toString());
		assertEquals(true, board.move(pos0, move0));
		assertEquals(true, board.move(pos1, move1));
		assertEquals(true, board.move(pos2, move2));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- -- WP WP WP \n"
				   + "3 -- -- -- -- WP -- -- -- \n"
				   + "4 -- -- -- WP -- -- -- -- \n"
				   + "5 -- -- -- BP -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingCannotGoForwardToTakePiece() {
		Board board = new Board();
		Location pos0 = new Location(3, 1);
		Location pos1 = new Location(3, 6);
		Location pos2 = new Location(3, 3);
		assertEquals("D2", pos0.toString());
		assertEquals("D7", pos1.toString());
		assertEquals("D4", pos2.toString());
		Location move0 = new Location(3, 3);
		Location move1 = new Location(3, 4);
		Location move2 = new Location(3, 4);
		assertEquals("D4", move0.toString());
		assertEquals("D5", move1.toString());
		assertEquals("D5", move2.toString());
		assertEquals(true, board.move(pos0, move0));
		assertEquals(true, board.move(pos1, move1));
		assertEquals(false, board.move(pos2, move2));
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- WP -- -- -- -- \n"
				   + "5 -- -- -- BP -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingAllPossiblePawnStarts() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 2))); // w
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 5))); // b
		assertEquals(true, board.move(new Location(4, 1), new Location(4, 3))); // w
		assertEquals(true, board.move(new Location(3, 6), new Location(3, 4))); // b
		assertEquals(true, board.move(new Location(2, 1), new Location(2, 3))); // w
		assertEquals(true, board.move(new Location(6, 6), new Location(6, 4))); // b
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP -- -- -- WP WP WP \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 -- -- WP -- WP -- -- -- \n"
				   + "5 -- -- -- BP -- -- BP -- \n"
				   + "6 -- -- -- -- BP -- -- -- \n"
				   + "7 BP BP BP -- -- BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		assertEquals(true, board.move(new Location(7, 1), new Location(7, 2))); // w h2 -> h3
		assertEquals(true, board.move(new Location(0, 6), new Location(0, 4))); // b
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP -- -- -- WP WP -- \n"
				   + "3 -- -- -- WP -- -- -- WP \n"
				   + "4 -- -- WP -- WP -- -- -- \n"
				   + "5 BP -- -- BP -- -- BP -- \n"
				   + "6 -- -- -- -- BP -- -- -- \n"
				   + "7 -- BP BP -- -- BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingTakingPieceLeftCenterWhite() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location pos1 = new Location(4, 6);
		assertEquals("D2", pos.toString());
		assertEquals("E7", pos1.toString());
		Location move = new Location(3, 3);
		Location move1 = new Location(4, 4);
		assertEquals("D4", move.toString());
		assertEquals("E5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		Location pos2 = new Location(3, 3);
		Location move2 = new Location(4, 4);
		
		assertEquals("D4", pos2.toString());
		assertEquals("E5", move2.toString());
		
		assertEquals(true, board.move(pos2, move2));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- WP -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP -- BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingTakingPieceRightCenterWhite() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location pos1 = new Location(2, 6);
		assertEquals("D2", pos.toString());
		assertEquals("C7", pos1.toString());
		Location move = new Location(3, 3);
		Location move1 = new Location(2, 4);
		assertEquals("D4", move.toString());
		assertEquals("C5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		Location pos2 = new Location(3, 3);
		Location move2 = new Location(2, 4);
		
		assertEquals("D4", pos2.toString());
		assertEquals("C5", move2.toString());
		
		assertEquals(true, board.move(pos2, move2));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- WP -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP -- BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingInvalidBlackCaptures() {
		Board board = new Board();
		Location pos = new Location(3, 1);
		Location pos1 = new Location(2, 6);
		assertEquals("D2", pos.toString());
		assertEquals("C7", pos1.toString());
		Location move = new Location(3, 3);
		Location move1 = new Location(3, 5);
		assertEquals("D4", move.toString());
		assertEquals("D6", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(false, board.move(pos1, move1));
		
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
	
	@Test
	public void testingValidCapturesOnBAndGFiles() {
		Board board = new Board();
		Location pos = new Location(1, 1);
		Location test = new Location(1, 2);
		assertEquals("B3", test.toString());
		assertEquals("N - at B3", board.getPiece(test).toString());
		Location pos1 = new Location(0, 6);
		assertEquals("B2", pos.toString());
		assertEquals("A7", pos1.toString());
		Location move = new Location(1, 3);
		Location move1 = new Location(0, 4);
		assertEquals("B4", move.toString());
		assertEquals("A5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP WP WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- WP -- -- -- -- -- -- \n"
				   + "5 BP -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		pos = new Location(6, 1);
		pos1 = new Location(7, 6);
		assertEquals("G2", pos.toString());
		assertEquals("H7", pos1.toString());
		move = new Location(6, 3);
		move1 = new Location(7, 4);
		assertEquals("G4", move.toString());
		assertEquals("H5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP WP WP WP -- WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- WP -- -- -- -- WP -- \n"
				   + "5 BP -- -- -- -- -- -- BP \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP BP BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		Location pos2 = new Location(1, 3);
		Location move2 = new Location(0, 4);
		assertEquals("B4", pos2.toString());
		assertEquals("A5", move2.toString()); 
		assertEquals(true, board.move(pos2, move2));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP WP WP WP -- WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- WP -- \n"
				   + "5 WP -- -- -- -- -- -- BP \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP BP BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 4))); // e7 -> e5
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP WP WP WP -- WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- WP -- \n"
				   + "5 WP -- -- -- BP -- -- BP \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP -- BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		assertEquals(true, board.move(new Location(6, 3), new Location(7, 4)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP WP WP WP -- WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 WP -- -- -- BP -- -- WP \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP -- BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingEdgeCapturesAAndHFiles() {
		Board board = new Board();
		Location pos = new Location(0, 1);
		Location pos1 = new Location(1, 6);
		assertEquals("A2", pos.toString());
		assertEquals("B7", pos1.toString());
		Location move = new Location(0, 3);
		Location move1 = new Location(1, 4);
		assertEquals("A4", move.toString());
		assertEquals("B5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- -- \n"
				   + "5 -- BP -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP -- BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		pos = new Location(7, 1);
		pos1 = new Location(6, 6);
		assertEquals("H2", pos.toString());
		assertEquals("G7", pos1.toString());
		move = new Location(7, 3);
		move1 = new Location(6, 4);
		assertEquals("H4", move.toString());
		assertEquals("G5", move1.toString());
		assertEquals(true, board.move(pos, move));
		assertEquals(true, board.move(pos1, move1));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP -- \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 WP -- -- -- -- -- -- WP \n"
				   + "5 -- BP -- -- -- -- BP -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP -- BP BP BP BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		Location pos2 = new Location(0, 3);
		Location move2 = new Location(1, 4);
		assertEquals("A4", pos2.toString());
		assertEquals("B5", move2.toString()); 
		assertEquals(true, board.move(pos2, move2));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP -- \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- WP \n"
				   + "5 -- WP -- -- -- -- BP -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP -- BP BP BP BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 4))); // e7 -> e5
		assertEquals(true, board.move(new Location(7, 3), new Location(6, 4)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP WP WP WP WP -- \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- WP -- -- BP -- WP -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP -- BP BP -- BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
	}
	
	@Test
	public void testingBlackCaptureD4() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 3)));
		assertEquals(true, board.move(new Location(3, 6), new Location(3, 4)));
		assertEquals(true, board.move(new Location(4, 1), new Location(4, 3)));
		assertEquals(true, board.move(new Location(3, 4), new Location(4, 3)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- -- WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- WP BP -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP -- BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingBlackCaptureB4() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(1, 1), new Location(1, 3)));
		assertEquals(true, board.move(new Location(0, 6), new Location(0, 4)));
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 2)));
		assertEquals(true, board.move(new Location(0, 4), new Location(1, 3)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP -- WP -- WP WP WP WP \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 -- BP -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 -- BP BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingBlackCaptureA4() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(0, 1), new Location(0, 3)));
		assertEquals(true, board.move(new Location(1, 6), new Location(1, 4)));
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 2)));
		assertEquals(true, board.move(new Location(1, 4), new Location(0, 3)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 -- WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 BP -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP -- BP BP BP BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingBlackCaptureH4() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(7, 1), new Location(7, 3)));
		assertEquals(true, board.move(new Location(6, 6), new Location(6, 4)));
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 2)));
		assertEquals(true, board.move(new Location(6, 4), new Location(7, 3)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP -- \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- BP \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP -- BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingBlackCaptureG4() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(6, 1), new Location(6, 3)));
		assertEquals(true, board.move(new Location(7, 6), new Location(7, 4)));
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 2)));
		assertEquals(true, board.move(new Location(7, 4), new Location(6, 3)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP -- WP \n"
				   + "3 -- -- -- WP -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- BP -- \n"
				   + "5 -- -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP BP BP BP -- \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
	@Test
	public void testingEnpassantWhite() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 3)));
		assertEquals(true, board.move(new Location(0, 6), new Location(0, 4)));
		assertEquals(true, board.move(new Location(3, 3), new Location(3, 4)));
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 4)));
		assertEquals(true, board.move(new Location(3, 4), new Location(4, 5)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP WP WP WP \n"
				   + "3 -- -- -- -- -- -- -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 BP -- -- -- -- -- -- -- \n"
				   + "6 -- -- -- -- WP -- -- -- \n"
				   + "7 -- BP BP BP -- BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
	}
	
	@Test
	public void testingEnpassantBlack() {
		Board board = new Board();
		assertEquals(true, board.move(new Location(3, 1), new Location(3, 3)));
		assertEquals(true, board.move(new Location(4, 6), new Location(4, 4)));
		assertEquals(true, board.move(new Location(3, 3), new Location(3, 4)));
		assertEquals(true, board.move(new Location(4, 4), new Location(4, 3)));
		assertEquals(true, board.move(new Location(5, 1), new Location(5, 3)));
		assertEquals(true, board.move(new Location(4, 3), new Location(5, 2)));
		
		assertEquals("X A  B  C  D  E  F  G  H  \n"
				   + "1 WR WN WB WQ WK WB WN WR \n"
				   + "2 WP WP WP -- WP -- WP WP \n"
				   + "3 -- -- -- -- -- BP -- -- \n"
				   + "4 -- -- -- -- -- -- -- -- \n"
				   + "5 -- -- -- WP -- -- -- -- \n"
				   + "6 -- -- -- -- -- -- -- -- \n"
				   + "7 BP BP BP BP -- BP BP BP \n"
				   + "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
	}
	
}
