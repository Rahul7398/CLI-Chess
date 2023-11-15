package Pieces;
import java.util.List;

public interface Piece {
    public boolean isValidMove(int x, int y);
    public void move(int x, int y);
    public List<int[]> getMoves(int y,int x);
    public String getColour();
    public List<List<int[]>> getMovesList(int y, int x);

    
}
