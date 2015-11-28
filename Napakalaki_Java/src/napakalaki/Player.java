/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Player {
 
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    
    Player enemy = null;
    ArrayList<Treasure> visibleTreasures = null;
    ArrayList<Treasure> hiddenTreasures = null;
    BadConsequence pendingBadConsequence = null;
    
    
    public Player(String name){
        this.name = name;
        this.visibleTreasures = new ArrayList();
        this.hiddenTreasures = new ArrayList();
    }
    
    public String getName(){
        return this.name;
    }
    
    private void bringToLife(){
        this.dead = false;
    }
    
    private int getCombatLevel(){
        int combatLevel = this.level;
        
        for(Treasure tesoro : visibleTreasures)
            combatLevel+= tesoro.getBonus();
        
        return combatLevel;
    }
    
    private void incrementLevels(int i){
        this.level +=i;
    }
    
    private void decrementLevels(int i){
        this.level -= i;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m){
        
    }
    
    private void applyBadConsequence(Monster m){
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        TreasureKind tipo = t.getType();
        // ARMOR
        if(tipo == TreasureKind.ARMOR){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.ARMOR)
                    return false;
            }
            return true;
        }
        // ONEHAND
        else if(tipo == TreasureKind.ONEHAND){
            int numUnaMano = 0;
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.ONEHAND)
                    numUnaMano++;
            }
            return numUnaMano <= 1;
        }
        // BOTHHANDS 
        else if(tipo == TreasureKind.BOTHHANDS){
            int numUnaMano = 0;
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.ONEHAND || treasure.getType() == TreasureKind.BOTHHANDS)
                    return false;
            }
            return true;
        }
        // HELMET
        else if(tipo == TreasureKind.HELMET){
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.HELMET)
                    return false;
            }
            return true;
        }
        // SHOES
        else{
            for(Treasure treasure : visibleTreasures){
                if(treasure.getType() == TreasureKind.SHOES)
                    return false;
            }
            return true;
        }
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for (Treasure treasure : visibleTreasures)
            if(treasure.getType() == tKind)
                contador++;
        
        return contador;
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            this.dead = true;
    }
    
    public boolean isDead(){
        return this.dead;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public CombatResult combat(Monster m){
        return null;
    }
    
    public void makeTreasureVisible(Treasure t){
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        if(visibleTreasures!=null){
            visibleTreasures.remove(t);
            
            if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
                pendingBadConsequence.substractVisibleTreasure(t);
            }
            dieIfNoTreasures();
        }   
    }
    
    public void discardHiddenTreasure(Treasure t){
        if(hiddenTreasures != null){
            hiddenTreasures.remove(t);
            
            if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty()){
                pendingBadConsequence.substractHiddenTreasure(t);
            }
            dieIfNoTreasures();
        }
    }
    
    public boolean validState(){
        if(pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4)
            return true;
        else
            return false;
    }
    
    public void initTreasures(){
        
    }
    
    public int getLevels(){
        return this.level;
    }
    
    public Treasure stealTreasure(){
        return null;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure(){
        Random rand = new Random(); 
        return hiddenTreasures.get(rand.nextInt(hiddenTreasures.size()-1));
    }
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        if(!visibleTreasures.isEmpty() || !hiddenTreasures.isEmpty())
            return true;
        else
            return false;
    }
    
    private void haveStolen(){
        this.canISteal = false;
    }
    
    public void discardAllTreasures(){
        
    }
    
}
