/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();
    
    
    ArrayList<Monster> unusedMonsters = null;
    ArrayList<Monster> usedMonsters = null;
    ArrayList<Treasure> unusedTreasures = null;
    ArrayList<Treasure> usedTreasures = null;
    ArrayList<Cultist> unusedCultists = null;
    ArrayList<Cultist> usedCultists = null;
    
    private CardDealer(){
        
        this.unusedMonsters = new ArrayList();
        this.usedMonsters = new ArrayList();
        this.unusedTreasures = new ArrayList();
        this.usedTreasures = new ArrayList();
        this.unusedCultists = new ArrayList();
        this.usedCultists = new ArrayList();

    }
    
    static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck() {
        Treasure tesoro = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de investigación", 3, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("A prueba de balas", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS); // ¿ BOTHHANDS ?
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Casco minero", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Fez alópodo", 3, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Gaita", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Insecticida", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Garabato místico", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necrotelecom", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Porra prenatural", 2, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET);
        unusedTreasures.add(tesoro);

        tesoro = new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES);
        unusedTreasures.add(tesoro);
    }
    
    private void initCultistCardDeck(){
        unusedCultists.add(new Cultist("Cultist",1));
        unusedCultists.add(new Cultist("Cultist",1));
        unusedCultists.add(new Cultist("Cultist",1));
        unusedCultists.add(new Cultist("Cultist",1));
        unusedCultists.add(new Cultist("Cultist",2));
        unusedCultists.add(new Cultist("Cultist",2));
    }

    private void initMonsterCardDeck(){
        
        BadConsequence bc;
        Prize prize;
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        // El Rey de Rosa
       bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("El rey de rosa", 13, bc, prize));
       
       // Ángeles de la noche ibicenca
 
       tVisible.add(TreasureKind.ONEHAND);
       tHidden.add(TreasureKind.ONEHAND);
       bc = new SpecificBadConsequence("Tatrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
               + "Descarta 1 mano visible y 1 mano oculta.", 0, tVisible, tHidden);
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, bc, prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // 3 Byakhees de bonanza
       tVisible.add(TreasureKind.ARMOR);
       tHidden.add(TreasureKind.ARMOR);
       bc = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta.",0,tVisible,tHidden);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // Chibithulhu
       tVisible.add(TreasureKind.HELMET);
       bc = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.",
       0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Chibithulhu",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El sopor de Dunwich
       tVisible.add(TreasureKind.SHOES);
       bc = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El sopor de Dunwich",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El gorrón en el umbral
       
       bc = new NumericBadConsequence("Pierdes todos tus tesoros visibles.",0,BadConsequence.MAXTREASURES,0);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El gorrón en el umbral",10,bc,prize));
       
       
       // H.P Munchcraft
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new SpecificBadConsequence("Pierdes la armadura visible.",0,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("H.P. Munchcraft",6,bc,prize));
       
       tVisible = new ArrayList();
       
       // Bichgooth
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bichgooth",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // La que redacta en las tinieblas
       
       bc = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,bc,prize));
       
       // Los hondos
       
       bc = new DeathBadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estás muerto.");
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Los hondos",8,bc,prize));
       
       // Semillas Cthulhu
       
       bc = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Semillas Cthulhu",4,bc,prize));
       
       // Dameargo
       
       tVisible.add(TreasureKind.ONEHAND);
       bc = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Dameargo",1,bc,prize));
       
       tVisible = new ArrayList();
       
       // Pollipólipo volante
       
       bc = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Pollipólipo volante",3,bc,prize));
       
       // Yskhtihyssg-Goth
       
       bc = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto");
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12,bc,prize));
       
       // Familia feliz
       
       bc = new DeathBadConsequence("La familia te atrapa. Estás muerto");
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Familia feliz",1,bc,prize));
       
       // Roboggoth
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de las dos manos visible.",2,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Roboggoth",8,bc,prize));
       
       tVisible = new ArrayList();
       
       // El espia
       
       tVisible.add(TreasureKind.HELMET);
       bc = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El espia",5,bc,prize));
       
       tVisible = new ArrayList();
       
       // El lenguas
       
       bc = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El lenguas",20,bc,prize));
       
       // Bicéfalo
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las dos manos.",3,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bicéfalo",20,bc,prize));
       
       tVisible = new ArrayList();
       
       tVisible.add(TreasureKind.ONEHAND);
       bc = new SpecificBadConsequence("Pierdes 1 mano visible",0,tVisible,null);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El mal indecible impronunciable",10,bc,prize,-2));
       
       tVisible = new ArrayList();
       
       bc = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence.MAXTREASURES,0);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Testigos Oculares",6,bc,prize,+2));
       
       bc = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.");
       prize = new Prize(2,5);
       unusedMonsters.add(new Monster("El gran chulhu",20,bc,prize,+4));
       
       bc = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Serpiente Político",8,bc,prize,-2));
       
       tVisible.add(TreasureKind.ARMOR);
       tVisible.add(TreasureKind.HELMET);
       tHidden.add(TreasureKind.BOTHHANDS);
       bc = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,tVisible,tHidden);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Felpuggoth",2,bc,prize,+5));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList(); 
       
       bc = new NumericBadConsequence("Pierdes 2 niveles.",2,0,0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("Shoggoth",16,bc,prize,-4));
       
       bc = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",2,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Lolitagooth",2,bc,prize,+3));
    }
    
    // Iterar sobre cada elemento del array, cambiandolo de sitio a una posición aleatoria. 
    private void shuffleTreasures(){
        Random random = new Random();
        for(int i = 0; i < unusedTreasures.size(); i++){
            
            int pos_nueva = random.nextInt(unusedTreasures.size());
            Treasure aux = unusedTreasures.get(pos_nueva);
            unusedTreasures.set(pos_nueva, unusedTreasures.get(i));
            unusedTreasures.set(i, aux);
        }       
    }
    
    private void shuffleCultists(){
        Random random = new Random();
        for(int i = 0; i < unusedCultists.size(); i++){
            
            int pos_nueva = random.nextInt(unusedCultists.size());
            Cultist aux = unusedCultists.get(pos_nueva);
            unusedCultists.set(pos_nueva, unusedCultists.get(i));
            unusedCultists.set(i, aux);
        }      
    }
    
    private void shuffleMonsters() {
        Random random = new Random();
        for (int i = 0; i < unusedMonsters.size(); i++) {

            int pos_nueva = random.nextInt(unusedMonsters.size());
            Monster aux = unusedMonsters.get(pos_nueva);
            unusedMonsters.set(pos_nueva, unusedMonsters.get(i));
            unusedMonsters.set(i, aux);
        }
    }
    
    public Cultist nextCultist(){
        if(unusedCultists.isEmpty()){
            ArrayList<Cultist> punteroAux = unusedCultists;
            unusedCultists = usedCultists;
            usedCultists = punteroAux;
            shuffleTreasures();
        }
        return unusedCultists.remove(0);
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            ArrayList<Treasure> punteroAux = unusedTreasures;
            unusedTreasures = usedTreasures;
            usedTreasures = punteroAux;
            shuffleTreasures();
        }
        return unusedTreasures.remove(0);
    }
    
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            ArrayList<Monster> punteroAux = unusedMonsters;
            unusedMonsters = usedMonsters;
            usedMonsters = punteroAux;
            shuffleMonsters();
        }
        return unusedMonsters.remove(0);
    }
    
    // ¿Lo borro de unused?
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }

    // ¿Lo borro de unused?
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
    }
    
}
