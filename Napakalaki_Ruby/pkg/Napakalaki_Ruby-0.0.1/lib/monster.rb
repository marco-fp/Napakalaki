#encoding: utf-8

class Monster
  
  def initialize(name, level, prize, bc)
    @name = name
    @combatLevel = level
    @prize = prize
    @badConsequence = bc
  end
  
  attr_reader :name, :level, :prize, :bc
  
  def to_s
    "--- Monstruo --- \n 
    Nombre: #{@name} \n Nivel de combate: #{@combatLevel} \n
    #{@prize.to_s} \n #{@badConsequence.to_s} \n"
  end
end
