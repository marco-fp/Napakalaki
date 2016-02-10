#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

require 'singleton'
require_relative 'treasure'
require_relative 'cultist'
require_relative 'cultist_player'
require_relative 'specific_bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'death_bad_consequence'

class CardDealer
  include Singleton
  
  def initialize()
    @usedMonsters = Array.new
    @unusedMonsters = Array.new
    
    @usedTreasures = Array.new
    @unusedTreasures = Array.new
    
    @unusedCultists = Array.new
    @usedCultists = Array.new
    
  end
  
  def initCultistCardDeck()
    @unusedCultists << Cultist.new("Cultist",1)
    @unusedCultists << Cultist.new("Cultist",1)
    @unusedCultists << Cultist.new("Cultist",1)
    @unusedCultists << Cultist.new("Cultist",1)
    @unusedCultists << Cultist.new("Cultist",2)
    @unusedCultists << Cultist.new("Cultist",2)
  end
  
  def initTreasureCardDeck()
    @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOES)
    @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("A prueba de balas", 2, TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS) # ¿ BOTHHANDS ?
    @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Fez alópodo", 3, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
    @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necrocomicón", 1, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Necrognomicón", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Necroplayboycón", 3, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Porra prenatural", 2, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
    @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
    @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
    @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
    
  end
  
  def initMonsterCardDeck()

    prize = Prize.new(2,1)
    bad_consequence = SpecificBadConsequence.new('Pierdes tu armadura visible y otra oculta', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @unusedMonsters << Monster.new('3 Byakhees de bonanza',8,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new('Embobados con el lindo primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], nil)
    @unusedMonsters << Monster.new('Chibithulhu',2,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new('El primordial bostezo contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES],nil)
    @unusedMonsters << Monster.new('El sopor de Dunwich',2,prize,bad_consequence)

    prize = Prize.new(4,1)
    bad_consequence = SpecificBadConsequence.new('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta',0,
    [TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
    @unusedMonsters << Monster.new('Ángeles de la noche ibicenca',14,prize,bad_consequence)

    prize = Prize.new(3,1)
    bad_consequence = NumericBadConsequence.new('Pierdes todos tus tesoros visibles.', 0, BadConsequence::MAXTREASURES, 0)
    @unusedMonsters << Monster.new('El gorrón en el umbral', 10, prize, bad_consequence)

    prize = Prize.new(2,1)
    bad_consequence = SpecificBadConsequence.new('Pierdes la armadura visible', 0, [TreasureKind::ARMOR],nil)
    @unusedMonsters << Monster.new('H.P Munchcraft',6,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new('Sientes bichos bajo la ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR],nil)
    @unusedMonsters << Monster.new('Bichgooth',2,prize,bad_consequence)

    prize = Prize.new(4,2)
    bad_consequence = NumericBadConsequence.new('Pierdes 5 niveles y 3 tesoros visibles', 5, 3, 0)
    @unusedMonsters << Monster.new('El rey de rosa', 13, prize, bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = NumericBadConsequence.new('Toses los pulmones y pierdes 2 niveles.', 2, 0,0)
    @unusedMonsters << Monster.new('La que redacta en las tinieblas.',2,prize,bad_consequence)

    prize = Prize.new(2,1)
    bad_consequence = DeathBadConsequence.new('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.')
    @unusedMonsters << Monster.new('Los hondos',8, prize, bad_consequence)

    prize = Prize.new(2,1)
    bad_consequence = NumericBadConsequence.new('Pierdes 2 niveles y 2 tesoros ocultos.',2,0,2)
    @unusedMonsters << Monster.new('Semillas Cthulhu', 4, prize, bad_consequence)

    prize = Prize.new(2,1)
    bad_consequence = SpecificBadConsequence.new('Te intentas escaquear. Pierdes una mano visible.',0, [TreasureKind::ONEHAND],nil)
    @unusedMonsters << Monster.new('Dameargo', 1, prize, bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = NumericBadConsequence.new('Da mucho asquito. Pierdes 3 niveles.', 3, 0,0)
    @unusedMonsters << Monster.new('Pollipólipo volante',3,prize,bad_consequence)

    prize = Prize.new(3,1)
    bad_consequence = DeathBadConsequence.new('No lo hace mucha gracia que pronuncien mal su nombre. Estás muerto.')
    @unusedMonsters << Monster.new('Yskhtihyssg-Goth',12,prize,bad_consequence)

    prize = Prize.new(4,1)
    bad_consequence = DeathBadConsequence.new('La familia te atrapa. Estás muerto.')
    @unusedMonsters << Monster.new('Familia Feliz',1,prize,bad_consequence)

    prize = Prize.new(2,1)
    bad_consequence = SpecificBadConsequence.new('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de ambas manos visible.', 
      2, [TreasureKind::BOTHHANDS],nil)
    @unusedMonsters << Monster.new('Roboggoth',8,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new('Te asusta en la noche. Pierdes un casco visible.',0,[TreasureKind::HELMET],nil)
    @unusedMonsters << Monster.new('El espía',5,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = NumericBadConsequence.new('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5,0)
    @unusedMonsters << Monster.new('El lenguas',20,prize,bad_consequence)

    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las dos manos.',
      3, [TreasureKind::BOTHHANDS],nil)
    @unusedMonsters << Monster.new('Bicéfalo',20,prize,bad_consequence)
    
    prize = Prize.new(3,1)
    bad_consequence = SpecificBadConsequence.new("Pierdes 1 mano visible", 0, [TreasureKind::ONEHAND],nil)
    @unusedMonsters << Monster.new("El mal indecible impronunciable", 10, prize, bad_consequence, -2)
    
    prize = Prize.new(2,1)
    bad_consequence = NumericBadConsequence.new("Pierdes tus tesoros visibles. Jajaja.",0,BadConsequence::MAXTREASURES, 0)
    @unusedMonsters << Monster.new("Testigos Oculares",6,prize,bad_consequence,+2)
    
    prize = Prize.new(2,5)
    bad_consequence = DeathBadConsequence.new("Hoy no es tu día de suerte. Mueres.")
    @unusedMonsters << Monster.new("El gran cthulhu",20,prize,bad_consequence,+4)
    
    prize = Prize.new(2,1)
    bad_consequence = NumericBadConsequence.new("Tu gobierno te recorta 2 niveles.", 2, 0,0)
    @unusedMonsters << Monster.new("Serpiente Político",8,prize,bad_consequence,-2)
    
    prize = Prize.new(1,1)
    bad_consequence = SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,[TreasureKind::ARMOR,TreasureKind::HELMET],[TreasureKind::BOTHHANDS])
    @unusedMonsters << Monster.new("Felpuggoth",2,prize,bad_consequence,+5)
    
    prize = Prize.new(4,2)
    bad_consequence = NumericBadConsequence.new("Pierdes 2 niveles",2,0,0)
    @unusedMonsters << Monster.new("Shoggoth",16,prize,bad_consequence,-4)
    
    prize = Prize.new(1,1)
    bad_consequence = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles.",2,0,0)
    @unusedMonsters << Monster.new("Lolitagooth",2,prize,bad_consequence,+3)
    
  end
  
  def shuffleCultists()
    
    @unusedCultists.each_with_index { |cultist,indice| 
      
      pos_nueva = rand(@unusedCultists.size-1)
      aux = @unusedCultists[pos_nueva]
      @unusedCultists[indice] = aux
      @unusedCultists[pos_nueva] = cultist
      
    }
  end
  
  def shuffleTreasures()
    
    @unusedTreasures.each_with_index { |tesoro,indice| 
      
      pos_nueva = rand(@unusedTreasures.size-1)
      aux = @unusedTreasures[pos_nueva]
      @unusedTreasures[indice] = aux
      @unusedTreasures[pos_nueva] = tesoro
      
    }
      
  end
  
  def shuffleMonsters()
    
    @unusedMonsters.each_with_index { |monstruo,indice| 
      
      pos_nueva = rand(@unusedMonsters.size-1)
      aux = @unusedMonsters[pos_nueva]
      @unusedMonsters[indice] = aux
      @unusedMonsters[pos_nueva] = monstruo
      
    }
  end
  
  def nextCultist()
    if(@unusedCultists.empty?)
      punteroAux = @unusedCultists
      @unusedCultists = @usedCultists
      @usedCultists = punteroAux
      shuffleCultists()
    end
    nextC = @unusedCultists[0]
    @unusedCultists.delete_at(0)
    return nextC
  end
  
  def nextTreasure()
    if(@unusedTreasures.empty?)
      punteroAux = @unusedTreasures
      @unusedTreasures = @usedTreasures
      @usedTreasures = punteroAux
      shuffleTreasures()
    end
    nextT = @unusedTreasures[0]
    @unusedTreasures.delete_at(0)
    return nextT
  end
  
  def nextMonster()
    if(@unusedMonsters.empty?)
      punteroAux = @unusedMonsters
      @unusedMonsters = @usedMonsters
      @usedMonsters = punteroAux
      shuffleMonsters()
    end
    nextM = @unusedMonsters[0]
    @unusedMonsters.delete_at(0)
    return nextM
  end
  
  def giveTreasureBack(t)
    
    @usedTreasures << t
    @unusedTreasures.delete(t)
    
  end
  
  def giveMonsterBack(m)
    
    @usedMonsters << m
    @unusedMonsters.delete(m)
    
  end
  
  def initCards()
    initTreasureCardDeck()
    initMonsterCardDeck()
    initCultistCardDeck()
  end
  
  private_class_method :new
  private :initTreasureCardDeck,:initMonsterCardDeck,:shuffleTreasures,:shuffleMonsters
end
