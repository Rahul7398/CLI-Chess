package Pieces;
import java.util.List;

import Recomendations.KnightRecommend;
import Recomendations.Recommend;
public class BlackKnight implements Piece {
    private String display;
    private String colour = "Black";
    private Recommend rm;
    

    public BlackKnight() {
        display = "\u001B[34m" + "\u265E";
        rm = new KnightRecommend();
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

    public List<int[]> getMoves(int y,int x){
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
