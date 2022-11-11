package game;

import java.util.Random;

public class ComputerPlayer extends Player {
    Random rand = new Random();

    public ComputerPlayer(String name) {
        super(name); //Namn till UserID?
    }
    public int takePins(Board w){
        int nbr = rand.nextInt(2) + 1;
        UserInterface.printMessage("Datorn tog " + nbr + " pinnar.");
        //System.out.println("Datorn tog " + nbr + " pins");
        w.takePins(nbr);
        return w.getNoPins();
    }
}
