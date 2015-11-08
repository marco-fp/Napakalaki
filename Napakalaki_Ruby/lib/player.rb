class Player

  
  def initialize(name)
    @name = name
    @level = 0
    @dead = true
    @canISteal = true
  end

  attr_reader :name,:level,:canISteal,:dead,:hiddentreasures,:visibletreasures
  attr_writer :pendingbadconsequence
  
  def brintolife()
    
  end

  def incrementlevels(i)
    
  end
  
  def decrementlevels(i)
    
  end
  
  def applyprize(m)
    
  end
  
  def applybadconsequence(m)
    
  end
  
  def canmaketreasurevisible(t)
    
  end
  
  def dieifnotreasures()
    
  end
  
  def combat(m)
    
  end
  
  def maketreasurevisible(t)
    
  end
  
  def discardvisibletreasure(t)
    
  end
  
  def discardhiddentreasure(t)
    
  end
  
  def validstate()
    
  end
  
  def initreasures()
    
  end
  
  def stealtreasure()
    
  end
  
  def setenemy(enemy)
    
  end
  
  def givemeatreasure()
    
  end
  
  def canyougivemeatreasure()
    
  end
  
  def havestolen()
    
  end
  
  def discardalltreasures()
    
  end
  
end
