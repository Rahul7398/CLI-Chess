import java.util.List;

import Pieces.*;

public class Board {
    int size;
    Piece[][] board;
    boolean[][] highlight;
    int[] setSquare;
    int[] setReleaseSquare;
    boolean[][] movesArr;
    boolean isMovesArr;
    String[] tutorialString;

    public Board() {
        size = 8;
        board = new Piece[size][size];
        highlight = new boolean[size][size];
        setSquare = new int[]{3,3};
        setReleaseSquare = new int[]{-1,-1};
        movesArr = new boolean[size][size];
        isMovesArr = false;
        tutorialString = new String[8];
        tutorial();
    }

    public void createGame() {

        for (int i = 0; i < size; i++) {
            board[1][i] = new BlackPawn();
        }
        for (int i = 0; i < size; i++) {
            board[size - 2][i] = new WhitePawn();
        }
        board[size - 1][0] = new WhiteRook();
        board[size - 1][size - 1] = new WhiteRook();

        board[size - 1][1] = new WhiteKnight();
        board[size - 1][size - 2] = new WhiteKnight();

        board[size - 1][2] = new WhiteBishop();
        board[size - 1][size - 3] = new WhiteBishop();

        board[size - 1][3] = new WhiteQueen();
        board[size - 1][size - 4] = new WhiteKing();

        board[0][size - 1] = new BlackRook();
        board[0][0] = new BlackRook();

        board[0][1] = new BlackKnight();
        board[0][size - 2] = new BlackKnight();

        board[0][2] = new BlackBishop();
        board[0][size - 3] = new BlackBishop();

        board[0][3] = new BlackQueen();
        board[0][size - 4] = new BlackKing();

    }

    public boolean move(int ir, int ic, int fr, int fc) {
        if (board[ir][ic] == null)
            return false;
        Piece curP = board[ir][ic];
        board[ir][ic] = null;
        board[fr][fc] = curP;
        return true;
    }

    public void show() {
        String greyBG = "\u001B[100m";//"\u001B[47m";
        String blackBG = "\u001B[40m";
        String resetBg = "\u001B[0m";
        System.out.print("\033\143"); 
        // System.out.print(" +");
        // for (int i = 0; i < size; i++) {
        //     System.out.print("---+");
        // }
        // System.out.println();
        for (int i = 0; i < size; i++) {
            // System.out.print(i+"|");
            for (int j = 0; j < size; j++) {
                String pre = " ",post = " ";
                if(i==setSquare[0] && j==setSquare[1]) {
                    pre = "|";
                    post = "|";
                }
                else if(i==setReleaseSquare[0] && j==setReleaseSquare[1]){
                    pre = "(";
                    post = ")";
                }
                else if(movesArr[i][j]){
                    pre = ":";
                    post = ":";
                }
                String bg = (i+j)%2==1?blackBG:greyBG;
                System.out.print(bg + pre+(board[i][j] == null ? " " : board[i][j])+ post+resetBg);
                
            }
            if(i<tutorialString.length)
                System.out.print(" "+tutorialString[i]);
            System.out.println();
        }
        // for (int i = 0; i < size; i++) {
        //     System.out.print("   "+i);
        // }
        // System.out.println();

    }
    public void setSelect(int y,int x) {
        setSquare = new int[]{y,x};
    }
    public void unSetSelect(){
        setSquare = new int[]{3,3};
    }
    public int[] getSelect(){
        return setSquare;
    }
    public void setRelease(int y,int x){
        setReleaseSquare = new int[]{y,x};
    }
    public int[] getRelease(){
        return setReleaseSquare;
    }
    public void eraseRelease(){
        setReleaseSquare = new int[]{-1,-1};
    }
    public boolean setMoves(int y,int x){
        if(isMovesArr)
            return true;
        Piece cur = board[y][x];
        List<int[]> l = cur.getMoves(y, x);
        List<List<int[]>> movesList = cur.getMovesList(y, x);
        boolean flag = false;
        for(List<int[]> i:movesList){
            for(int[] j:i){
                if(j[0]<0 || j[0]>=size || j[1]<0 || j[1]>=size )
                    break;
                if(board[j[0]][j[1]]!=null){
                    if(cur.getColour().equals(board[j[0]][j[1]].getColour()))
                        break;
                    else{
                        movesArr[j[0]][j[1]] = true;
                        flag = true;
                        break;    
                    }
                }
                else{
                    movesArr[j[0]][j[1]] = true;
                    flag = true;
                }
            }
        }
        isMovesArr = flag;
        return flag;
        
    }
    public boolean checkSetMoves(int y,int x){
        return movesArr[y][x];
    }
    public void unSetMoves(){
        movesArr = new boolean[size][size];
        isMovesArr = false;
    }
    public Piece getPiece(int y,int x){
        return board[y][x];

    }
    public void tutorial(){
        tutorialString[0] = "\u001B[93m" + "\u2654\u001B[0m" +"   White";
        tutorialString[1] = "\u001B[34m" + "\u265A\u001B[0m" +"   Black ";
        tutorialString[2] = "| |"+" current pos";
        tutorialString[3] = "( )"+" Piece Move";
        tutorialString[4] = ": :"+" posible moves";
        tutorialString[5] = "\u21A9"+"   to select";
        tutorialString[6] = "  🅆 to navigate";
        tutorialString[7] = "🄰 🅂 🄳";

    }
    

}
