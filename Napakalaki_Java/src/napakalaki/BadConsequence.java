/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

import static java.lang.Integer.min;
import java.util.ArrayList;

public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificHiddenTreasures = null;
    private ArrayList<TreasureKind> specificVisibleTreasures = null;
    
    static final int MAXTREASURES = 10;
    
    // True cuando el bc que tiene que cumplir el jugador está vacío: conjunto de atrib. no hace perder tesoros.
    public boolean isEmpty(){
        if(nVisibleTreasures == 0 && nHiddenTreasures == 0 && (specificHiddenTreasures == null) 
                && (specificVisibleTreasures == null))
            return true;
        else
            return false;
    }
    
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
    }
    
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures = MAXTREASURES;
        this.nHiddenTreasures = 0;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        this.death = false;
    }
    
    // Eliminar
    public String toString(){
        String description = "--- Mal Rollo --- \n" + "Texto: " + text + "\n";
        
        if(isDeath())
            description += "Muerte: " + death + "\n";
        else if (levels != 0)
            description += "Pérdida de niveles: " + levels + "\n";
        
        if(nVisibleTreasures != 0)
            description += "Pérdida de tesoros visibles: " + nVisibleTreasures + "\n";
        if(nHiddenTreasures != 0)
            description += "Pérdida de tesoros ocultos: " + nHiddenTreasures + "\n";
        
        if(specificVisibleTreasures != null)
            description += "Lista tesoros visibles: " + specificVisibleTreasures.toString() + "\n";
        if( specificHiddenTreasures != null)
            description += "Lista tesoros ocultos: " + specificHiddenTreasures.toString() + "\n";
                
        return description;
    }
    
    // Eliminar
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    // Eliminar
    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(specificVisibleTreasures != null)
            specificVisibleTreasures.remove(t.getType());
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(specificHiddenTreasures != null)
            specificHiddenTreasures.remove(t.getType());
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        BadConsequence bcAjustado;
        
        if(specificVisibleTreasures == null && specificHiddenTreasures == null){
            int nVisible = (visibles.size() > nVisibleTreasures ? nVisibleTreasures : visibles.size());
            int nHidden = (hidden.size() > nHiddenTreasures ? nHiddenTreasures : hidden.size());
            bcAjustado = new BadConsequence(text, 0, nVisible,nHidden);
        }
        else{
            
            ArrayList<TreasureKind> listaAjustadaVisibles = new ArrayList();
            ArrayList<TreasureKind> listaAjustadaHidden = new ArrayList();
            
            for(TreasureKind tKind : TreasureKind.values()){
                int jugador = 0, badC = 0;
                
                for(TreasureKind t : specificVisibleTreasures){
                    if(t == tKind)
                        badC++;
                }
                
                for(Treasure t : visibles){
                    if(t.getType() == tKind)
                        jugador++;
                }
                
                for(int i = 0; i< min(jugador,badC); i++)
                    listaAjustadaVisibles.add(tKind);
            
                jugador = 0;
                badC = 0;
            
                for(TreasureKind t : specificHiddenTreasures){
                    if(t == tKind)
                        badC++;
                }
                
                for(Treasure t : hidden){
                    if(t.getType() == tKind)
                        jugador++;
                }
                
                for(int i = 0; i< min(jugador,badC); i++)
                    listaAjustadaHidden.add(tKind);
            }
            
            bcAjustado = new BadConsequence(text, 0, listaAjustadaVisibles, listaAjustadaHidden);
            
        }
        return bcAjustado;
    }
    
}
