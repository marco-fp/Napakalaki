#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class Monster
  
  def initialize(name, level, prize, bc)
    @name = name
    @combatLevel = level
    @prize = prize
    @bc = bc
  end
  
  attr_reader :name, :combatLevel, :bc

  def getlevelsgained()
    @prize.level
  end
  
  def gettreasuresgained()
    @prize.treasures
  end
  
  def to_s
    "--- Monstruo --- \n 
    Nombre: #{@name} \n Nivel de combate: #{@combatLevel} \n
    #{@prize.to_s} \n #{@bc.to_s} \n"
  end
end
