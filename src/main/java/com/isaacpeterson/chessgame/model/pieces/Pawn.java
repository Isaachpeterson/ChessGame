package main.java.com.isaacpeterson.chessgame.model.pieces;

import main.java.com.isaacpeterson.chessgame.model.Board;
import main.java.com.isaacpeterson.chessgame.model.ChessPiece;
import main.java.com.isaacpeterson.chessgame.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece {
    @Override
    public List<Position> getPossibleMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int direction = (color == PieceColor.WHITE) ? -1 : 1;
        Position forward = new Position(position.getRow() + direction, position.getColumn());
        Position doubleForward = new Position(position.getRow() + 2 * direction, position.getColumn());
        Position[] captureMoves = {
                new Position(position.getRow() + direction, position.getColumn() - 1),
                new Position(position.getRow() + direction, position.getColumn() + 1)
        };

        if (board.isPositionValid(forward) && board.getPieceAt(forward) == null) {
            moves.add(new Position(forward.getRow(), forward.getColumn()));

            // Check for a double forward move for pawns on their starting positions.
            if ((color == PieceColor.WHITE && position.getRow() == 6)
                    || (color == PieceColor.BLACK && position.getRow() == 1)) {
                if (board.isPositionValid(doubleForward) && board.getPieceAt(doubleForward) == null) {
                    moves.add(new Position(doubleForward.getRow(), doubleForward.getColumn()));
                }
            }
        }

        for (Position captureMove : captureMoves) {
            if (board.isPositionValid(captureMove)) {
                ChessPiece targetPiece = board.getPieceAt(captureMove);
                if (targetPiece != null && targetPiece.getColor() != color) {
                    moves.add(new Position(captureMove.getRow(), captureMove.getColumn()));
                }
            }
        }

        // still needs en passant logic.

        return moves;
    }
}
