#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class BadConsequence
  
  MAXTREASURES = 10
  
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
    if(@specificVisibleTreasures == nil && @specificHiddenTreasures == nil)
      nVisible = [visibles.size,@nVisibleTreasures].min
      nHidden = [hidden.size,@nHiddenTreasures].min
      return BadConsequence.newLevelNumberOfTreasures(@text,0,nVisible,nHidden)
    else
      
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
      return BadConsequence.newLevelSpecificTreasures(@text,0,listaAjustadaVisibles,listaAjustadaHidden)
    end
  end
  
=begin
FORMA "JAVA-ONICA"
def adjustToFitTreasureLists(visibles, hidden)
    if(@specificVisibleTreasures == nil && @specificHiddenTreasures == nil)
      nVisible = [visibles.size,@nVisibleTreasures].min
      nHidden = [hidden.size,@nHiddenTreasures].min
      return BadConsequence.newLevelnumberOfTreasures(@text,0,nVisible,nHidden)
    else
      
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
      
      [TreasureKind::ARMOR,TreasureKind::SHOES,TreasureKind::HELMET,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS].each do |tipo|
        
        jugador = 0
        badC = 0
        
        if(@specificVisibleTreasures != nil)
          for t in @specificVisibleTreasures
            if(t == tipo)
              badC += 1
            end
          end

          for t in visibles
            if(t.tkind == tipo)
              jugador += 1
            end
          end

          veces = [jugador,badC].min

          veces.times do
            listaAjustadaVisibles << tipo
          end
        end
        
        jugador = 0
        badC = 0
        
        if(@specificHiddenTreasures != nil)
          for t in @specificHiddenTreasures
            if(t == tipo)
              badC += 1
            end
          end

          for t in hidden
            if(t.tkind == tipo)
              jugador += 1
            end
          end

          veces = [jugador,badC].min

          veces.times do
            listaAjustadaHidden << tipo
          end
        end
        
      end 
      return BadConsequence.newLevelSpecificTreasures(@text,0,listaAjustadaVisibles,listaAjustadaHidden)
    end
  end
=end
  
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
