package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Rook extends Piece {

	public Rook(Color color, Location position) {
		super(color, position, PieceTypes.Rook);
	}

	@Override
	public String setPiece() {
		return type.toString();
	}
	
	@Override
	public ArrayList<Location> validMoves(Board board) {
		possibleMovesDependingOnBoard = new ArrayList<>();
		possibleGenericMoves();
		
		Piece[][] currBoard = board.getBoard();
		
		if(position.getX() < 7) {
			for(int i = this.position.getX() + 1; i < currBoard.length; i++) {
				if(currBoard[i][position.getY()].getPieceType() != PieceTypes.NULL && currBoard[i][position.getY()].getColor() != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY(), i));
					break; // You could take that piece, but no more on that diagonal. 
				} else {
					if(currBoard[i][position.getY()].getPieceType() == PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY(), i));
					} else { // Piece of the same color is in the way.
						break;
					}
				}
			}
		}
		
		if(position.getX() > 0) {
			for(int i = this.position.getX() - 1; i >= 0; i--) {
				if(currBoard[i][position.getY()].getPieceType() != PieceTypes.NULL && currBoard[i][position.getY()].getColor() != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY(), i));
					break; // You could take that piece, but no more on that diagonal. 
				} else {
					if(currBoard[i][position.getY()].getPieceType() == PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(position.getY(), i));
					} else { // Piece of the same color is in the way.
						break;
					}
				}
			}
		}
		
		if(position.getY() > 0) {
			for(int i = this.position.getY() - 1; i >= 0; i--) {
				if(currBoard[position.getX()][i].getPieceType() != PieceTypes.NULL && currBoard[position.getX()][i].getColor() != color) {
					possibleMovesDependingOnBoard.add(new Location(i, position.getX()));
					break; // You could take that piece, but no more on that diagonal. 
				} else {
					if(currBoard[position.getX()][i].getPieceType() == PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(i, position.getX()));
					} else { // Piece of the same color is in the way.
						break;
					}
				}
			}
		}
		
		if(position.getY() < 7) {
			for(int i = this.position.getY() + 1; i < currBoard[0].length; i++) {
				if(currBoard[position.getX()][i].getPieceType() != PieceTypes.NULL && currBoard[position.getX()][i].getColor() != color) {
					possibleMovesDependingOnBoard.add(new Location(i, position.getX()));
					break; // You could take that piece, but no more on that diagonal. 
				} else {
					if(currBoard[position.getX()][i].getPieceType() == PieceTypes.NULL) {
						possibleMovesDependingOnBoard.add(new Location(i, position.getX()));
					} else { // Piece of the same color is in the way.
						break;
					}
				}
			}
		}
//		System.out.println(this + " /// " + possibleMovesDependingOnBoard);
		return possibleMovesDependingOnBoard;
	}

	@Override
	public boolean validMove(Location move, Color turn) {
		return possibleMovesDependingOnBoard.contains(move);
	}
	
	@Override
	public ArrayList<Location> possibleGenericMoves() {
		possibleGenericMoves = new ArrayList<>();
		
		for(int x = 0; x < 8; x++) {
			if(x != this.position.getX()) {
				possibleGenericMoves.add(new Location(x, position.getY()));
			}
			if(x != this.position.getY()) {
				possibleGenericMoves.add(new Location(this.position.getX(), x));
			}
		}
		return possibleGenericMoves;
	}
	
}
