package napakalaki;

import java.util.ArrayList;

public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();
    
    
    ArrayList<Monster> unusedMonsters = null;
    ArrayList<Monster> usedMonsters = null;
    ArrayList<Treasure> unusedTreasures = null;
    ArrayList<Treasure> usedTreasures = null;
    
    private CardDealer(){
        
        this.unusedMonsters = new ArrayList();
        this.usedMonsters = new ArrayList();
        this.unusedTreasures = new ArrayList();
        this.usedTreasures = new ArrayList();

    }
    
    static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
        
    }
    
    private void initMonsterCardDeck(){
        
    }
    
    private void shuffleTreasures(){
        
    }
    
    private void shuffleMonsters(){
        
    }
    
    public Treasure nextTreasure(){
        return null;
    }
    
    public Monster nextMonster(){
        return null;
    }
    
    public void giveTreasureBack(Treasure t){
        
    }
    
    public void giveMonsterBack(Monster m){
        
    }
    
    public void initCards(){
        
    }
    
}
