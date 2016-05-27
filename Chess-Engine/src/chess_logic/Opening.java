package chess_logic;

import javax.swing.border.EmptyBorder;

import chess_parts.Piece;
import chess_parts.chess_pieces.Bishop;
import chess_parts.chess_pieces.Empty;
import chess_parts.chess_pieces.King;
import chess_parts.chess_pieces.Knight;
import chess_parts.chess_pieces.Pawn;
import chess_parts.chess_pieces.Queen;
import chess_parts.chess_pieces.Rook;

public class Opening {

	public static Piece[][] setupNewBoard(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			board[6][i] = new Pawn(Color.BLACK, new Position(i + 1, 6 + 1));
		}

		for (int i = 0; i < board.length; i++) {
			board[1][i] = new Pawn(Color.WHITE, new Position(i + 1, 1 + 1));
		}

		board[7][0] = new Rook(Color.BLACK, new Position(0 + 1, 7 + 1));
		board[7][7] = new Rook(Color.BLACK, new Position(7 + 1, 7 + 1));

		board[0][0] = new Rook(Color.WHITE, new Position(0 + 1, 0 + 1));
		board[0][7] = new Rook(Color.WHITE, new Position(7 + 1, 0 + 1));

		board[7][1] = new Knight(Color.BLACK, new Position(1 + 1, 7 + 1));
		board[7][6] = new Knight(Color.BLACK, new Position(6 + 1, 7 + 1));

		board[0][1] = new Knight(Color.WHITE, new Position(1 + 1, 0 + 1));
		board[0][6] = new Knight(Color.WHITE, new Position(6 + 1, 0 + 1));

		board[7][2] = new Bishop(Color.BLACK, new Position(2 + 1, 7 + 1));
		board[7][5] = new Bishop(Color.BLACK, new Position(5 + 1, 7 + 1));

		board[0][2] = new Bishop(Color.BLACK, new Position(2 + 1, 0 + 1));
		board[0][5] = new Bishop(Color.BLACK, new Position(5 + 1, 0 + 1));

		board[7][3] = new Queen(Color.BLACK, new Position(3 + 1, 7 + 1));
		board[0][3] = new Queen(Color.WHITE, new Position(3 + 1, 0 + 1));

		board[7][4] = new King(Color.BLACK, new Position(4 + 1, 7 + 1));
		board[0][4] = new King(Color.WHITE, new Position(4 + 1, 0 + 1));

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null) {
					board[i][j] = new Empty(new Position(i + 1, j + 1));
				}
			}
		}

		return board;
	}

	public static String convertColToLetter(int col) {
		switch (col) {
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		default:
			return "X";
		}
	}

}
