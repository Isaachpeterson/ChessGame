package main.java.com.isaacpeterson.chessgame.model;

import main.java.com.isaacpeterson.chessgame.model.ChessPiece.PieceColor;

public class Board {
    private ChessPiece[][] board;
    private Move lastMove;

    public Board() {
        board = new ChessPiece[8][8];
        // Need to initialize pieces in starting positions here.
    }

    public ChessPiece getPieceAt(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    public void setPieceAt(Position position, ChessPiece piece) {
        board[position.getRow()][position.getColumn()] = piece;
    }

    public boolean isPositionValid(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }

    public boolean isPathClear(Position start, Position end) {
        // Check if the path between the start and end positions is clear.
    }

    public boolean movePiece(Position start, Position end) {
        // Method implementation
    }

    public Move getLastMove() {
        return lastMove;
    }

    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }

    boolean hasLegalMoves(PieceColor color) {
        // Method implementation
    }

    Position findKingPosition(PieceColor color) {
        // Method implementation
    }
}