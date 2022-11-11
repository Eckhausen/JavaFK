package game;

import java.util.Random;

public class EnhancedComputerPlayer extends Player {
    Random rand = new Random();

    public EnhancedComputerPlayer(String name) {
        super(name);
    }

    public int takePins(Board b){ //Vill undvika 3 pinnar.
        int nbr;
        /* if(b.getNoPins() > 5 || b.getNoPins() == 3){ //Kvittar vad den tar.
            nbr = rand.nextInt(2) + 1;
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinnar.");
        } else if(b.getNoPins() == 5){ //Ta 2 för att få 3 pinnar kvar för garanterad vinst.
            nbr = 2;
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinnar."); 
        } else if(b.getNoPins() == 4){ //Ta 1...
            nbr = 1;
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinnar.");
        } else if(b.getNoPins() <= 2){ //Ta resterande pinnar och vinn spelet.
            nbr = b.getNoPins();
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinnar.");
        }  */
        if(b.getNoPins() % 3 == 1){
            nbr = 1;
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinne.");
        } else {
            nbr = 2;
            b.takePins(nbr);
            UserInterface.printMessage("Datorn tog " + nbr + " pinnar.");
        }
        return b.getNoPins();
    }
    
}
