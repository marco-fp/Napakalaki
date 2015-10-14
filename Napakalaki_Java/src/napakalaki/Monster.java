/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Javier Escobar Cerezo, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package napakalaki;

public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.badConsequence = bc;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public Prize getPrize() {
        return prize;
    }

    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    
    @Override
    public String toString(){
        return "--- Monstruo --- \n" + "Nombre: " + name + "\n Nivel de combate: " + combatLevel + "\n"
                + "Tesoro: \n" + prize.toString() + "\n Mal rollo: \n" + badConsequence.toString();
        
        
    }
    
}
