package com.systemdesign.machinecoding.tictactoe.model;

import java.util.Scanner;

public class Player {

    private String name;

    private char symbol;

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public Move decideMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row to make a move: ");
        int row = scanner.nextInt();
        System.out.println("Enter the column to make a move: ");
        int column = scanner.nextInt();
        return new Move(new Cell(row, column), this);
    }
}
