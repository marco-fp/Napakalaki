 /**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Javier Escobar Cerezo, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

public class Prize {
    
    private int treasure;
    private int level;
    
    Prize(int treasures, int level){
        this.treasure = treasures;
        this.level = level;
    }

    public int getTreasure() {
        return treasure;
    }

    public int getLevel() {
        return level;
    }
    
    public String toString(){
    return "--- Tesoro --- \n" + "Tesoros: " + treasure + 
            "\n Niveles: " + level + "\n";  
    }
}
