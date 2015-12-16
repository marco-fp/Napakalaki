/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {
    
    Monster currentMonster = null;
    CardDealer dealer = null;
    Player currentPlayer = null;
    ArrayList<Player> players = null;
    
    private static final Napakalaki instance = new Napakalaki();
    
    private Napakalaki(){
        
        dealer = CardDealer.getInstance();
        players = new ArrayList();
        
    };
    
    private void initPlayers(ArrayList<String> names){
        for(String name : names){
            players.add(new Player(name));
        }
    }
    
    private Player nextPlayer(){
        int indice;
        // Primera jugada
        if(currentPlayer == null){
            Random rand = new Random();
            indice = rand.nextInt(players.size());
            currentPlayer = players.get(indice);
        }
        // No es la primera jugada
        else{
            indice = players.indexOf(currentPlayer);
            if(indice==(players.size()-1))
                indice = 0;
            else
                indice++;
            currentPlayer = players.get(indice);
        }
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if(currentPlayer == null)
            return true;
        else{
            return currentPlayer.validState();
        }
    }
    
    private void setEnemies(){
        int indiceEnemigo = players.size()+1; // Siempre inicia fuera de rango
        Random rand = new Random();
        for(Player player: players){
            indiceEnemigo = rand.nextInt(players.size());
            while(indiceEnemigo == players.indexOf(player)){
                indiceEnemigo = rand.nextInt(players.size());
            }
            player.setEnemy(players.get(indiceEnemigo));
        }
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }

    public CombatResult developCombat(){
        CombatResult result = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        if(result == CombatResult.LOSEANDCONVERT){
            Cultist cultist = dealer.nextCultist();
            CultistPlayer cultistPlayer = new CultistPlayer(currentPlayer,cultist);
            
            for(Player player : players){
                if(player.getEnemy() == currentPlayer){
                    player.setEnemy(cultistPlayer);
                }
            }
            
            players.set(players.indexOf(currentPlayer), cultistPlayer);
            currentPlayer = cultistPlayer;
        }
        return result;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure treasure : treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }    
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure treasure : treasures){
            currentPlayer.makeTreasureVisible(treasure);
        }
    }
    
    public void initGame(ArrayList<String> names){
        
        initPlayers(names);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            if(dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
        
    }
    
    public boolean endOfGame(CombatResult result){
        if(result == CombatResult.WINGAME)
            return true;
        else
            return false;
    }
    
}
    //public static void main(String[] args) {}