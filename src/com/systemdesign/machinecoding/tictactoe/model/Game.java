package com.systemdesign.machinecoding.tictactoe.model;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;
import com.systemdesign.machinecoding.tictactoe.enums.GameStatus;
import com.systemdesign.machinecoding.tictactoe.exception.InvalidDimensionException;
import com.systemdesign.machinecoding.tictactoe.exception.InvalidPlayersCountException;
import com.systemdesign.machinecoding.tictactoe.factory.GameEndingStrategyFactory;
import com.systemdesign.machinecoding.tictactoe.strategy.GameEndingStrategy;

import java.util.List;

public class Game {
    private Board board;

    private List<Player> players;

    private int currentPlayerIndex;

    private GameStatus gameStatus;

    private Player winner;

    private GameEndingStrategy gameEndingStrategy;

    private List<Move> moves;

    private Game() {
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return this.winner;
    }

    public GameEndingStrategy getGameWinningStrategy() {
        return this.gameEndingStrategy;
    }

    public void setGameWinningStrategy(GameEndingStrategy gameEndingStrategy) {
        this.gameEndingStrategy = gameEndingStrategy;
    }

    public List<Move> moves() {
        return this.moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void showBoard() {
        for (List<Cell> rows : this.board.getBoard()) {
            for (Cell cell : rows) {
                if (cell.getCellStatus().equals(CellStatus.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("| " + cell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

    public void makeNextMove() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn");
        Move move = currentPlayer.decideMove(this.board);
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        if (row < board.getBoard().size() && col < board.getBoard().size() &&
                board.getBoard().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY)) {
            board.applyMove(move);
            gameStatus = gameEndingStrategy.evaluateGameStatus(board, move);
            if (GameStatus.FINISHED.equals(gameStatus)) {
                winner = currentPlayer;
            }
            currentPlayerIndex++;
            currentPlayerIndex %= players.size();
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int dimension;

        private List<Player> players;

        public Builder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validateGame() throws InvalidDimensionException, InvalidPlayersCountException {
            if (dimension < 3) {
                throw new InvalidDimensionException("Board dimension should be greater than or equal to 3");
            }
            if (this.dimension == players.size() - 1) {
                throw new InvalidPlayersCountException("Players count should be one less than the dimension of board");
            }
        }

        public Game build() {
            try {
                validateGame();
            } catch (InvalidDimensionException | InvalidPlayersCountException e) {
                System.out.println(e.getMessage());
                return null;
            }
            Game game = new Game();
            Board board = new Board();
            board.generateBoard(dimension);
            game.setBoard(board);
            game.setPlayers(players);
            game.setCurrentPlayerIndex(0);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setGameWinningStrategy(GameEndingStrategyFactory.getInstance(dimension));
            return game;
        }
    }
}
