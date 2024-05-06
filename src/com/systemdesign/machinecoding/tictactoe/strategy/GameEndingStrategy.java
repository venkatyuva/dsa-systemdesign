package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Move;

public abstract class GameEndingStrategy {

    protected boolean ifTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    protected boolean ifTopRightDiagonal(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }

    public abstract GameStatus evaluateGameStatus(Board board, Move move);
}
