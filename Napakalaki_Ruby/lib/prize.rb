#encoding: utf-8

class Prize
  
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  attr_reader :treasures
  attr_reader :level
  
  def to_s
    "--- Tesoro --- \n
    Tesoros ganados:  #{@treasure} \n Niveles ganados: #{@levels}"
  end
  
end