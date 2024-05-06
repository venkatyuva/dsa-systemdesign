package com.systemdesign.machinecoding.tictactoe.model;

import com.systemdesign.machinecoding.tictactoe.enums.BotDifficultyLevel;
import com.systemdesign.machinecoding.tictactoe.factory.BotPlayingStrategyFactory;
import com.systemdesign.machinecoding.tictactoe.strategy.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getInstance(botDifficultyLevel);
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(board, this);
    }
}
