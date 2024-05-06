package com.systemdesign.machinecoding.tictactoe.model;

import com.systemdesign.machinecoding.tictactoe.enums.CellStatus;

public class Cell {
    private int row;
    private int column;
    private Player player;
    private CellStatus cellStatus;

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return this.cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellStatus = CellStatus.EMPTY;
    }
}
