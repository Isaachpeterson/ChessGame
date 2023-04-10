package main.java.com.isaacpeterson.chessgame.model.pieces;

import main.java.com.isaacpeterson.chessgame.model.Board;
import main.java.com.isaacpeterson.chessgame.model.ChessPiece;
import main.java.com.isaacpeterson.chessgame.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {
    @Override
    public List<Position> getPossibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int[][] directions = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int[] direction : directions) {
            Position newPosition = new Position(position.getRow() + direction[0], position.getColumn() + direction[1]);
            while (board.isPositionValid(newPosition) && board.getPieceAt(newPosition) == null) {
                moves.add(new Position(newPosition.getRow(), newPosition.getColumn()));
                newPosition.setRow(newPosition.getRow() + direction[0]);
                newPosition.setColumn(newPosition.getColumn() + direction[1]);
            }

            if (board.isPositionValid(newPosition) && board.getPieceAt(newPosition).getColor() != this.color) {
                moves.add(new Position(newPosition.getRow(), newPosition.getColumn()));
            }
        }

        return moves;
    }
}
