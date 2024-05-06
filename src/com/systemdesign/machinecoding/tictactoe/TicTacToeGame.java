package com.systemdesign.machinecoding.tictactoe;

import com.systemdesign.machinecoding.tictactoe.controller.GameController;
import com.systemdesign.machinecoding.tictactoe.enums.BotDifficultyLevel;
import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.model.Bot;
import com.systemdesign.machinecoding.tictactoe.model.Game;
import com.systemdesign.machinecoding.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        System.out.println("TIC TAC TOE");
        System.out.println("Enter the tic tac toe board dimension: ");
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();
        int playersCount = dimension - 1;
        System.out.println("Do you want to play with bot? Y/N");
        String isBot = scanner.next();
        List<Player> players = new ArrayList<>();
        if ("Y".equals(isBot)) {
            playersCount--;
            System.out.println("Enter bot name: ");
            String botName = scanner.next();
            System.out.println("Enter bot symbol");
            char symbol = scanner.next().charAt(0);
            System.out.println("Enter the bot difficulty level: ");
            System.out.println("1. Easy");
            System.out.println("2. Hard");
            int level = scanner.nextInt();
            BotDifficultyLevel difficultyLevel = level == 1 ? BotDifficultyLevel.EASY : BotDifficultyLevel.HARD;
            players.add(new Bot(botName, symbol, difficultyLevel));
        }
        for (int i = 0; i < playersCount; i++) {
            System.out.println("Enter the player name: ");
            String name = scanner.next();

            System.out.println("Enter the player symbol: ");
            char symbol = scanner.next().charAt(0);

            Player player = new Player(name, symbol);
            players.add(player);
        }
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension, players);
        if (game != null) {
            while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
                gameController.displayBoard(game);
                gameController.executeNextMove(game);
            }
            gameController.displayBoard(game);
            if (GameStatus.DRAW.equals(gameController.getGameStatus(game))) {
                System.out.println("GAME IS DRAW");
            }
            if (GameStatus.FINISHED.equals(gameController.getGameStatus(game))) {
                System.out.println("GAME IS FINISHED");
                System.out.println("Winner is: " + gameController.getWinner(game).getName());
            }
        } else {
            System.out.println("Exception while building the game");
        }
    }
}
