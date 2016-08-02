package test_cases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess_logic.Location;
import chess_parts.Board;

public class BishopTests {

    @Test
    public void testingAll4() {
        Board board = new Board();
        assertTrue(board.move(new Location(3, 1), new Location(3, 3)));
        assertTrue(board.move(new Location(3, 6), new Location(3, 4)));
        assertTrue(board.move(new Location(4, 1), new Location(4, 3)));
        assertTrue(board.move(new Location(4, 6), new Location(4, 4)));
        assertTrue(board.move(new Location(5, 0), new Location(4, 1)));
        assertTrue(board.move(new Location(2, 7), new Location(3, 6)));
        assertTrue(board.move(new Location(4, 1), new Location(7, 4)));
        assertTrue(board.move(new Location(3, 6), new Location(7, 2)));
    }
    
    @Test
    public void testCantJumpOwnPieces() {
        Board board = new Board();
        assertTrue(board.move(new Location(3, 1), new Location(3, 3)));
        assertTrue(board.move(new Location(3, 6), new Location(3, 4)));
        assertTrue(board.move(new Location(4, 1), new Location(4, 3)));
        assertTrue(board.move(new Location(4, 6), new Location(4, 4)));
        assertFalse(board.move(new Location(5, 0), new Location(7, 2)));
        System.out.println(board);
    }

}
