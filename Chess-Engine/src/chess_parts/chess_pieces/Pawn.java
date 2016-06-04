package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Pawn extends Piece {

	public Pawn(Color color, Location position) {
		super(color, position, PieceTypes.Pawn);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}

	@Override
	public ArrayList<Location> validMoves(Board board) {
		possibleMovesDependingOnBoard = new ArrayList<>();

		possibleGenericMoves();
		Piece[][] currentBoard = board.getBoard();
		if (color == Color.WHITE) {
			if (currentBoard[position.getX() + 1][position.getY()].getPieceType() == PieceTypes.NULL) {
				possibleMovesDependingOnBoard.add(new Location(position.getY(), position.getX() + 1));
				if (position.getX() == 1
						&& currentBoard[position.getX() + 2][position.getY()].getPieceType() == PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY(), position.getX() + 2));
				}
			}
			
			// Check if possible to take pieces
			if (position.getY() > 0 && position.getY() < 7 && position.getX() < 7 && position.getX() > 0) {
				if (currentBoard[position.getX() + 1][position.getY() + 1].getPieceType() != PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() + 1));
				}
				if (currentBoard[position.getX() + 1][position.getY() - 1].getPieceType() != PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() + 1));
				}
			} else {
				if (position.getY() < 7) {
					if (currentBoard[position.getX() + 1][position.getY() + 1].getPieceType() != PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() + 1));
					}
				} else { // must be at position 7 (H)
					if (currentBoard[position.getX() + 1][position.getY() - 1].getPieceType() != PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() + 1));
					}
				}
			}
			
		}

		if (color == Color.BLACK) {
			// Simple Advances are possible
			if (currentBoard[position.getX() - 1][position.getY()].getPieceType() == PieceTypes.NULL) {
				possibleMovesDependingOnBoard.add(new Location(position.getY(), position.getX() - 1));
				if (position.getX() == 6
						&& currentBoard[position.getX() - 2][position.getY()].getPieceType() == PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY(), position.getX() - 2));
				}
			}
			// Taking Pieces
			if (position.getY() > 0 && position.getY() < 7 && position.getX() < 7 && position.getX() > 0) {
				if (currentBoard[position.getX() - 1][position.getY() - 1].getPieceType() != PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() - 1));
				}
				if (currentBoard[position.getX() - 1][position.getY() + 1].getPieceType() != PieceTypes.NULL) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() - 1));
				}
			} else {
				if (position.getY() > 0) {
					if (currentBoard[position.getX() - 1][position.getY() - 1].getPieceType() != PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() - 1));
					}
				} else { // must be at position 0 (H)
					if (currentBoard[position.getX() - 1][position.getY() + 1].getPieceType() != PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() - 1));
					}
				}
			}
		}
//		System.out.println(board);
//		System.out.println(this + " " + possibleMovesDependingOnBoard + "\n");
		return possibleMovesDependingOnBoard;

	}

	@Override
	public ArrayList<Location> possibleGenericMoves() {
		possibleGenericMoves = new ArrayList<>(); // resets arraylist

		if (position.getX() == 1 && color == Color.WHITE) {
			possibleGenericMoves.add(new Location(position.getX(), position.getY() + 1));
			possibleGenericMoves.add(new Location(position.getX(), position.getY() + 2));
		} else if (position.getX() == 6 && color == Color.BLACK) {
			possibleGenericMoves.add(new Location(position.getX(), position.getY() - 1));
			possibleGenericMoves.add(new Location(position.getX(), position.getY() - 2));
		} else if (color == Color.WHITE) {
			possibleGenericMoves.add(new Location(position.getX(), position.getY() + 1));
		} else /* then color is black and not on first rank */ {
			possibleGenericMoves.add(new Location(position.getX(), position.getY() + 1));
		}

		return possibleGenericMoves;
	}

	@Override
	public boolean validMove(Location move, Color turn) {
		return possibleMovesDependingOnBoard.contains(move);
	}

}
