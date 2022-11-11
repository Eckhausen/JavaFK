package game;

import javax.swing.JOptionPane;

public class UserInterface {
    /** Visar en dialogruta med texten msg. */
public static void printMessage(String msg) {
    JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
    * Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
    * användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
    * returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
    */
    public static int askForInt(String msg) { 
        try{
            String input = JOptionPane.showInputDialog(null, msg);
            int value = Integer.decode(input);

            if(value <= 2 && value > 0){
                return value;
            } else if (input == null || input.equals("")) {
                return -2;
                //System.exit(0)?
            } else {
                return -1;
            }
        } catch (NumberFormatException e){
            return -1;
        }

    }

    public static int startingPins(){
        int value = -1;
        String input;

            try{
                input = JOptionPane.showInputDialog(null, "Hur många pinnar vill du spela med?");
                value = Integer.decode(input);
            } catch(NumberFormatException e){
                return -1;
            }
            return value;   
        }

    public static String askForString(String msgString){
        return JOptionPane.showInputDialog(null, msgString);
    }

  /*   public static boolean isNumeric(String msg){
        boolean bool = true;
        try{
            int antal = Integer.parseInt(msg);
        } catch (NumberFormatException e) {
             return false;
        }
       return bool;
    } */
}
