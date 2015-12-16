=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

require_relative 'player'

class CultistPlayer < Player
  
  @@totalCultistPlayers = 0
  
  def initialize(p, c)
    super(nil,p)
    @myCultistCard = c
    @@totalCultistPlayers += 1
  end
  
  def getCombatLevel()
    nivel = @level
    nivel = (nivel + (nivel*0.2))
    nivel += @myCultistCard.gainedLevels*@@totalCultistPlayers
    return nivel.to_i
  end
  
  def getOponentLevel(m)
    return m.getCombatLevelAgainstCultistPlayer
  end
  
  def shouldConvert()
    return false
  end
  
  def giveMeATreasure()
    return @visibleTreasures[rand(@visibleTreasures.size-1)]
  end
  
  def canYouGiveMeATreasure()
    if( @visibleTreasures != nil || ! @visibleTreasures.empty?)
      return true
    end
    return false
  end
  
  def getTotalCultistPlayers
    return @@totalCultistPlayers
  end
end
