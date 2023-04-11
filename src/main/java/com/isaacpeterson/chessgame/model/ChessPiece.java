package main.java.com.isaacpeterson.chessgame.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece {
    protected Position position;
    protected PieceColor color;
    protected boolean hasMoved;

    public ChessPiece(Position position, PieceColor color) {
        this.position = position;
        this.color = color;
    }

    public abstract List<Position> getPossibleMoves(Board board);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public PieceColor getColor() {
        return color;
    }

    public enum PieceColor {
        WHITE,
        BLACK
    }

    public List<Position> getLegalMoves(Board board) {
        List<Position> legalMoves = new ArrayList<>();
        List<Position> possibleMoves = getPossibleMoves(board);

        for (Position move : possibleMoves) {
            Board testBoard = board.clone();
            testBoard.movePiece(this.position, move);
            if (!testBoard.isInCheck(this.color)) {
                legalMoves.add(move);
            }
        }

        return legalMoves;
    }
}
