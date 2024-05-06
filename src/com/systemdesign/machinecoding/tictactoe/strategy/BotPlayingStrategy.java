package com.systemdesign.machinecoding.tictactoe.strategy;

import com.systemdesign.machinecoding.tictactoe.model.Board;
import com.systemdesign.machinecoding.tictactoe.model.Bot;
import com.systemdesign.machinecoding.tictactoe.model.Move;

public interface BotPlayingStrategy {
    Move decideMove(Board board, Bot bot);
}
