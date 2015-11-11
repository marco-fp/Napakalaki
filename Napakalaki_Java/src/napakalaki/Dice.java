/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

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
