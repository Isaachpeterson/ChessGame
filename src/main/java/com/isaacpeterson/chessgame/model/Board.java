package main.java.com.isaacpeterson.chessgame.model;

import main.java.com.isaacpeterson.chessgame.model.pieces.King;
import main.java.com.isaacpeterson.chessgame.model.pieces.Pawn;

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
        ChessPiece piece = getPieceAt(start);
        if (piece != null && piece.getPossibleMoves(this).contains(end)) {
            // Handle en passant capture
            if (piece instanceof Pawn && Math.abs(start.getRow() - end.getRow()) == 1
                    && Math.abs(start.getColumn() - end.getColumn()) == 1
                    && getPieceAt(end) == null) {
                setPieceAt(new Position(start.getRow(), end.getColumn()), null);
            }
            // Handle castling
            if (piece instanceof King && Math.abs(start.getColumn() - end.getColumn()) == 2) {
                int backRank = piece.getColor() == ChessPiece.PieceColor.WHITE ? 0 : 7;
                int rookStartColumn = end.getColumn() == 2 ? 0 : 7;
                int rookEndColumn = end.getColumn() == 2 ? 3 : 5;
                Position rookStart = new Position(backRank, rookStartColumn);
                Position rookEnd = new Position(backRank, rookEndColumn);
                ChessPiece rook = getPieceAt(rookStart);
                setPieceAt(rookEnd, rook);
                setPieceAt(rookStart, null);
            }

            // Move the piece and set it as moved
            setPieceAt(end, piece);
            setPieceAt(start, null);
            piece.setPosition(end);
            piece.setHasMoved(true);
            return true;
        }
        return false;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }
}