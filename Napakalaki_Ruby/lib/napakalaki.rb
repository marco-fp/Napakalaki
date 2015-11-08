#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'treasure_kind'
require_relative 'monster'
require 'singleton'




class Napakalaki 
  
  include Singleton
  
  def initplayers( names )
    
  end
  
  def nextplayer()
    
  end
  
  def nextturnallowed()
    
  end
  
  def setenemies()
    
  end
  
  def getinstance()
    
  end
  
  def developcombat()
    
  end
  
  def discardvisibletreasures(treasures)
    
  end
  
  def discardhiddentreasures(treasures)
    
  end
  
  def maketreasuresvisible(treasures)
    
  end
  
  def initgame(players)
    
  end
  
  def getcurrentplayer()
    
  end
  
  def nextturn()
    
  end
  
  def endofgame(result)
    
  end
  
  private :initplayers,:nextplayer,:nextturnallowed,:setenemies
  
end

monsters = Array.new

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
monsters << Monster.new('3 Byakhees de bonanza',8,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], nil)
monsters << Monster.new('Chibithulhu',2,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES],nil)
monsters << Monster.new('El sopor de Dunwich',2,prize,bad_consequence)

prize = Prize.new(4,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta',0,
[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
monsters << Monster.new('Ángeles de la noche ibicenca',14,prize,bad_consequence)

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes todos tus tesoros visibles.', 0, [TreasureKind::ARMOR,TreasureKind::SHOES, TreasureKind::BOTHHANDS, 
    TreasureKind::ONEHAND, TreasureKind::HELMET], nil)
monsters << Monster.new('El gorrón en el umbral', 10, prize, bad_consequence)

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible', 0, [TreasureKind::ARMOR],nil)
monsters << Monster.new('H.P Munchcraft',6,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR],0)
monsters << Monster.new('Bichgooth',2,prize,bad_consequence)

prize = Prize.new(4,2)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles', 5, 3, 0)
monsters << Monster.new('El rey de rosa', 13, prize, bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y pierdes 2 niveles.', 2, 0,0)
monsters << Monster.new('La que redacta en las tinieblas.',2,prize,bad_consequence)

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.')
monsters << Monster.new('Los hondos',8, prize, bad_consequence)

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.',2,0,2)
monsters << Monster.new('Semillas Cthulhu', 4, prize, bad_consequence)

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. Pierdes una mano visible.',0, [TreasureKind::ONEHAND],nil)
monsters << Monster.new('Dameargo', 1, prize, bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0,0)
monsters << Monster.new('Pollipólipo volante',3,prize,bad_consequence)

prize = Prize.new(3,1)
bad_consequence = BadConsequence.newDeath('No lo hace mucha gracia que pronuncien mal su nombre. Estás muerto.')
monsters << Monster.new('Yskhtihyssg-Goth',12,prize,bad_consequence)

prize = Prize.new(4,1)
bad_consequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.')
monsters << Monster.new('Familia Feliz',1,prize,bad_consequence)

prize = Prize.new(2,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de ambas manos visible.', 
  2, [TreasureKind::BOTHHANDS],nil)
monsters << Monster.new('Roboggoth',8,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes un casco visible.',0,[TreasureKind::HELMET],nil)
monsters << Monster.new('El espía',5,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5,0)
monsters << Monster.new('El lenguas',20,prize,bad_consequence)

prize = Prize.new(1,1)
bad_consequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las dos manos.',
  3, [TreasureKind::BOTHHANDS],nil)
monsters << Monster.new('Bicéfalo',20,prize,bad_consequence)

def nivel_superior_10(monsters)
  for monster in monsters
    if (monster.combatLevel > 10)
      puts monster
    end
  end
end

def solo_perdida_niveles(monsters)
  for monster in monsters
    bc = monster.bc
    if(bc.levels != 0 && bc.nHiddenTreasures == 0 && bc.nVisibleTreasures == 0 && bc.death == false && 
          bc.specificVisibleTreasures == nil && bc.specificHiddenTreasures == nil)
      puts monster
    end
  end
end

def ganancia_sup_1(monsters)
  for monster in monsters
    prize = monster.prize
    if(prize.level > 1)
      puts monster
    end
  end
end

def perdida_especifica(monsters)
  for monster in monsters
    bc = monster.bc
    if(bc.levels == 0 && bc.nHiddenTreasures == 0 && bc.nVisibleTreasures == 0 && bc.death == false && 
          (bc.specificVisibleTreasures != nil || bc.specificHiddenTreasures != nil))
      puts monster
    end
  end
end

#nivel_superior_10(monsters)
#solo_perdida_niveles(monsters)
#ganancia_sup_1(monsters)

# TODO: imprimir info de los arrays especificos.
 perdida_especifica(monsters)