package main.java.com.isaacpeterson.chessgame.model;

public class Board {
    private ChessPiece[][] board;

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
        // Move the piece from the start position to the end position if the move is legal.
    }
}