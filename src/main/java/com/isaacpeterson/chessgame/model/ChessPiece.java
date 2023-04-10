package main.java.com.isaacpeterson.chessgame.model;

import java.util.List;

public abstract class ChessPiece {
    protected Position position;
    protected PieceColor color;

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

    public PieceColor getColor() {
        return color;
    }

    public enum PieceColor {
        WHITE,
        BLACK
    }
}
