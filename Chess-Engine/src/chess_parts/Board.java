package chess_parts;

import chess_logic.Color;
import chess_logic.Location;
import chess_logic.OpeningAndHelpers;
import chess_parts.chess_pieces.Empty;

public class Board {

	/**
	 * Row, Col
	 */
	private Piece[][] board;
	private Color turn = Color.WHITE;

	boolean init = false;

	public Board() {
		board = new Piece[8][8];
		if (!init) {
			OpeningAndHelpers.setupNewBoard(board);
			init = true;
		}
	}

	public boolean move(Location current_pos, Location final_pos) {
		if(board[current_pos.getY()][current_pos.getX()].color != turn) { // Turn Error
			return false;
		}
		
		board[current_pos.getY()][current_pos.getX()].validMoves(this);
		boolean isValid = board[current_pos.getY()][current_pos.getX()].validMove(final_pos, turn);

		if (isValid) {
			board[final_pos.getY()][final_pos.getX()] = board[current_pos.getY()][current_pos.getX()];
			board[current_pos.getY()][current_pos.getX()] = new Empty();
			turn = Color.next(turn);
			return isValid;
		} else {
			return isValid;
		}
	}

	public Piece getPiece(Location pos) {
		return board[pos.getY()][pos.getX()];
	}

	public String toString() {
		String output = OpeningAndHelpers.convertColToLetter(-1) + " ";
		for (int i = 0; i < board.length + 1; i++) {
			if (i > 0)
				output += (i) + " ";
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0)
					output += OpeningAndHelpers.convertColToLetter(j) + "  ";
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
