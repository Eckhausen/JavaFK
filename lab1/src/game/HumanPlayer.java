package game;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name); //Namn till UserID?
    }
    public int takePins(Board board){ 
        int x = scan.nextInt();
        board.takePins(x);
        return board.getNoPins();
    }
}
