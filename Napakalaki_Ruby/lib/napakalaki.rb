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
require_relative 'card_dealer'
require_relative 'player'

require 'singleton'


class Napakalaki 
  
  include Singleton
  
  def initialize
    @currentPlayer = nil
    @players = Array.new
    @dealer = CardDealer.instance
    @currentMonster = nil
  end
  
  def initPlayers( names )
    for name in names
        @players << Player.new(name)
    end
  end
  
  def nextPlayer()
        # Primera jugada
        if (@currentPlayer == nil)
            indice = rand(@players.size)
            @currentPlayer = @players[indice]
        # No es la primera jugada
        else
            indice = @players.index(@currentPlayer)
            if(indice == @players.size-1)
              indice = 0
            else
              indice += 1
            end
            @currentPlayer = @players[indice]
        end 
        return @currentPlayer;
  end
  
  def nextTurnIsAllowed()
    if(@currentPlayer == nil)
      return true
    else
      return @currentPlayer.validState
    end
  end
  
  def setEnemies()
    indiceEnemigo = @players.size+1
    for player in @players
      loop do
        indiceEnemigo = rand(@players.size)
        break if(indiceEnemigo != @players.index(player))
      end 
      player.enemy = @players[indiceEnemigo]
    end
  end
  
  def developCombat()
    
    result = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    if(result == CombatResult::LOSEANDCONVERT)
      cultist = @dealer.nextCultist
      cultistPlayer = CultistPlayer.new(@currentPlayer, cultist)
      
      for player in @players
          if(player.enemy == @currentPlayer)
            player.enemy = cultistPlayer
          end
      end
      
      @players[@players.index(@currentPlayer)] = cultistPlayer
      @currentPlayer = cultistPlayer
    end
    
    return result
  end
  
  def discardVisibleTreasures(treasures)
    for treasure in treasures
      @currentPlayer.discardVisibleTreasure(treasure)
      @dealer.giveTreasureBack(treasure)
    end
  end
  
  def discardHiddenTreasures(treasures)
    for treasure in treasures
      @currentPlayer.discardVisibleTreasure(treasure)
      @dealer.giveTreasureBack(treasure)
    end
  end
  
  def makeTreasuresVisible(treasures)
    for treasure in treasures
      @currentPlayer.makeTreasureVisible(treasure)
    end
  end
  
  def initGame(names)
    initPlayers(names)
    setEnemies()
    CardDealer.instance.initCards()
    nextTurn()
  end
  
  def getCurrentPlayer()
    @currentPlayer
  end
  
  def getCurrentMonster()
    @currentMonster
  end
  
  def nextTurn()
    stateOK = nextTurnIsAllowed()
    if(stateOK)
      @currentMonster = @dealer.nextMonster()
      @currentPlayer = nextPlayer()
      dead = @currentPlayer.dead
      if(dead)
        @currentPlayer.initTreasures()
      end
    end
    return stateOK
  end
  
  def endOfGame(result)
    if(result == CombatResult::WINGAME)
      return true
    else
      return false
    end
  end
  
  private_class_method :new
  private :initPlayers,:nextPlayer,:nextTurnIsAllowed,:setEnemies
  
end

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