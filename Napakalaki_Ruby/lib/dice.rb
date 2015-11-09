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
