package napakalaki;

import java.util.ArrayList;
import java.util.Random;

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

    private void initMonsterCardDeck(){
        
        BadConsequence bc;
        Prize prize;
        ArrayList<TreasureKind> tVisible = new ArrayList();
        ArrayList<TreasureKind> tHidden = new ArrayList();
        
        // El Rey de Rosa
       bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("El rey de rosa", 13, bc, prize));
       
       // Ángeles de la noche ibicenca
 
       tVisible.add(TreasureKind.ONEHAND);
       tHidden.add(TreasureKind.ONEHAND);
       bc = new BadConsequence("Tatrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
               + "Descarta 1 mano visible y 1 mano oculta.", 0, tVisible, tHidden);
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, bc, prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // 3 Byakhees de bonanza
       tVisible.add(TreasureKind.ARMOR);
       tHidden.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Pierdes tu armadura visible y otra oculta.",0,tVisible,tHidden);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
       
       tVisible = new ArrayList();
       tHidden = new ArrayList();
       
       // Chibithulhu
       tVisible.add(TreasureKind.HELMET);
       bc = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.",
       0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Chibithulhu",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El sopor de Dunwich
       tVisible.add(TreasureKind.SHOES);
       bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El sopor de Dunwich",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // El gorrón en el umbral
       
       bc = new BadConsequence("Pierdes todos tus tesoros visibles.",0,BadConsequence.MAXTREASURES,0);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El gorrón en el umbral",10,bc,prize));
       
       
       // H.P Munchcraft
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Pierdes la armadura visible.",0,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("H.P. Munchcraft",6,bc,prize));
       
       tVisible = new ArrayList();
       
       // Bichgooth
       
       tVisible.add(TreasureKind.ARMOR);
       bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bichgooth",2,bc,prize));
       
       tVisible = new ArrayList();
       
       // La que redacta en las tinieblas
       
       bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,bc,prize));
       
       // Los hondos
       
       bc = new BadConsequence("Estos unusedMonsters resultan bastante superficiales y te aburren mortalmente. Estás muerto.",true);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Los hondos",8,bc,prize));
       
       // Semillas Cthulhu
       
       bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.",2,0,2);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Semillas Cthulhu",4,bc,prize));
       
       // Dameargo
       
       tVisible.add(TreasureKind.ONEHAND);
       bc = new BadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Dameargo",1,bc,prize));
       
       tVisible = new ArrayList();
       
       // Pollipólipo volante
       
       bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Pollipólipo volante",3,bc,prize));
       
       // Yskhtihyssg-Goth
       
       bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto",true);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12,bc,prize));
       
       // Familia feliz
       
       bc = new BadConsequence("La familia te atrapa. Estás muerto",true);
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Familia feliz",1,bc,prize));
       
       // Roboggoth
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de las dos manos visible.",2,tVisible,null);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Roboggoth",8,bc,prize));
       
       tVisible = new ArrayList();
       
       // El espia
       
       tVisible.add(TreasureKind.HELMET);
       bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.",0,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El espia",5,bc,prize));
       
       tVisible = new ArrayList();
       
       // El lenguas
       
       bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El lenguas",20,bc,prize));
       
       // Bicéfalo
       tVisible.add(TreasureKind.BOTHHANDS);
       bc = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las dos manos.",3,tVisible,null);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bicéfalo",20,bc,prize));
       
       tVisible = new ArrayList();
        
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
    
    private void shuffleMonsters() {
        Random random = new Random();
        for (int i = 0; i < unusedMonsters.size(); i++) {

            int pos_nueva = random.nextInt(unusedMonsters.size());
            Monster aux = unusedMonsters.get(pos_nueva);
            unusedMonsters.set(pos_nueva, unusedMonsters.get(i));
            unusedMonsters.set(i, aux);
        }
    }
    
    public Treasure nextTreasure(){
        return null;
    }
    
    public Monster nextMonster(){
        return null;
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
        
    }
    
}
