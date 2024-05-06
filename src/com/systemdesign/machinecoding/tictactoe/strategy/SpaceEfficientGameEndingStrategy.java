package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;
import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Move;

import java.util.Collection;

public class SpaceEfficientGameEndingStrategy extends GameEndingStrategy {

    @Override
    public GameStatus evaluateGameStatus(Board board, Move move) {
        char symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        int count = 0;
        for (int i = 0; i < board.getBoard().size(); i++) {
            if (board.getBoard().get(row).get(i).getCellStatus().equals(CellStatus.FILLED) &&
                    board.getBoard().get(row).get(i).getPlayer().getSymbol() == symbol) {

                count++;
            }
        }
        if (count == board.getBoard().size()) {
            return GameStatus.FINISHED;
        }
        count = 0;
        for (int i = 0; i < board.getBoard().size(); i++) {
            if (board.getBoard().get(i).get(col).getCellStatus().equals(CellStatus.FILLED) &&
                    board.getBoard().get(i).get(col).getPlayer().getSymbol() == symbol) {
                count++;
            }
        }
        if (count == board.getBoard().size()) {
            return GameStatus.FINISHED;
        }
        count = 0;
        if (ifTopLeftDiagonal(row, col)) {
            for (int i = 0; i < board.getBoard().size(); i++) {
                if (board.getBoard().get(i).get(i).getCellStatus().equals(CellStatus.FILLED) &&
                        board.getBoard().get(i).get(i).getPlayer().getSymbol() == symbol) {
                    count++;
                }
            }
        }
        if (count == board.getBoard().size()) {
            return GameStatus.FINISHED;
        }
        count = 0;
        if (ifTopRightDiagonal(row, col, board.getBoard().size())) {
            for (int i = 0; i < board.getBoard().size(); i++) {
                if (board.getBoard().get(i).get(board.getBoard().size() - i - 1).getCellStatus()
                        .equals(CellStatus.FILLED) && board.getBoard().get(i)
                        .get(board.getBoard().size() - i - 1).getPlayer().getSymbol() == symbol) {
                    count++;
                }
            }
        }
        if (count == board.getBoard().size()) {
            return GameStatus.FINISHED;
        }
        GameStatus gameStatus = GameStatus.IN_PROGRESS;
        if (board.getBoard().stream().flatMap(Collection::stream)
                .allMatch(cell -> cell.getCellStatus().equals(CellStatus.FILLED))) {
            gameStatus = GameStatus.DRAW;
        }
        return gameStatus;
    }
}
