package Pieces;
import java.util.List;
import Recomendations.QueenRecommend;
import Recomendations.Recommend;

public class BlackQueen implements Piece {
    private String display;
    private String colour = "Black";
    Recommend rm;

    public BlackQueen() {
        display = "\u001B[34m" + "\u265B";
        rm = new QueenRecommend();
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
