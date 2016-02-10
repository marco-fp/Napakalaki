/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */
package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayerView extends javax.swing.JPanel {
    Player playerModel;
    private Napakalaki napakalakiModel;
    NapakalakiView napakalakiView;

    public PlayerView(){
        initComponents();
    }
    
    public void setPlayer(Player p, NapakalakiView napaView){
        napakalakiView = napaView;
        if(p!=null){
            playerModel = p;
            labelNombre.setText(p.getName());
            labelNivel.setText("Nivel: "+Integer.toString(p.getLevels()));
            labelNivelCombate.setText("Nivel combate: "+Integer.toString(p.getCombatLevel()));
            if(playerModel instanceof CultistPlayer){
                labelSectario.setText("Sectario: SI");
            }else{
                labelSectario.setText("Sectario: NO");
            }
            fillTreasurePanel(visibleTPanel,playerModel.getVisibleTreasures());
            fillTreasurePanel(hiddenTPanel,playerModel.getHiddenTreasures());
            
            if(playerModel.getPendingBadConsequence()!=null){
                pendingBadConsequenceView.setPendingBadConsequence(playerModel.getPendingBadConsequence());
                pendingBadConsequenceView.setVisible(true);
            }else
                pendingBadConsequenceView.setVisible(false);
            
            
            if(playerModel.getHiddenTreasures().isEmpty() && playerModel.getVisibleTreasures().isEmpty()){
                botonDiscardTreasure.setEnabled(false);
                botonDiscardAllTreasures.setEnabled(false);
            } else{
                botonDiscardTreasure.setEnabled(true);
                botonDiscardAllTreasures.setEnabled(true);
            }
            
            botonMakeVisible.setEnabled(!playerModel.getHiddenTreasures().isEmpty());

            botonStealTreasure.setEnabled(playerModel.canISteal());

            
            repaint();
            revalidate();
        }
    }
    
    public void update(){
        setPlayer(playerModel, napakalakiView);
        repaint();
    }
    
    public GUI.PendingBadConsequenceView getPBadConsequenceView() {
        return pendingBadConsequenceView;
    }
    
    public void setNapakalaki(Napakalaki nap){
        napakalakiModel = nap;
    }

    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        aPanel.removeAll();
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if (tv.isSelected()) {
                output.add(tv.getTreasure());
            }
        }
        return output;
    }
    
    private ArrayList<Treasure> getAllTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            output.add(tv.getTreasure());
        }
        return output;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        labelEnemigo = new javax.swing.JLabel();
        labelNivelCombate = new javax.swing.JLabel();
        labelSectario = new javax.swing.JLabel();
        visibleTPanel = new javax.swing.JPanel();
        hiddenTPanel = new javax.swing.JPanel();
        botonStealTreasure = new javax.swing.JButton();
        botonMakeVisible = new javax.swing.JButton();
        botonDiscardTreasure = new javax.swing.JButton();
        botonDiscardAllTreasures = new javax.swing.JButton();
        pendingBadConsequenceView = new GUI.PendingBadConsequenceView();

        labelNombre.setText("Nombre");

        labelNivel.setText("Nivel");

        labelEnemigo.setText("Enemigo");

        labelNivelCombate.setText("Nivel de combate");

        labelSectario.setText("Sectario");

        visibleTPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros visibles"));

        hiddenTPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros ocultos")));

        botonStealTreasure.setText("Steal treasure");
        botonStealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonStealTreasureActionPerformed(evt);
            }
        });

        botonMakeVisible.setText("Make visible");
        botonMakeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMakeVisibleActionPerformed(evt);
            }
        });

        botonDiscardTreasure.setText("Discard treasure");
        botonDiscardTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiscardTreasureActionPerformed(evt);
            }
        });

        botonDiscardAllTreasures.setText("Discard all treasures");
        botonDiscardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDiscardAllTreasuresActionPerformed(evt);
            }
        });

        pendingBadConsequenceView.setBorder(javax.swing.BorderFactory.createTitledBorder("Bad Consequence pendiente"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNivel)
                    .addComponent(labelNivelCombate)
                    .addComponent(labelEnemigo)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSectario)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonStealTreasure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMakeVisible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDiscardTreasure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonDiscardAllTreasures))
                    .addComponent(visibleTPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addComponent(hiddenTPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(28, 28, 28)
                        .addComponent(labelNivel)
                        .addGap(1, 1, 1)
                        .addComponent(labelNivelCombate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEnemigo)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(labelSectario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(visibleTPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hiddenTPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonStealTreasure)
                    .addComponent(botonMakeVisible)
                    .addComponent(botonDiscardTreasure)
                    .addComponent(botonDiscardAllTreasures))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonMakeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMakeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTPanel);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
    }//GEN-LAST:event_botonMakeVisibleActionPerformed

    private void botonStealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonStealTreasureActionPerformed
        Treasure aTreasure = napakalakiModel.getCurrentPlayer().stealTreasure();
        if(aTreasure == null){
            JOptionPane.showMessageDialog(null, "No has podido robar nada!");
        } else{
            JOptionPane.showMessageDialog(null, "Has robado un tesoro!");
        }
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
    }//GEN-LAST:event_botonStealTreasureActionPerformed

    private void botonDiscardTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiscardTreasureActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTPanel);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTPanel);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer(), napakalakiView);
        napakalakiView.update();
        System.out.println("niveles: "+playerModel.getPendingBadConsequence().getLevels()+"\n");
        System.out.println("nVisible: "+playerModel.getPendingBadConsequence().getNVisibleTreasures()+"\n");
        System.out.println("nHidden: "+playerModel.getPendingBadConsequence().getNHiddenTreasures()+"\n");
        System.out.println("Empty?: "+playerModel.getPendingBadConsequence().isEmpty()+"\n");
        pendingBadConsequenceView.setPendingBadConsequence(playerModel.getPendingBadConsequence());
    }//GEN-LAST:event_botonDiscardTreasureActionPerformed

    private void botonDiscardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDiscardAllTreasuresActionPerformed
        ArrayList<Treasure> selHidden = getAllTreasures(hiddenTPanel);
        ArrayList<Treasure> selVisible = getAllTreasures(visibleTPanel);
        napakalakiModel.discardHiddenTreasures(selHidden);
        napakalakiModel.discardVisibleTreasures(selVisible);
        setPlayer(napakalakiModel.getCurrentPlayer(),napakalakiView);
        pendingBadConsequenceView.setPendingBadConsequence(playerModel.getPendingBadConsequence());
    }//GEN-LAST:event_botonDiscardAllTreasuresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonDiscardAllTreasures;
    private javax.swing.JButton botonDiscardTreasure;
    private javax.swing.JButton botonMakeVisible;
    private javax.swing.JButton botonStealTreasure;
    private javax.swing.JPanel hiddenTPanel;
    private javax.swing.JLabel labelEnemigo;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelNivelCombate;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSectario;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView;
    private javax.swing.JPanel visibleTPanel;
    // End of variables declaration//GEN-END:variables
}
