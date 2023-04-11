package main.java.com.isaacpeterson.chessgame.model;

import main.java.com.isaacpeterson.chessgame.model.ChessPiece.PieceColor;

public class Game {
    private Board board;
    private PieceColor currentPlayer;
    private boolean isCheck;
    private boolean isCheckmate;
    private boolean isStalemate;

    public Game() {
        board = new Board();
        currentPlayer = PieceColor.WHITE;
    }

    public boolean makeMove(Position start, Position end) {
        // Make a move and update the game state.
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
    }

    public boolean isInCheck(PieceColor color) {
        Position kingPosition = board.findKingPosition(color);
        if (kingPosition == null) {
            return false;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = board.getPieceAt(new Position(row, col));
                if (piece != null && piece.getColor() != color && piece.getPossibleMoves(board).contains(kingPosition)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCheckmate(PieceColor color) {
        return isInCheck(color) && !board.hasLegalMoves(color);
    }

    public boolean isStalemate(PieceColor color) {
        return !isInCheck(color) && !board.hasLegalMoves(color);
    }

    public boolean isDraw() {
        // Implement 50-move rule and threefold repetition draw conditions here
    }

    public void start() {
        while (true) {
            // Display the board and prompt the user for input

            // Process the user's move

            // Check for game-ending conditions

            // Switch to the other player
            switchPlayer();
        }
    }
}