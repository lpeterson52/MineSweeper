/**
 * Minesweeper
 */
public class Minesweeper {

    Tile[][] grid = new Tile[10][10];

    public Minesweeper() {

    }

    public void createGrid(int numMines) {
        int count = 0;
        double probability = numMines/(grid.length * grid[0].length);
        while (count < numMines) {
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if(Math.random() < probability){
                        if(grid[r][c] != null && grid[r][c].getMine() != true){
                            grid[r][c] = new Tile(true);
                        }
                        else if(Math.random() < probability){
                            grid[r][c] = new Tile(true);
                        }
                        else{
                            grid[r][c] = new Tile(false);
                        }
                    }
                }
            }
        }
    }
}