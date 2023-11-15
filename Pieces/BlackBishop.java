package Pieces;
import java.util.List;

import Recomendations.BishopRecommend;
import Recomendations.Recommend;

public class BlackBishop implements Piece {
    private String display;
    private String colour = "Black";
    Recommend rm;

    public BlackBishop() {
        display = "\u001B[34m" + "\u265D";
        rm = new BishopRecommend();
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
    public List<int[]> getMoves(int y, int x) {
        // TODO Auto-generated method stub
        return rm.available(y,x);
    }
    @Override
    public List<List<int[]>> getMovesList(int y, int x) {
        // TODO Auto-generated method stub
        return rm.availableList(y,x);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return display;
    }
    public String getColour(){
        return colour;
    }
}
