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
  
  def initialize
    @currentplayer = nil
    @players = Array.new
    @dealer = CardDealer.instance
    @currentmonster = nil
  end
  
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
  
  private_class_method :new
  private :initplayers,:nextplayer,:nextturnallowed,:setenemies
  
end

puts "It's working. (Kind of)"

=begin
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

=end

#nivel_superior_10(monsters)
#solo_perdida_niveles(monsters)
#ganancia_sup_1(monsters)

# TODO: imprimir info de los arrays especificos.
# perdida_especifica(monsters)