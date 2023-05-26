public class Tile {
    private boolean hasMine;
    private int number;
    private boolean revealed;
    public boolean checked;
    public boolean flagged;
    public Tile(boolean hasMine){
        number = 0;
        this.hasMine = hasMine;
        revealed = false;
        flagged = false;
    }
    public void setFlag(boolean y){
        flagged = y;
    }
    public boolean getFlag(){
        return flagged;
    }
    public void setChecked(boolean x){
        checked = x;
    }
    public boolean getChecked(){
        return checked;
    }
    public void setMine(boolean x){
        hasMine = x;
    }
    public boolean getMine(){
        return hasMine;
    }
    public boolean isRevealed(){
        return revealed;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int num){
        number = num;
    }
    public void reveal(){
        revealed = true;
        flagged = false;
    }
}
