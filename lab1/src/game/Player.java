package game;
import java.util.Scanner;

abstract class Player extends Board{
    private String userID;
    Scanner scan  = new Scanner(System.in);
    

    public Player(String n) {
        userID = n;
    }

    public String getUserID(){
        return userID;
    }

    abstract int takePins(Board board);
}
