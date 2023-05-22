public class Tile {
    private boolean hasMine;
    private int number;
    private boolean revealed;
    public boolean checked;
    public Tile(boolean hasMine){
        number = 0;
        this.hasMine = hasMine;
        revealed = false;
    }
    public void setChecked(boolean x){
        checked = x;
    }
    public boolean getChecked(){
        return checked;
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
    }
}
