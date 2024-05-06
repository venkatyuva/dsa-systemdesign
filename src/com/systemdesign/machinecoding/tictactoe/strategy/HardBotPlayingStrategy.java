package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;
import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Bot;
import com.systemdesign.machinecoding.tictactoe.model.Cell;
import com.systemdesign.machinecoding.tictactoe.model.Move;

public class HardBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Board board, Bot bot) {
        int max = 0;
        int row = 0;
        for (int i = 0; i < board.getBoard().size(); i++) {
            int count = 0;
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.FILLED) &&
                        board.getBoard().get(i).get(j).getPlayer().getSymbol() == bot.getSymbol()) {
                    count++;
                }
            }
            if (count > max) {
                row = i;
                max = count;
            }
        }
        max = 0;
        int col = 0;
        for (int i = 0; i < board.getBoard().size(); i++) {
            int count = 0;
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(j).get(i).getCellStatus().equals(CellStatus.FILLED) &&
                        board.getBoard().get(j).get(i).getPlayer().getSymbol() == bot.getSymbol()) {
                    count++;
                }
            }
            if (count > max) {
                col = i;
                max = count;
            }
        }
        if (board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY)) {
            return new Move(new Cell(row, col), bot);
        }
        for (int i = 0; i < board.getBoard().size(); i++) {
            if (board.getBoard().get(row).get(i).getCellStatus().equals(CellStatus.EMPTY)) {
                return new Move(new Cell(row, i), bot);
            }
        }
        for (int i = 0; i < board.getBoard().size(); i++) {
            if (board.getBoard().get(i).get(col).getCellStatus().equals(CellStatus.EMPTY)) {
                return new Move(new Cell(i, col), bot);
            }
        }
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().size(); j++) {
                if (board.getBoard().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)) {
                    return new Move(new Cell(i, j), bot);
                }
            }
        }
        return null;
    }
}
