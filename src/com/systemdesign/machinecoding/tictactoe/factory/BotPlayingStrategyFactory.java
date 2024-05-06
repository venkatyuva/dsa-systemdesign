package com.systemdesign.machinecoding.tictactoe.factory;

import com.systemdesign.machinecoding.tictactoe.enums.BotDifficultyLevel;
import com.systemdesign.machinecoding.tictactoe.strategy.BotPlayingStrategy;
import com.systemdesign.machinecoding.tictactoe.strategy.EasyBotPlayingStrategy;
import com.systemdesign.machinecoding.tictactoe.strategy.HardBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getInstance(BotDifficultyLevel botDifficultyLevel) {
        BotPlayingStrategy botPlayingStrategy = null;
        if (BotDifficultyLevel.EASY.equals(botDifficultyLevel)) {
            botPlayingStrategy = new EasyBotPlayingStrategy();
        } else if (BotDifficultyLevel.HARD.equals(botDifficultyLevel)) {
            botPlayingStrategy = new HardBotPlayingStrategy();
        }
        return botPlayingStrategy;
    }
}
