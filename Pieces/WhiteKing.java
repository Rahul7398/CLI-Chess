package Pieces;
import java.util.List;
import Recomendations.KingRecommend;
import Recomendations.Recommend;

public class WhiteKing implements Piece {
    private String display;
    private String colour = "White";
    Recommend rm;

    public WhiteKing() {
        display = "\u001B[93m" + "\u2654";
        rm = new KingRecommend();
    }

    @Override
    public boolean isValidMove(int x, int y) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void move(int x, int y) {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return display;
    }
    @Override
    public List<int[]> getMoves(int y, int x) {
        // TODO Auto-generated method stub
        return rm.available(y, x);
    }
    @Override
    public List<List<int[]>> getMovesList(int y, int x) {
        // TODO Auto-generated method stub
        return rm.availableList(y,x);
    }
    public String getColour(){
        return colour;
    }
}
