
=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

require 'singleton'

class Dice
  
  include Singleton
  
  def initialize
    
  end
  
  private_class_method :new
  
  def nextNumber()
    return rand(6) + 1
  end
  
end
