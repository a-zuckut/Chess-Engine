package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_logic.Move;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Pawn extends Piece {
	
	public boolean enPassentPossible = false;
	public int enPassentNum = 0;

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
		enPassentPossible = false;
		enPassentNum = 0;
		
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
				if (currentBoard[position.getX() + 1][position.getY() + 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() + 1][position.getY() + 1].color != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() + 1));
				}
				if (currentBoard[position.getX() + 1][position.getY() - 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() + 1][position.getY() - 1].color != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() + 1));
				}
			} else {
				if (position.getY() < 7) {
					if (currentBoard[position.getX() + 1][position.getY() + 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() + 1][position.getY() + 1].color != color) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() + 1));
					}
				} else { // must be at position 7 (H)
					if (currentBoard[position.getX() + 1][position.getY() - 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() + 1][position.getY() - 1].color != color) {
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
				if (currentBoard[position.getX() - 1][position.getY() - 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() - 1][position.getY() - 1].color != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() - 1));
				}
				if (currentBoard[position.getX() - 1][position.getY() + 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() - 1][position.getY() + 1].color != color) {
					possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() - 1));
				}
			} else {
				if (position.getY() > 0) {
					if (currentBoard[position.getX() - 1][position.getY() - 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() - 1][position.getY() - 1].color != color) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() - 1));
					}
				} else { // must be at position 0 (H)
					if (currentBoard[position.getX() - 1][position.getY() + 1].getPieceType() != PieceTypes.NULL && currentBoard[position.getX() - 1][position.getY() + 1].color != color) {
						possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() - 1));
					}
				}
			}
		}
		
		// Enpassents
				ArrayList<Move> curr_moves = null;
				Move lastMove = null;
				if(!board.getMoves().isEmpty()) {
					curr_moves = board.getMoves();
					lastMove = curr_moves.get(curr_moves.size() - 1);
					if(color == Color.WHITE && position.getX() == 4 && lastMove.init().getY() - 1 == position.getY() + 2 && 
							lastMove.fin().getY() - 1 == position.getY()) {
						try{
							if(currentBoard[position.getX() + 1][position.getY() + 1].getPieceType() == PieceTypes.NULL &&
									currentBoard[position.getX()][position.getY() + 1].getPieceType() == PieceTypes.Pawn) {
								possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() + 1));
								enPassentPossible = true;
								enPassentNum++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
						}
						try{
							if(currentBoard[position.getX() + 1][position.getY() - 1].getPieceType() == PieceTypes.NULL &&
									currentBoard[position.getX()][position.getY() - 1].getPieceType() == PieceTypes.Pawn) {
								possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() + 1));
								enPassentPossible = true;
								enPassentNum++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
						}
					}
					
					if(color == Color.BLACK && position.getX() == 3 && lastMove.init().getY() + 1 == position.getY() - 2 && 
							lastMove.fin().getY() + 1 == position.getY()) {
						try{
							if(currentBoard[position.getX() - 1][position.getY() - 1].getPieceType() == PieceTypes.NULL &&
									currentBoard[position.getX()][position.getY() - 1].getPieceType() == PieceTypes.Pawn) {
								possibleMovesDependingOnBoard.add(new Location(position.getY() - 1, position.getX() - 1));
								enPassentPossible = true;
								enPassentNum++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
						}
						try{
							if(currentBoard[position.getX() - 1][position.getY() + 1].getPieceType() == PieceTypes.NULL &&
									currentBoard[position.getX()][position.getY() + 1].getPieceType() == PieceTypes.Pawn) {
								possibleMovesDependingOnBoard.add(new Location(position.getY() + 1, position.getX() - 1));
								enPassentPossible = true;
								enPassentNum++;
							}
						}catch(ArrayIndexOutOfBoundsException e){
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
			possibleGenericMoves.add(new Location(position.getX(), position.getY() + 1));
		}

		return possibleGenericMoves;
	}

	@Override
	public boolean validMove(Location move, Color turn) {
		return possibleMovesDependingOnBoard.contains(move);
	}

}
