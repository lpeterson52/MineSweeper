public class Minesweepermain {
    public static void main(String[] args) {
        Minesweeper m = new Minesweeper();
        m.generateNum();
        m.appear(0,0);
        m.printNums();
        System.out.println();
        m.printRevealed();
    }
}
