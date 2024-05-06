package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;
import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Bot;
import com.systemdesign.machinecoding.tictactoe.model.Cell;
import com.systemdesign.machinecoding.tictactoe.model.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move decideMove(Board board, Bot bot) {
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
