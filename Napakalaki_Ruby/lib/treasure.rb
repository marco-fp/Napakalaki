

class Treasure
  def initialize(name, bonus,tkind)
    @name = name
    @bonus = bonus
    @tkind = tkind
  end
  
  attr_reader :name,:bonus,:tkind
  
end
