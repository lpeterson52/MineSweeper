
/**
 * Minesweeper
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

import java.util.Scanner;

public class Minesweeper {

    Tile[][] grid = new Tile[10][10];
    boolean DEBUG = false;

    public Minesweeper() {
        createGrid(10);
        grid[0][0].reveal();
    }

    public String askUser() {
        Console console = System.console();
        String inputString = console.readLine("enter x and y to reveal with comme in between ex:0,1");
        revealTile(inputString);
        return inputString;
    }

    // reveals a certain tile
    public void revealTile(String word) {
        String xString = word.substring(0, 1);
        String yString = word.substring(word.length() - 1);
        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        grid[x][y].reveal();
    }

    // fils up grid with random mines
    public void createGrid(int numMines) {
        int count = 0;
        double probability = numMines * 1.0 / (grid.length * grid[0].length);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new Tile(false);
            }
        }
        while (count < numMines) {
            if (DEBUG) {
                System.out.println("while test");
            }
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (Math.random() <= probability) {
                        if (grid[r][c] != null && grid[r][c].getMine() != true) {
                            grid[r][c] = new Tile(true);
                            count++;
                            if (DEBUG) {
                                System.out.println("mine placed 1");
                            }
                        }
                    } else {
                        grid[r][c] = new Tile(false);
                        if (DEBUG) {
                            System.out.println("mine placed 3");
                        }
                    }
                }
            }
        }
    }

    // prints the mines
    public void printGrid() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c].getMine())
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }
    }

    // Prints Numbers
    public void printNums() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c].getMine()) {
                    System.out.print("X ");
                } else {
                    System.out.print(grid[r][c].getNumber() + " ");
                }
            }
            System.out.println();
        }
    }

    public void printRevealed() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c].isRevealed()) {
                    System.out.print(grid[r][c].getNumber() + " ");
                } else {
                    System.out.print("[]");
                }
            }
            System.out.println();
        }
    }

    // the first click the player does
    public void appear(int x, int y) {
        // if outside edge
        if (x < 0 || y < 0 || x > grid.length || y > grid[x].length || grid[x][y].getMine()) {
            System.out.println("edge");
            return;
        }
        // if mine
        else if (grid[x][y].getMine()) {
            System.out.println("mine");
            return;
        }
        // if number
         else {
            grid[x][y].reveal();
            appear(x - 1, y - 1);
            appear(x - 1, y);
            appear(x - 1, y + 1);
            appear(x, y + 1);
            appear(x, y - 1);
            appear(x + 1, y - 1);
            appear(x + 1, y);
            appear(x + 1, y - 1);
        }
    }

    // generates numbers for mines
    public void generateNum() {

        for (int x = 0; x != grid.length; x++) {
            for (int y = 0; y != grid[x].length; y++) {
                int countMine = 0;
                // checks if tile is mine
                if (grid[x][y].getMine()) {
                    grid[x][y].setNumber(-1);
                }
                // top left corner
                else if (x == 0 && y == 0) {
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y + 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y + 1].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }

                // top right corner
                else if (x == 0 && y == grid[x].length - 1) {
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // bottom left corner
                else if (x == grid.length - 1 && y == 0) {
                    if (grid[x][y + 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    if (grid[x - 1][y + 1].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // bottom right corner
                else if (x == grid.length - 1 && y == grid[x].length - 1) {
                    if (grid[x - 1][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // top row
                else if (x == 0) {
                    // left
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }

                    if (grid[x + 1][y - 1].getMine()) {
                        countMine++;
                    }
                    // bottom
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    // bottom right
                    if (grid[x + 1][y + 1].getMine()) {
                        countMine++;
                    }
                    // right
                    if (grid[x][y + 1].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // left column
                else if (y == 0) {
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    if (grid[x - 1][y + 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x][y + 1].getMine()) {
                        countMine++;
                    }
                    // bottom right
                    if (grid[x + 1][y + 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // right column
                else if (y == grid[x].length - 1) {
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    if (grid[x - 1][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y - 1].getMine()) {
                        countMine++;
                    }
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
                // bottom row
                else if (x == grid.length - 1) {
                    // right
                    if (grid[x][y + 1].getMine()) {
                        countMine++;
                    }
                    // top left
                    if (grid[x - 1][y - 1].getMine()) {
                        countMine++;
                    }
                    // left
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }
                    // top right
                    if (grid[x - 1][y + 1].getMine()) {
                        countMine++;
                    }
                    // top
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                } else {
                    // top
                    if (grid[x - 1][y].getMine()) {
                        countMine++;
                    }
                    // bottom
                    if (grid[x + 1][y].getMine()) {
                        countMine++;
                    }
                    // left
                    if (grid[x][y - 1].getMine()) {
                        countMine++;
                    }
                    // right
                    if (grid[x][y + 1].getMine()) {
                        countMine++;
                    }
                    // bottom left
                    if (grid[x + 1][y - 1].getMine()) {
                        countMine++;
                    }
                    // top right
                    if (grid[x - 1][y + 1].getMine()) {
                        countMine++;
                    }
                    // top left
                    if (grid[x - 1][y - 1].getMine()) {
                        countMine++;
                    }
                    // bottom right
                    if (grid[x + 1][y + 1].getMine()) {
                        countMine++;
                    }
                    grid[x][y].setNumber(countMine);
                }
            }
        }
    }

}