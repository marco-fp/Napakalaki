package napakalaki;

public class Dice {
    
    private static final Dice instance = new Dice();
    
    private Dice(){};
    
    static public Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        return 0;
    }
}
