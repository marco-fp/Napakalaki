#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class Cultist
  
  def initialize(name,gainedLevels)
    @name = name
    @gainedLevels = gainedLevels
  end
  
  attr_reader :gainedLevels
end