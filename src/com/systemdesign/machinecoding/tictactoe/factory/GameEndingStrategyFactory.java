package com.systemdesign.machinecoding.tictactoe.factory;

import com.systemdesign.machinecoding.tictactoe.strategy.TimeEfficientGameEndingStrategy;
import com.systemdesign.machinecoding.tictactoe.strategy.GameEndingStrategy;
import com.systemdesign.machinecoding.tictactoe.strategy.SpaceEfficientGameEndingStrategy;

public class GameEndingStrategyFactory {

    public static GameEndingStrategy getInstance(int dimension) {
        GameEndingStrategy gameEndingStrategy;
        if (dimension < 5) {
            gameEndingStrategy = new SpaceEfficientGameEndingStrategy();
        } else {
            gameEndingStrategy = new TimeEfficientGameEndingStrategy(dimension);
        }
        return gameEndingStrategy;
    }
}
