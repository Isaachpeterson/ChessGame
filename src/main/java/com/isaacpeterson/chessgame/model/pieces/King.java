package main.java.com.isaacpeterson.chessgame.model.pieces;

import main.java.com.isaacpeterson.chessgame.model.Board;
import main.java.com.isaacpeterson.chessgame.model.ChessPiece;
import main.java.com.isaacpeterson.chessgame.model.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
    @Override
    public List<Position> getPossibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int[][] offsets = {
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
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

        // Still needs castling logic.

        return moves;
    }
}
