package napakalaki;

import java.util.Random;

public class Dice {
    
    private static final Dice instance = new Dice();
    
    private Dice(){};
    
    static public Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
