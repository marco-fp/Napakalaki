#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class Player
  
  @@MAXLEVEL = 10
  
  def initialize(name)
    @name = name
    @level = 0
    @dead = true
    @canISteal = true
    @enemy = nil
    @visibleTreasures = Array.new
    @hiddenTreasures = Array.new
    @pendingBadConsequence = nil
  end

  attr_reader :name,:level,:canISteal,:dead,:hiddenTreasures,:visibleTreasures
  attr_writer :pendingBadConsequence, :enemy
  
  def getCombatLevel()
    
    combat_level = @level
    
    for treasure in @visibleTreasures
      combat_level+=treasure.bonus
    end
    
    return combat_level
  end
  
  def bringToLife()
    @dead = false
  end

  def incrementLevels(i)
    @level+=i
  end
  
  def decrementLevels(i)
    @level-=i
  end
  
  def applyPrize(m)
    
  end
  
  def applyBadConsequence(m)
    
  end
  
  def canMakeTreasureVisible(t)
    tipo = t.tkind
    # Si es ARMOR
    if(tipo == TreasureKind::ARMOR)
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ARMOR)
          return false
        end
      end
        return true
      
    # Si es ONEHAND
    elsif(tipo == TreasureKind::ONEHAND)
      numUnaMano = 0
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ONEHAND)
          numUnaMano+=1;
        end
      end
      return (numUnaMano <= 1)
    
    # Si es BOTHHANDS
    elsif(tipo == TreasureKind::BOTHHANDS)
      numUnaMano = 0
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::ONEHAND || treasure.tkind == TreasureKind::BOTHHANDS)
          return false
        end
      end
      return true
     
    # Si es HELMET
    elsif(tipo == TreasureKind::HELMET)
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::SHOES)
          return false
        end
      end
      return true
      
    #Si es SHOE
    else
      for treasure in @visibleTreasures
        if(treasure.tkind == TreasureKind::SHOES)
          return false
        end
      end
      return true
    end
  end
  
  def dieIfNoTreasures()
    
    if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
      @dead = true
    end
    
  end
  
  def combat(m)
    myLevel = getCombatLevel()
    monsterLevel = m.getCombatLevel()
    
    if(myLevel > monsterLevel)
      applyPrize(m)
      if(myLevel >= MAXLEVEL)
        return CombatResult::WINGAME
      else
        return CombatResult::WIN
      end
    else
      applyBadConsequence(m)
      return CombatResult.LOSE
    end
  end
  
  def makeTreasureVisible(t)
    
  end

  def discardVisibleTreasure(t)
    if(@visibleTreasures != nil)
      @visibleTreasures.delete(t)
      if(@pendingBadConsequence != nil && !@pendingBadConsequence.empty?)
        @pendingBadConsequence.substractVisibleTreasure(t)
      end
      dieIfNoTreasures()
    end
  end
  
  def discardHiddenTreasure(t)
    if(@hiddenTreasures != nil)
      @hiddenTreasures.delete(t)
      if(@pendingBadConsequence != nil && !@pendingBadCosnequence.empty?)
        @pendingBadConsequence.substractHiddenTreasure(t)
      end
      dieIfNoTreasure()
    end
  end
  
  def validState()
    
    if(@pendingBadConsequence.isEmpty && @hiddenTreasures.size<=4)
      return true
    end
    return false
    
  end
  
  def howManyVisibleTreasures(tKind)
    contador = 0
    for tesoro in @visibleTreasures
      if(tesoro.tkind == tKind)
        contador = contador + 1
      end
    end
    return contador
  end
  
  def initTreasures()
    
  end
  
  def stealTreasure()
    
  end
  
  def giveMeATreasure()
    return @hiddenTreasures[rand(@hiddenTreasures.size-1)]
  end
  
  def canYouGiveMeATreasure()
    if(! @visibleTreasures.empty? || ! @hiddenTreasures.empty?)
      return true
    end
    return false
  end
  
  def haveStolen()
    @canISteal = false
  end
  
  def discardAllTreasures()
    
  end
  
end
