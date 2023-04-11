package main.java.com.isaacpeterson.chessgame.model;

import main.java.com.isaacpeterson.chessgame.model.ChessPiece.PieceColor;
import main.java.com.isaacpeterson.chessgame.model.pieces.Bishop;
import main.java.com.isaacpeterson.chessgame.model.pieces.King;
import main.java.com.isaacpeterson.chessgame.model.pieces.Knight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private PieceColor currentPlayer;
    private boolean isCheck;
    private boolean isCheckmate;
    private boolean isStalemate;
    private List<String> previousBoardStates;

    public Game() {
        board = new Board();
        currentPlayer = PieceColor.WHITE;
        previousBoardStates = new ArrayList<>();
    }

    public boolean makeMove(Position start, Position end) {
        // Make a move and update the game state.

        // Update the list of previous board states
        previousBoardStates.add(board.toString());
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

    public boolean hasInsufficientMaterial() {
        int numWhiteBishops = 0;
        int numBlackBishops = 0;
        int numKnights = 0;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = board.getPieceAt(new Position(row, col));
                if (piece != null) {
                    if (piece instanceof Bishop) {
                        if (piece.getColor() == PieceColor.WHITE) {
                            numWhiteBishops++;
                        } else {
                            numBlackBishops++;
                        }
                    } else if (piece instanceof Knight) {
                        numKnights++;
                    } else if (!(piece instanceof King)) {
                        return false; // Any other piece (except King) found, sufficient material exists
                    }
                }
            }
        }

        // Insufficient material cases
        if (numWhiteBishops == 0 && numBlackBishops == 0 && numKnights == 0) {
            return true; // Only kings left
        } else if (numWhiteBishops == 0 && numBlackBishops == 0 && numKnights == 1) {
            return true; // One king and one knight
        } else if (numWhiteBishops == 1 && numBlackBishops == 0 && numKnights == 0) {
            return true; // One king and one white bishop
        } else if (numWhiteBishops == 0 && numBlackBishops == 1 && numKnights == 0) {
            return true; // One king and one black bishop
        }

        return false;
    }

    public boolean isDraw() {
        // Check for 50-move rule
        if (board.getHalfMoveCounter() >= 100) {
            return true;
        }

        // Check for threefold repetition
        if (hasThreefoldRepetition()) {
            return true;
        }

        // Check for insufficient material
        if (hasInsufficientMaterial()) {
            return true;
        }

        // Check for stalemate
        if (isStalemate(currentPlayer)) {
            return true;
        }

        return false;
    }

    //a method to determine if a board state has occurred three times
    public boolean hasThreefoldRepetition() {
        Map<String, Integer> boardStateCounts = new HashMap<>();
        for (String state : previousBoardStates) {
            boardStateCounts.put(state, boardStateCounts.getOrDefault(state, 0) + 1);
            if (boardStateCounts.get(state) >= 3) {
                return true;
            }
        }
        return false;
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