#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class SpecificBadConsequence < BadConsequence
  def initialize(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    super(aText,someLevels)
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
  end
  
  def isEmpty()
    if((@specificHiddenTreasures.nil? || @specificHiddenTreasures.empty?) &&
           (@specificVisibleTreasures.nil? || @specificVisibleTreasures.empty? ) )
            return true
    end
      return false
  end
  
  def substractVisibleTreasure(t)
    unless( @specificVisibleTreasures.empty?)
      @specificVisibleTreasures.delete(t.tkind)
    end
  end
  
  def substractHiddenTreasure(t)
    unless( @specificHiddenTreasures.empty?)
      @specificHiddenTreasures.delete(t.tkind)
    end
  end
  
  def adjustToFitTreasureLists(visibles, hidden)
      
      if(@specificVisibleTreasures != nil)
        listaAjustadaVisibles = Array.new
      else
        listaAjustadaVisibles = nil
      end
      
      if(@specificHiddenTreasures != nil)
        listaAjustadaHidden = Array.new
      else
        listaAjustadaHidden = nil
      end
      
      visibleKind = visibles.collect{|t| t.tkind}
      hiddenKind = hidden.collect{|t| t.tkind}
      
      [TreasureKind::ARMOR,TreasureKind::SHOES,TreasureKind::HELMET,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS].each do |tKind|
        if(@specificVisibleTreasures != nil)
          listaAjustadaVisibles = listaAjustadaVisibles + 
          [tKind]*[visibleKind.select{|t| t == tKind}.size, @specificVisibleTreasures.select{|t| t == tKind}.size].min
        end
        if(@specificHiddenTreasures != nil)
        listaAjustadaHidden = listaAjustadaHidden + 
          [tKind]*[hiddenKind.select{|t| t == tKind}.size, @specificHiddenTreasures.select{|t| t == tKind}.size].min
        end
      end 
      return SpecificBadConsequence.new(@text,0,listaAjustadaVisibles,listaAjustadaHidden)
  end
  
  attr_reader :specificVisibleTreasures, :specificHiddenTreasures
  public_class_method :new
  
  def to_s
    "--- Bad Consequence Especifico --- \n
    Texto: #{@text} \n Niveles: #{@levels} \n
    SpecificVisible: #{@specificVisibleTreasures} \n
    SpecificHidden: #{@specificHiddenTreasures} \n"
  end
end
