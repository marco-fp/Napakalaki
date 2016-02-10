/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package NapakalakiGame;

public enum TreasureKind {
    ARMOR, ONEHAND, BOTHHANDS, HELMET, SHOES;


    @Override
    public String toString(){
        if(this == TreasureKind.ARMOR)
            return "Armor";
        if(this == TreasureKind.ONEHAND)
            return "One hand";
        if(this == TreasureKind.BOTHHANDS)
            return "Both hands";
        if(this == TreasureKind.HELMET)
            return "Helmet";
        if(this == TreasureKind.SHOES)
            return "Shoes";
        return null;
    };
}
