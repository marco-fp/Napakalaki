#encoding: utf-8

=begin
  Marco Manuel Fernández Pranno, 2015 (Granada)
  Para la asignatura PDOO (Universidad de Granada)
  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
=end 

class BadConsequence
  
  MAXTREASURES = 10
  
  def initialize(aText, someLevels)
    @text = aText
    @levels = someLevels
  end
  
  def isEmpty()
    return true
  end
  
  def substractVisibleTreasure(t)
    
  end
  
  def substractHiddenTreasure(t)
    
  end
  
  def adjustToFitTreasureLists(visibles, hidden)
    return nil
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
  attr_reader :text, :levels
  
  def to_s
    "--- Bad Consequence Generico --- \n
    Texto: #{@text} \n Niveles: #{@levels} \n"
  end
  
end
