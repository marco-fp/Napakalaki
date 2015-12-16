
package napakalaki;

import java.util.ArrayList;


public class NumericBadConsequence extends BadConsequence {
    
    protected int nVisibleTreasures;
    protected int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden) {
        super(text, levels);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden) {
        BadConsequence bcAjustado;
        int nVisible = (visibles.size() > nVisibleTreasures ? nVisibleTreasures : visibles.size());
        int nHidden = (hidden.size() > nHiddenTreasures ? nHiddenTreasures : hidden.size());
        bcAjustado = new NumericBadConsequence(text, 0, nVisible, nHidden);

        return bcAjustado;
    }
    
    @Override
    public boolean isEmpty(){
        if(nVisibleTreasures == 0 && nHiddenTreasures == 0)
            return true;
        else
            return false;
    }
    
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }

    @Override
    public String toString(){
        String description = "--- Mal Rollo Numérico --- \n" + "Texto: " + text + "\n";
        
        if (levels != 0)
            description += "Pérdida de niveles: " + levels + "\n";
        
        if(nVisibleTreasures != 0)
            description += "Pérdida de tesoros visibles: " + nVisibleTreasures + "\n";
        if(nHiddenTreasures != 0)
            description += "Pérdida de tesoros ocultos: " + nHiddenTreasures + "\n";
    
        return description;
    }
}
