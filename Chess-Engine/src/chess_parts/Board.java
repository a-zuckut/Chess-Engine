package chess_parts;

import chess_logic.Move;
import chess_logic.Opening;
import chess_logic.Position;

public class Board {

	private Piece[][] board;

	boolean init = false;

	public Board() {
		board = new Piece[8][8];
		if (!init) {
			Opening.setupNewBoard(board);
			init = true;
		}
	}

	public void move(Position pos, Move move) {

		
		
	}

	public String toString() {
		String output = Opening.convertColToLetter(-1) + " ";
		for (int i = 0; i < board.length + 1; i++) {
			if (i > 0)
				output += (i) + " ";
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0)
					output += Opening.convertColToLetter(j + 1) + "  ";
				else
					output += board[i - 1][j].abrev() + " ";
			}
			output += "\n";
		}
		return output;
	}

	public Piece[][] getBoard() {
		return board;
	}

}
