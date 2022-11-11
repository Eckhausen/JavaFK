package game;

import java.util.Scanner;

public class Board {
    private int noPins = 0; //attribut
    Scanner scan = new Scanner(System.in); 

    public void setUp(int pins){
        //System.out.println("Hur många pinnar vill du spela med? "); 
        this.noPins = pins;
    }

    public void takePins(int x){ //Tar x-pinnar vid varje metodanrop. Skall innehålla if sats för vinst eller förlust.
        noPins -= x;
    }

    public int getNoPins(){
        return noPins;
    }
}
