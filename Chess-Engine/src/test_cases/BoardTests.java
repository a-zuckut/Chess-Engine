package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_parts.Board;

public class BoardTests {

	@Test
	public void implementationBoardTests() {
		Board board = new Board();
		assertEquals(
				  "X A  B  C  D  E  F  G  H  \n"
				+ "1 WR WN BB WQ WK BB WN WR \n"
				+ "2 WP WP WP WP WP WP WP WP \n"
				+ "3 -- -- -- -- -- -- -- -- \n"
				+ "4 -- -- -- -- -- -- -- -- \n"
				+ "5 -- -- -- -- -- -- -- -- \n"
				+ "6 -- -- -- -- -- -- -- -- \n"
				+ "7 BP BP BP BP BP BP BP BP \n"
				+ "8 BR BN BB BQ BK BB BN BR \n",
				board.toString());
		
		
	}

}
