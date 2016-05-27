package test_cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess_logic.Color;
import chess_logic.Move;

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
		Move move = new Move("A", 1);
		assertEquals("A", move.getColumn());
		assertEquals(1, move.getRow());
		
		assertEquals(true, move.validCol());
		assertEquals(true, move.validRow());
	}
	
	@Test
	public void InvalidMoveTest() {
		Move move = new Move("Z", 10);
		assertEquals("Z", move.getColumn());
		assertEquals(10, move.getRow());
		
		assertEquals(false, move.validCol());
		assertEquals(false, move.validRow());
	}
	
	@Test
	public void ValidColInvalidRowMoveTest() {
		Move move = new Move("A", 10);
		assertEquals("A", move.getColumn());
		assertEquals(10, move.getRow());
		
		assertEquals(true, move.validCol());
		assertEquals(false, move.validRow());
	}
	
	@Test
	public void InvalidColValidRowMoveTest() {
		Move move = new Move("Z", 1);
		assertEquals("Z", move.getColumn());
		assertEquals(1, move.getRow());
		
		assertEquals(false, move.validCol());
		assertEquals(true, move.validRow());
	}
	
	

}
