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
            indice = rand.nextInt(players.size()-1);
            currentPlayer = players.get(indice);
        }
        // No es la primera jugada
        else{
            indice = players.indexOf(currentPlayer);
            if(indice==(players.size()-1))
                indice = 0;
            currentPlayer = players.get(indice);
        }
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        return false;
    }
    
    private void setEnemies(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }

    public CombatResult developCombat(){
        return null;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }    
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    
    public void initGame(ArrayList<String> players){
        
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        return false;
    }
    
    public boolean endOfGame(CombatResult result){
        return false;
    }
    
    
    public static void main(String[] args) {
        

       
       //System.out.println(monstruos.get(0).toString());
       //System.out.println(monstruos.get(2).toString());
       //gananciaNivelesSuperiorA1(monstruos);
       //perdidaEspecificaTesoros(monstruos);
       
    }
    

    static public void nivelSuperiorA10(ArrayList<Monster> monstruos){
       System.out.println("--- Monstruos con nivel de combate superior a 10 --- \n");
       for(Monster monstruo: monstruos){
           if(monstruo.getCombatLevel() > 10){
               System.out.println(monstruo.toString());
           }
       }
    }
    
    static public void malRolloPerdidaNiveles(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con mal rollo de pérdida de niveles --- \n");
        for(Monster monstruo: monstruos){
            BadConsequence bc = monstruo.getBadConsequence();
            if(bc.getLevels() != 0 && !bc.isDeath() && bc.getNHiddenTreasures() == 0 && bc.getNVisibleTreasures() == 0
                    && bc.getSpecificHiddenTreasures() == null && bc.getSpecificVisibleTreasures() == null)
            {
                System.out.println(monstruo.toString());
            }
        }
    }
    
    static public void gananciaNivelesSuperiorA1(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con ganancia de niveles superior a 1 --- \n");
        for(Monster monstruo: monstruos){
            if(monstruo.getPrize().getLevel() > 1){
                System.out.println(monstruo.toString());
            }
        }
    }
    
    static public void perdidaEspecificaTesoros(ArrayList<Monster> monstruos){
        System.out.println("--- Monstruos con pérdidas específicas de tesoros --- \n");
        for (Monster monstruo : monstruos) {
            BadConsequence bc = monstruo.getBadConsequence();
            if (bc.getLevels() == 0 && !bc.isDeath() && bc.getNHiddenTreasures() == 0 && bc.getNVisibleTreasures() == 0
                   && (bc.getSpecificHiddenTreasures() != null || bc.getSpecificVisibleTreasures() != null)) {
                System.out.println(monstruo.toString());
            }
        }
    }
    
    
    
    
    
}
