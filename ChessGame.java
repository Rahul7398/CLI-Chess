import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ChessGame {
    public Board board;
    PlayerClass p1, p2;
    public Deque<PlayerClass> secquence;

    public ChessGame() {
        board = new Board();
        p1 = new PlayerClass("White");
        p2 = new PlayerClass("Black");
        secquence = new LinkedList<PlayerClass>();
        secquence.addLast(p1);
        secquence.addLast(p2);
    
    }

    public String start() {
        board.createGame();
        boolean won = false;
        Scanner sc = new Scanner(System.in);
        int previousState = 0;
        while (!won) {
            board.show();
            PlayerClass cur = secquence.removeFirst();

            System.out.print(cur.getColour() + " turn : ");
            int[] pos = takeInput(previousState);
            previousState = pos[2];
            System.out.println(previousState);
            if(previousState == 0){
                secquence.addFirst(cur);
                board.setSelect(pos[0],pos[1]);
            }
            else if(previousState == 1){
                if(board.getPiece(pos[0], pos[1])==null && !board.isMovesArr){
                    previousState = 0;
                    secquence.addFirst(cur);
                    board.setSelect(pos[0],pos[1]);
                    continue;
                }
                if(board.getPiece(pos[0], pos[1])!=null && board.getPiece(pos[0], pos[1]).getColour()!=cur.getColour()){
                    if(board.isMovesArr){
                        previousState = 1;
                        board.setRelease(pos[0],pos[1]);
                    }
                    else{
                        previousState = 0;
                        board.setSelect(pos[0],pos[1]);
                    }
                    secquence.addFirst(cur);
                    
                    continue;
                }
                secquence.addFirst(cur);
                board.setRelease(pos[0],pos[1]);
                // board.setMoves(pos[0],pos[1]);
                if(!board.setMoves(pos[0],pos[1])){
                    // System.out.println("no valid moves");
                    board.eraseRelease();
                    previousState = 0;
                }
            }
            else{
                if(!board.checkSetMoves(pos[0],pos[1]) || 
                (board.getPiece(pos[0], pos[1])!=null && (board.getPiece(pos[0], pos[1]).getColour())==cur.getColour()) ){
                    // previousState =1;
                    // secquence.addFirst(cur);
                    previousState =1;
                    secquence.addFirst(cur); 
                    board.eraseRelease();
                    board.unSetMoves(); 
                    board.setSelect(pos[0],pos[1]);
                    board.setRelease(pos[0],pos[1]);
                    board.setMoves(pos[0],pos[1]);  
                    continue;
                }
                secquence.addLast(cur);
                board.move(board.getSelect()[0],board.getSelect()[1],pos[0],pos[1]);
                board.eraseRelease();
                board.unSetMoves();
            }
            
        }
        
        return "Draw";
    }

    public int[] takeInput(int previousState){
        Scanner sc = new Scanner(System.in);
        
        int[] initialPos = new int[2];
        int state = previousState%2;
        if(state == 0){
            initialPos = board.getSelect();
        }
        else{
            initialPos = board.getRelease();
        }
        int cury=initialPos[0], curx = initialPos[1];
        
        String input = sc.nextLine();

        char inp='!';
        if(input.equals(""))
            state = state+1;
        else
            inp = input.charAt(0);
        
        if(inp=='w')
            cury--;
        else if(inp=='s')
            cury++;
        else if(inp=='a')
            curx--;
        else if(inp=='d')
            curx++;
        return new int[]{cury,curx,state};
    }

}
