#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class BadConsequence
  
  @@MAXTREASURES = 10
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  
  def isEmpty()
    if(@nVisibleTreasures == 0 && @nHiddenTreasures == 0 && (@specificHiddenTreasures.nil? || @specificHiddenTreasures.empty?) &&
           (@specificVisibleTreasures.nil? || @specificVisibleTreasures.empty? ) )
            return true
    end
    return false
  end
  
  def substractVisibleTreasure(t)
    
  end
  
  def substractHiddenTreasure(t)
    
  end
  
  def adjustToFitTreasureLists(v,h)
    
  end
  
  private_class_method :new
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :specificVisibleTreasures, :specificHiddenTreasures
  
  def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText,someLevels,someVisibleTreasures, someHiddenTreasures,nil,nil,false)
  end
  
  def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, 0,0,someSpecificVisibleTreasures,someSpecificHiddenTreasures,false)
  end
  
  def self.newDeath(aText,death)
    new(aText,0,0,0,nil,nil,death)
  end
  
  def to_s
    "--- Bad Consequence --- \n
    Texto: #{@text} \n Niveles: #{@levels} \n
    nVisibles: #{@nVisibleTreasures} \n
    nHidden: #{@nHiddenTreasures} \n
    SpecificVisible: #{@specificVisibleTreasures} \n
    SpecificHidden: #{@specificHiddenTreasures} \n
    Death: #{@death} \n"
  end
  
end
