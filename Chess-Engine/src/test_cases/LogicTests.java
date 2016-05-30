package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;

public class LogicTests {

	@Test
	public void ColorStringTests() {
		assertEquals("BLACK", Color.BLACK.toString());
		assertEquals("WHITE", Color.WHITE.toString());
		assertEquals("N", Color.NULL.toString());

		assertEquals("B", Color.BLACK.abrev());
		assertEquals("W", Color.WHITE.abrev());
		assertEquals("-", Color.NULL.abrev());
	}

	@Test
	public void ValidMoveTests() {
		Location move = new Location(0, 0);
		assertEquals(0, move.getX());
		assertEquals(0, move.getY());

		assertEquals(true, move.validCol());
		assertEquals(true, move.validRow());
	}

	@Test
	public void InvalidMoveTest() {
		Location move = new Location(26, 10);
		assertEquals(26, move.getX());
		assertEquals(10, move.getY());

		assertEquals(false, move.validCol());
		assertEquals(false, move.validRow());
	}

	@Test
	public void ValidColInvalidRowMoveTest() {
		Location move = new Location(0, 10);
		assertEquals(0, move.getX());
		assertEquals(10, move.getY());

		assertEquals(true, move.validCol());
		assertEquals(false, move.validRow());

		Location move2 = new Location(7, 8);
		assertEquals(true, move2.validCol());
		assertEquals(false, move2.validRow());
	}

	@Test
	public void InvalidColValidRowMoveTest() {
		Location move = new Location(26, 0);
		assertEquals(26, move.getX());
		assertEquals(0, move.getY());

		assertEquals(false, move.validCol());
		assertEquals(true, move.validRow());
	}

	@Test
	public void testingNamesOfLocation() {
		assertEquals("A1", new Location(0, 0).toString());
		assertEquals("B3", new Location(1, 2).toString());
		assertEquals("H1", new Location(7, 0).toString());
		assertEquals("H8", new Location(7, 7).toString());
		assertEquals("E2", new Location(4, 1).toString());
	}
	
	@Test
	public void testingUsingLocationsInBoard() {
		Board board = new Board();
		Location loc1 = new Location(0, 0);
		assertEquals("WR", board.getBoard()[loc1.getY()][loc1.getX()].abrev());
		
	}

}
