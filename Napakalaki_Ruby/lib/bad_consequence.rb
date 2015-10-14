#encoding: utf-8

class BadConsequence
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @SpecificVisibleTreasures = someSpecificVisibleTreasures
    @SpecificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  
  private_class_method :new
  attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death
  
  def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText,someLevels,someVisibleTreasures, someHiddenTreasures,nil,nil,false)
  end
  
  def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, nil,nil,someSpecificVisibleTreasures,someSpecificHiddenTreasures,false)
  end
  
  def self.newDeath(aText)
    new(aText,nil,nil,nil,nil,nil,true)
  end
  
  def to_s
    "--- Bad Consequence --- \n
    Texto: #{@text} \n Niveles: #{@levels} \n
    nVisibles: #{@nVisibleTreasures} \n
    nHidden: #{@nHiddenTreasures} \n
    SpecificVisible: #{@SpecificVisibleTreasures.to_s} \n
    SpecificHidden: #{@SpecificHiddenTreasures.to_s} \n
    Death: #{@death} \n"
  end
  
end
