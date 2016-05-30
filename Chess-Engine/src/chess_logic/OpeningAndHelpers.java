package chess_logic;

import chess_parts.Piece;
import chess_parts.chess_pieces.Bishop;
import chess_parts.chess_pieces.Empty;
import chess_parts.chess_pieces.King;
import chess_parts.chess_pieces.Knight;
import chess_parts.chess_pieces.Pawn;
import chess_parts.chess_pieces.Queen;
import chess_parts.chess_pieces.Rook;

public class OpeningAndHelpers {

	public static Piece[][] setupNewBoard(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			board[6][i] = new Pawn(Color.BLACK, new Location(6, i));
		}

		for (int i = 0; i < board.length; i++) {
			board[1][i] = new Pawn(Color.WHITE, new Location(1, i));
		}

		board[7][0] = new Rook(Color.BLACK, new Location(7, 0));
		board[7][7] = new Rook(Color.BLACK, new Location(7, 7));

		board[0][0] = new Rook(Color.WHITE, new Location(0, 0));
		board[0][7] = new Rook(Color.WHITE, new Location(0, 7));

		board[7][1] = new Knight(Color.BLACK, new Location(7, 1));
		board[7][6] = new Knight(Color.BLACK, new Location(7, 6));

		board[0][1] = new Knight(Color.WHITE, new Location(0, 1));
		board[0][6] = new Knight(Color.WHITE, new Location(0, 6));

		board[7][2] = new Bishop(Color.BLACK, new Location(7, 2));
		board[7][5] = new Bishop(Color.BLACK, new Location(7, 5));

		board[0][2] = new Bishop(Color.WHITE, new Location(0, 2));
		board[0][5] = new Bishop(Color.WHITE, new Location(0, 5));

		board[7][3] = new Queen(Color.BLACK, new Location(7, 3));
		board[0][3] = new Queen(Color.WHITE, new Location(0, 3));

		board[7][4] = new King(Color.BLACK, new Location(7, 4));
		board[0][4] = new King(Color.WHITE, new Location(0, 4));

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == null) {
					board[i][j] = new Empty(new Location(i, j));
				}
			}
		}

		return board;
	}

	public static String convertColToLetter(int col) {
		switch (col) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		default:
			return "X";
		}
	}

	public static Location handleEdgeOfBoardCases(Location move) {
		int row = move.getY();
		int col = move.getX();
		if (!move.validCol())
			if (move.getX() < 0)
				col = 0;
			else
				col = 7;
		if (!move.validRow())
			if (move.getY() < 0)
				row = 0;
			else
				row = 7;
		return new Location(col, row);
	}

}
