package game;

public class TakePinsGame {
    public static void main(String[] args) {
       
        UserInterface.printMessage("Take pins game!");
        
        // Skapa brädet med antal pinnar och skapa spelare.
        Board b = new Board();
        int value = UserInterface.startingPins();
        while ( value == -1){
            value = UserInterface.startingPins();
        }
        b.setUp(value);
        HumanPlayer p1 = new HumanPlayer(UserInterface.askForString("Ange namn på spelaren: "));
        // ComputerPlayer CPU = new ComputerPlayer("CPU");
        EnhancedComputerPlayer CPU = new EnhancedComputerPlayer("CPU");
        UserInterface.printMessage(p1.getUserID() + " vs. " + CPU.getUserID());

        String goFirst = UserInterface.askForString("Vill du börja (Y/N)?").toLowerCase();

        Boolean myTurn;
        if(goFirst.equalsIgnoreCase("y")){
            myTurn = true;
        } else {
            myTurn = false;
        }

        while(b.getNoPins() > 0){ //Matar du in fel värde och sen skriver in nytt i det nya fönstret så händer inget.
            if(myTurn){
                int numberToTake = UserInterface.askForInt("Det finns " + b.getNoPins() + " pinnar." + "\n" + "Hur många pinnar vill du ta? 1 eller 2?");
                if(numberToTake == -1){ //Kolla efter felaktiga inputs eller avbryt (null).
                    // numberToTake = UserInterface.askForInt(
                    //     "Ogiltigt värde. Försök igen. " + "\n"
                    //      + "Det finns " + b.getNoPins() + " pinnar kvar." + "\n"
                    //       + "Hur många pinnar vill du ta? 1 eller 2?" );
                    UserInterface.printMessage("Ogiltigt värde. Försök igen.");
                } else if (numberToTake == -2){ //Input är null eller tom string
                    System.exit(0);
                } else { //Rätt värde matas in.
                    b.takePins(numberToTake);
                    myTurn = false; 
                }
                
            } else if (!myTurn){
                CPU.takePins(b); 
                myTurn = true;
            }
        }
        if(myTurn){
                UserInterface.printMessage("Datorn vann!");
            } else {
                UserInterface.printMessage(p1.getUserID() +" vann!");
            }
    }   
    
}