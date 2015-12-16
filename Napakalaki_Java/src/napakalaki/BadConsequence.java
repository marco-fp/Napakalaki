/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

import java.util.ArrayList;

public abstract class BadConsequence {
    protected String text;
    protected int levels;

    static final int MAXTREASURES = 10;
    
    
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }
    
    
    // True cuando el bc que tiene que cumplir el jugador está vacío: conjunto de atrib. no hace perder tesoros.
    public boolean isEmpty(){
        return false;
    }
    
    // Eliminar
    public String toString(){
        String description = "--- Mal Rollo Genérico --- \n" + "Texto: " + text + "\n";
        
        if (levels != 0)
            description += "Pérdida de niveles: " + levels + "\n"; 
                
        return description;
    }
    
    // Eliminar
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }


    public void substractVisibleTreasure(Treasure t) {
    }

    public void substractHiddenTreasure(Treasure t) {
    }
    
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        return null;
    }
        
}    

