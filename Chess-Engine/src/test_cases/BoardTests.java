package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Location;
import chess_parts.Board;

public class BoardTests {

	@Test
	public void implementationBoardTests() {
		Board board = new Board();
		assertEquals(
				  "X A  B  C  D  E  F  G  H  \n"
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
	public void testingGetWhiteRook() {
		assertEquals("WR",new Board().getPiece(new Location(0, 0)).abrev());
		assertEquals("WR",new Board().getPiece(new Location(7, 0)).abrev());
	}
	
	@Test
	public void testingGetWhiteKnight() {
		assertEquals("WN",new Board().getPiece(new Location(1, 0)).abrev());
		assertEquals("WN",new Board().getPiece(new Location(6, 0)).abrev());
	}
	
	@Test
	public void testingGetWhiteBishop() {
		assertEquals("WB",new Board().getPiece(new Location(2, 0)).abrev());
		assertEquals("WB",new Board().getPiece(new Location(5, 0)).abrev());	
	}
	
	@Test
	public void testingGetWhiteKing() {
		assertEquals("WK",new Board().getPiece(new Location(4, 0)).abrev());
	}

	@Test
	public void testingGetWhiteQueen() {
		assertEquals("WQ",new Board().getPiece(new Location(3, 0)).abrev());
	}
	
	@Test
	public void testingGetWhitePawns() {
		assertEquals("WP",new Board().getPiece(new Location(0, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(1, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(2, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(3, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(4, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(5, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(6, 1)).abrev());
		assertEquals("WP",new Board().getPiece(new Location(7, 1)).abrev());
	}
	
	@Test
	public void testingGetBlackRook() {
		assertEquals("BR",new Board().getPiece(new Location(0, 7)).abrev());
		assertEquals("BR",new Board().getPiece(new Location(7, 7)).abrev());	
	}
	
	@Test
	public void testingGetBlackKnight() {
		assertEquals("BN",new Board().getPiece(new Location(1, 7)).abrev());
		assertEquals("BN",new Board().getPiece(new Location(6, 7)).abrev());	
	}
	
	@Test
	public void testingGetBlackBishop() {
		assertEquals("BB",new Board().getPiece(new Location(2, 7)).abrev());
		assertEquals("BB",new Board().getPiece(new Location(5, 7)).abrev());	
	}
	
	@Test
	public void testingGetBlackKing() {
		assertEquals("BK",new Board().getPiece(new Location(4, 7)).abrev());
	}

	@Test
	public void testingGetBlackQueen() {
		assertEquals("BQ",new Board().getPiece(new Location(3, 7)).abrev());
	}
	
	@Test
	public void testingGetBlackPawns() {
		assertEquals("BP",new Board().getPiece(new Location(0, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(1, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(2, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(3, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(4, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(5, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(6, 6)).abrev());
		assertEquals("BP",new Board().getPiece(new Location(7, 6)).abrev());
	}
	
	@Test
	public void testingEmptySpots() {
		assertEquals("--", new Board().getPiece(new Location(4, 4)).abrev());
		assertEquals("--", new Board().getPiece(new Location(2, 2)).abrev());
		assertEquals("--", new Board().getPiece(new Location(5, 3)).abrev());
		assertEquals("--", new Board().getPiece(new Location(0, 3)).abrev());
		assertEquals("--", new Board().getPiece(new Location(6, 2)).abrev());
	}
	
	@Test
	public void testingWhitePiecesOnCorrectSpots() {
		Board board = new Board();
		System.out.println(board.getBoard()[0][0]);
		assertEquals("WHITE Rook at A1", board.getBoard()[0][0].toString());
		assertEquals("WHITE Knight at B1", board.getBoard()[0][1].toString());
		assertEquals("WHITE Bishop at C1", board.getBoard()[0][2].toString());
		assertEquals("WHITE Queen at D1", board.getBoard()[0][3].toString());
		assertEquals("WHITE King at E1", board.getBoard()[0][4].toString());
		assertEquals("WHITE Bishop at F1", board.getBoard()[0][5].toString());
		assertEquals("WHITE Knight at G1", board.getBoard()[0][6].toString());
		assertEquals("WHITE Rook at H1", board.getBoard()[0][7].toString());
		
		assertEquals("WHITE Pawn at A2", board.getBoard()[1][0].toString());
		assertEquals("WHITE Pawn at B2", board.getBoard()[1][1].toString());
		assertEquals("WHITE Pawn at C2", board.getBoard()[1][2].toString());
		assertEquals("WHITE Pawn at D2", board.getBoard()[1][3].toString());
		assertEquals("WHITE Pawn at E2", board.getBoard()[1][4].toString());
		assertEquals("WHITE Pawn at F2", board.getBoard()[1][5].toString());
		assertEquals("WHITE Pawn at G2", board.getBoard()[1][6].toString());
		assertEquals("WHITE Pawn at H2", board.getBoard()[1][7].toString());
	}
	
	@Test
	public void testingBlackPiecesOnCorrectSpots() {
		Board board = new Board();
		System.out.println(board.getBoard()[0][0]);
		assertEquals("BLACK Rook at A8", board.getBoard()[7][0].toString());
		assertEquals("BLACK Knight at B8", board.getBoard()[7][1].toString());
		assertEquals("BLACK Bishop at C8", board.getBoard()[7][2].toString());
		assertEquals("BLACK Queen at D8", board.getBoard()[7][3].toString());
		assertEquals("BLACK King at E8", board.getBoard()[7][4].toString());
		assertEquals("BLACK Bishop at F8", board.getBoard()[7][5].toString());
		assertEquals("BLACK Knight at G8", board.getBoard()[7][6].toString());
		assertEquals("BLACK Rook at H8", board.getBoard()[7][7].toString());
		
		assertEquals("BLACK Pawn at A7", board.getBoard()[6][0].toString());
		assertEquals("BLACK Pawn at B7", board.getBoard()[6][1].toString());
		assertEquals("BLACK Pawn at C7", board.getBoard()[6][2].toString());
		assertEquals("BLACK Pawn at D7", board.getBoard()[6][3].toString());
		assertEquals("BLACK Pawn at E7", board.getBoard()[6][4].toString());
		assertEquals("BLACK Pawn at F7", board.getBoard()[6][5].toString());
		assertEquals("BLACK Pawn at G7", board.getBoard()[6][6].toString());
		assertEquals("BLACK Pawn at H7", board.getBoard()[6][7].toString());
	}

}
