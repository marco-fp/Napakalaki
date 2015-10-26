#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

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