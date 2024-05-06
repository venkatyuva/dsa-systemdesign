package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;
import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TimeEfficientGameEndingStrategy extends GameEndingStrategy {

    private final List<HashMap<Character, Integer>> rowWiseSymbolFrequency = new ArrayList<>();
    private final List<HashMap<Character, Integer>> colWiseSymbolFrequency = new ArrayList<>();
    private final HashMap<Character, Integer> topLeftDiagonalSymbolFrequency = new HashMap<>();
    private final HashMap<Character, Integer> topRightDiagonalSymbolFrequency = new HashMap<>();

    public TimeEfficientGameEndingStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowWiseSymbolFrequency.add(new HashMap<>());
            colWiseSymbolFrequency.add(new HashMap<>());
        }
    }

    @Override
    public GameStatus evaluateGameStatus(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        char symbol = move.getPlayer().getSymbol();
        rowWiseSymbolFrequency.get(row).put(symbol, rowWiseSymbolFrequency.get(row).getOrDefault(symbol, 0) + 1);
        colWiseSymbolFrequency.get(col).put(symbol, colWiseSymbolFrequency.get(col).getOrDefault(symbol, 0) + 1);
        if (ifTopLeftDiagonal(row, col)) {
            topLeftDiagonalSymbolFrequency.put(symbol, topLeftDiagonalSymbolFrequency.getOrDefault(symbol, 0) + 1);
        }
        if (ifTopRightDiagonal(row, col, board.getBoard().size())) {
            topRightDiagonalSymbolFrequency.put(symbol, topRightDiagonalSymbolFrequency.getOrDefault(symbol, 0) + 1);
        }
        GameStatus gameStatus = GameStatus.IN_PROGRESS;
        if (rowWiseSymbolFrequency.get(row).get(symbol) == board.getBoard().size()
                || colWiseSymbolFrequency.get(col).get(symbol) == board.getBoard().size()) {
            gameStatus = GameStatus.FINISHED;
        }
        if (ifTopLeftDiagonal(row, col) && topLeftDiagonalSymbolFrequency.get(symbol) == board.getBoard().size()) {
            gameStatus = GameStatus.FINISHED;
        }
        if (ifTopRightDiagonal(row, col, board.getBoard().size())
                && topRightDiagonalSymbolFrequency.get(symbol) == board.getBoard().size()) {
            gameStatus = GameStatus.FINISHED;
        }
        if (board.getBoard().stream().flatMap(Collection::stream)
                .allMatch(cell -> cell.getCellStatus().equals(CellStatus.FILLED))) {
            gameStatus = GameStatus.DRAW;
        }
        return gameStatus;
    }
}
