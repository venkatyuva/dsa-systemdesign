package com.systemdesign.machinecoding.tictactoe.model;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public List<List<Cell>> generateBoard(int dimensions) {
        this.board = new ArrayList<>();
        for (int i = 0; i < dimensions; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimensions; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
        return board;
    }

    public List<List<Cell>> getBoard() {
        return this.board;
    }

    public void applyMove(Move move) {
        Cell currentCell = board.get(move.getCell().getRow()).get(move.getCell().getColumn());
        currentCell.setCellStatus(CellStatus.FILLED);
        currentCell.setPlayer(move.getPlayer());
    }
}
