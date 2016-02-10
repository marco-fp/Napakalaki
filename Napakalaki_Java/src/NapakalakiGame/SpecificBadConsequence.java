
package NapakalakiGame;

import static java.lang.Integer.min;
import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence {
    
    protected ArrayList<TreasureKind> specificHiddenTreasures = null;
    protected ArrayList<TreasureKind> specificVisibleTreasures = null;

    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
        super(text, levels);
       
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    

    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> visibles, ArrayList<Treasure> hidden){
        BadConsequence bcAjustado;
        
        ArrayList<TreasureKind> listaAjustadaVisibles = null;
        ArrayList<TreasureKind> listaAjustadaHidden = null;

        for(TreasureKind tKind : TreasureKind.values()){
            int jugador = 0, badC = 0;
            
            if(specificVisibleTreasures != null){
                listaAjustadaVisibles = new ArrayList();
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
            }
            
            jugador = 0;
            badC = 0;
            
            if(specificHiddenTreasures != null){
                listaAjustadaHidden = new ArrayList();
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
        }

        bcAjustado = new SpecificBadConsequence(text, 0, listaAjustadaVisibles, listaAjustadaHidden);
        return bcAjustado;
    }
    
    @Override
    public boolean isEmpty(){
        if(((specificHiddenTreasures == null) && (specificVisibleTreasures == null)) || (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()))
            return true;
        else
            return false;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    @Override
    public void substractVisibleTreasure(Treasure t) {
        if (specificVisibleTreasures != null) {
            specificVisibleTreasures.remove(t.getType());
        }
    }

    @Override
    public void substractHiddenTreasure(Treasure t) {
        if (specificHiddenTreasures != null) {
            specificHiddenTreasures.remove(t.getType());
        }
    }

    @Override
    public String toString(){
        String description = "--- Mal Rollo Específico --- \n" + "Texto: " + text + "\n";
        
        if (levels != 0)
            description += "Pérdida de niveles: " + levels + "\n";
        
        if(specificVisibleTreasures != null)
            description += "Lista tesoros visibles: " + specificVisibleTreasures.toString() + "\n";
        if( specificHiddenTreasures != null)
            description += "Lista tesoros ocultos: " + specificHiddenTreasures.toString() + "\n";
                
        return description;
    }
}
