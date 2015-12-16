package napakalaki;

import java.util.Random;

public class CultistPlayer extends Player {
    
    static private int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player player, Cultist c) {
        super(player);
        this.myCultistCard = c;
        totalCultistPlayers++;
    }
    
    protected int getCombatLevel(){
        float nivel = super.getCombatLevel();
        nivel = (float) (nivel + (nivel*0.2));
        nivel += myCultistCard.getGainedLevels()*totalCultistPlayers;
        return (int) nivel;
    }
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert(){
        return false;
    }

    private Treasure giveMeATreasure(){
        Random rand = new Random(); 
        return visibleTreasures.get(rand.nextInt(visibleTreasures.size()-1));
    }
    
    private boolean canYouGiveMeATreasure(){
        if(!visibleTreasures.isEmpty() || visibleTreasures != null)
            return true;
        else
            return false;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}
