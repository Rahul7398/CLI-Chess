package Pieces;
import java.util.List;
import Recomendations.WhitePawnRecommend;
import Recomendations.Recommend;

public class WhitePawn implements Piece {
    private String display;
    private String colour = "White";
    Recommend rm;

    public WhitePawn() {
        display = "\u001B[93m" + "\u2659";
        rm = new WhitePawnRecommend();
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
