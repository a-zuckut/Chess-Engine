package chess_parts.chess_pieces;

import java.util.ArrayList;

import chess_logic.Color;
import chess_logic.Location;
import chess_parts.Board;
import chess_parts.Piece;
import chess_parts.PieceTypes;

public class Bishop extends Piece {

    public Bishop(Color color, Location position) {
        super(color, position, PieceTypes.Bishop);
    }

    @Override
    public String setPiece() {
        return type.toString();
    }

    /**
     * Adding possible moves to ArrayList possibleGenericMoves Then
     */
    @Override
    public ArrayList<Location> validMoves(Board board) {
        possibleMovesDependingOnBoard = new ArrayList<>();
        possibleGenericMoves();
        Piece[][] currBoard = board.getBoard();

        boolean NOT_POSPOS = false, NOT_POSNEG = false, NOT_NEGPOS = false, NOT_NEGNEG = false;
        for (int i = 1; i < 8; i++) {
            if (position.getX() + i < 8) {
                if (position.getY() + i < 8 && !NOT_POSPOS) {
                    int x = position.getX() + i, y = position.getY() + i;
                    if (currBoard[x][y].getPieceType() != PieceTypes.NULL && currBoard[x][y].getColor() != color) {
                        possibleMovesDependingOnBoard.add(new Location(y, x));
                        NOT_POSPOS = true;
                    } else {
                        if (currBoard[x][y].getPieceType() == PieceTypes.NULL) {
                            possibleMovesDependingOnBoard.add(new Location(y, x));
                        } else {
                            NOT_POSPOS = true;
                        }
                    }
                }

                if (position.getY() - i >= 0 && !NOT_POSNEG) {
                    int x = position.getX() + i, y = position.getY() - i;
                    if (currBoard[x][y].getPieceType() != PieceTypes.NULL && currBoard[x][y].getColor() != color) {
                        possibleMovesDependingOnBoard.add(new Location(y, x));
                        NOT_POSNEG = true;
                    } else {
                        if (currBoard[x][y].getPieceType() == PieceTypes.NULL) {
                            possibleMovesDependingOnBoard.add(new Location(y, x));
                        } else {
                            NOT_POSNEG = true;
                        }
                    }
                }
            }

            if (position.getX() - i >= 0) {
                if (position.getY() + i < 8 && !NOT_NEGPOS) {
                    int x = position.getX() - i, y = position.getY() + i;
                    if (currBoard[x][y].getPieceType() != PieceTypes.NULL && currBoard[x][y].getColor() != color) {
                        possibleMovesDependingOnBoard.add(new Location(y, x));
                        NOT_NEGPOS = true;
                    } else {
                        if (currBoard[x][y].getPieceType() == PieceTypes.NULL) {
                            possibleMovesDependingOnBoard.add(new Location(y, x));
                        } else {
                            NOT_NEGPOS = true;
                        }
                    }
                }

                if (position.getY() - i >= 0 && !NOT_NEGNEG) {
                    int x = position.getX() - i, y = position.getY() - i;
                    if (currBoard[x][y].getPieceType() != PieceTypes.NULL && currBoard[x][y].getColor() != color) {
                        possibleMovesDependingOnBoard.add(new Location(y, x));
                        NOT_NEGNEG = true;
                    } else {
                        if (currBoard[x][y].getPieceType() == PieceTypes.NULL) {
                            possibleMovesDependingOnBoard.add(new Location(y, x));
                        } else {
                            NOT_NEGNEG = true;
                        }
                    }
                }
            }

        }

        return possibleMovesDependingOnBoard;
    }

    @Override
    public ArrayList<Location> possibleGenericMoves() {
        possibleGenericMoves = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            if (position.getX() + i < 8) {
                if (position.getY() + i < 8) {
                    possibleGenericMoves.add(new Location(position.getY() + i, position.getX() + i));
                }

                if (position.getY() - i >= 0) {
                    possibleGenericMoves.add(new Location(position.getY() - i, position.getX() + i));
                }
            }

            if (position.getX() - i >= 0) {
                if (position.getY() + i < 8) {
                    possibleGenericMoves.add(new Location(position.getY() + i, position.getX() - i));
                }

                if (position.getY() - i >= 0) {
                    possibleGenericMoves.add(new Location(position.getY() - i, position.getX() - i));
                }
            }

        }

        return possibleGenericMoves;
    }

    @Override
    public boolean validMove(Location move, Color turn) {
        return possibleMovesDependingOnBoard.contains(move);
    }

}
