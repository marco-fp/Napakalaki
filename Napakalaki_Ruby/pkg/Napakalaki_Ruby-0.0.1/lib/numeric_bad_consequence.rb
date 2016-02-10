#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class NumericBadConsequence < BadConsequence
  
  def initialize(text, levels, nVisible,nHidden)
    super(text,levels)
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
  end
  
  def isEmpty()
    if(@nVisibleTreasures == 0 && @nHiddenTreasures == 0)
      return true
    end
      return false
  end
  
  def adjustToFitTreasureLists(visibles, hidden)
      nVisible = [visibles.size,@nVisibleTreasures].min
      nHidden = [hidden.size,@nHiddenTreasures].min
      return NumericBadConsequence.new(@text,0,nVisible,nHidden)
  end
  
    def to_s
      "--- Bad Consequence Numerico --- \n
      Texto: #{@text} \n Niveles: #{@levels} \n
      nVisibles: #{@nVisibleTreasures} \n
      nHidden: #{@nHiddenTreasures} \n"
    end
    
    attr_reader :nVisibleTreasures, :nHiddenTreasures
    public_class_method :new
end
