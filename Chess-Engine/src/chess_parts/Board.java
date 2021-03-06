package chess_parts;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_logic.Move;
import chess_logic.OpeningAndHelpers;
import chess_parts.chess_pieces.Empty;
import chess_parts.chess_pieces.Pawn;

public class Board {

	/**
	 * Row, Col
	 */
	private Piece[][] board;
	public Color turn = Color.WHITE;
	
	private ArrayList<Move> moves;

	boolean init = false;

	public Board() {
		moves = new ArrayList<>();
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
			board[final_pos.getY()][final_pos.getX()].updatePosition(final_pos);
			board[current_pos.getY()][current_pos.getX()] = new Empty();
			if(board[final_pos.getY()][final_pos.getX()].getPieceType() == PieceTypes.Pawn) {
				if(((Pawn)(board[final_pos.getY()][final_pos.getX()])).enPassentPossible) {
					for(int i = 0; i < ((Pawn)(board[final_pos.getY()][final_pos.getX()])).enPassentNum; i++) {
						if(board[final_pos.getY()][final_pos.getX()].possibleMovesDependingOnBoard.get(board[final_pos.getY()][final_pos.getX()]
								.possibleMovesDependingOnBoard.size() - i - 1).equals(final_pos)){
							if(Color.WHITE == turn) {
								board[current_pos.getY()][final_pos.getX()] = new Empty();
							}
							if(Color.BLACK == turn) {
								board[current_pos.getY()][final_pos.getX()] = new Empty();
							}
						}
					}
				}
			}
			turn = Color.next(turn);
			moves.add(new Move(current_pos, final_pos));
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
	
	public ArrayList<Move> getMoves() {
		return moves;
	}

}
