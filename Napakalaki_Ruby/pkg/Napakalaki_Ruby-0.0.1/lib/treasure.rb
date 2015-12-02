#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class Treasure
  def initialize(name, bonus,tkind)
    @name = name
    @bonus = bonus
    @tkind = tkind
  end
  
  attr_reader :name,:bonus,:tkind
  
  def to_s
    "#{@name}(#{@bonus}-#{@tkind}) \n"
  end
  
end
