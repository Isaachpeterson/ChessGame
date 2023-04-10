package main.java.com.isaacpeterson.chessgame.model.pieces;

import main.java.com.isaacpeterson.chessgame.model.Board;
import main.java.com.isaacpeterson.chessgame.model.ChessPiece;
import main.java.com.isaacpeterson.chessgame.model.Position;

import java.util.List;
import java.util.ArrayList;

public class Knight extends ChessPiece {
    @Override
    public List<Position> getPossibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int[][] offsets = {
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };

        for (int[] offset : offsets) {
            Position newPosition = new Position(position.getRow() + offset[0], position.getColumn() + offset[1]);
            if (board.isPositionValid(newPosition)) {
                ChessPiece targetPiece = board.getPieceAt(newPosition);
                if (targetPiece == null || targetPiece.getColor() != this.color) {
                    moves.add(new Position(newPosition.getRow(), newPosition.getColumn()));
                }
            }
        }

        return moves;
    }
}
