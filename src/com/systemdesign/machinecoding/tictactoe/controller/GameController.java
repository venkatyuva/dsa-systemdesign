package com.systemdesign.machinecoding.tictactoe.controller;

import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.model.Game;
import com.systemdesign.machinecoding.tictactoe.model.Player;

import java.util.List;

public class GameController {

    public Game createGame(int dimensions, List<Player> players) {
        return Game.getBuilder().dimension(dimensions).players(players).build();
    }

    public void displayBoard(Game game) {
        game.showBoard();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }
}
