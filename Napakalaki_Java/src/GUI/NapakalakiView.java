/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package GUI;

import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;
import static java.lang.System.exit;
import javax.swing.JOptionPane;

public class NapakalakiView extends javax.swing.JFrame {

    Napakalaki napakalakiModel;
    
    public NapakalakiView() {
        initComponents();
    }
    
    public void faseUno(){
        if (napakalakiModel.getCurrentMonster() != null) {
            monsterView.setMonster(napakalakiModel.getCurrentMonster());
        }
        playerView.setPlayer(napakalakiModel.getCurrentPlayer(),this);
        playerView.setNapakalaki(napakalakiModel);
        
        combatPanel.setVisible(false);
        monsterView.setVisible(false);
        playerView.getPBadConsequenceView().setVisible(false);
        playerView.setBotonRobar(false);
        botonNextTurn.setEnabled(false);
        botonCombat.setEnabled(false);
        botonMeetTheMonster.setEnabled(true);
        
        playerView.update();
        repaint();
    }
    
    public void faseDos(){
        monsterView.setVisible(true);
        botonCombat.setEnabled(true);
        playerView.setBotonesDescartar(false);
        playerView.setBotonMakeVisible(false);
        botonMeetTheMonster.setEnabled(false);
        repaint();
    }
    
    public void faseTres(CombatResult resultadoCombate){
        if(resultadoCombate == CombatResult.WINGAME)
            finDelJuego();
        
        labelCombatResult.setText(resultadoCombate.toString());
        combatPanel.setVisible(true);
        playerView.update();
        playerView.setBotonMakeVisible(true);
        playerView.setBotonesDescartar(true);
        playerView.setBotonRobar(true);
        botonCombat.setEnabled(false);
        update();
        repaint();
    }
    
    public void finDelJuego(){
        JOptionPane.showMessageDialog(null, "¡FIN DEL JUEGO! \n Ha ganado "+playerView.playerModel.getName()+"!");
        exit(0);
    }
    
    public void setNapakalaki(Napakalaki napa){
        napakalakiModel = napa;
        faseUno();
    }
    
    public void update(){
        if(playerView.getPBadConsequenceView().getModel() != null && playerView.getPBadConsequenceView().getModel().isEmpty()){
            botonNextTurn.setEnabled(true);
        }
        
        playerView.update();
        repaint();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonMeetTheMonster = new javax.swing.JButton();
        botonCombat = new javax.swing.JButton();
        botonNextTurn = new javax.swing.JButton();
        combatPanel = new javax.swing.JPanel();
        labelCombatResult = new javax.swing.JLabel();
        monsterView = new GUI.MonsterView();
        playerView = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Napakalaki - Práctica 5 - Marco Manuel Fernández Pranno ( 2016 )");
        setLocation(new java.awt.Point(250, 100));

        botonMeetTheMonster.setText("Meet the monster");
        botonMeetTheMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMeetTheMonsterActionPerformed(evt);
            }
        });

        botonCombat.setText("Combat");
        botonCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCombatActionPerformed(evt);
            }
        });

        botonNextTurn.setText("Next turn");
        botonNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNextTurnActionPerformed(evt);
            }
        });

        combatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Combat Result"));

        labelCombatResult.setText("Resultado");

        javax.swing.GroupLayout combatPanelLayout = new javax.swing.GroupLayout(combatPanel);
        combatPanel.setLayout(combatPanelLayout);
        combatPanelLayout.setHorizontalGroup(
            combatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(combatPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelCombatResult)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        combatPanelLayout.setVerticalGroup(
            combatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(combatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCombatResult)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        monsterView.setBorder(javax.swing.BorderFactory.createTitledBorder("Monstruo"));

        playerView.setBorder(javax.swing.BorderFactory.createTitledBorder("Jugador"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(botonMeetTheMonster)
                .addGap(6, 6, 6)
                .addComponent(botonCombat)
                .addGap(6, 6, 6)
                .addComponent(botonNextTurn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(combatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(combatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonMeetTheMonster)
                    .addComponent(botonCombat)
                    .addComponent(botonNextTurn))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMeetTheMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMeetTheMonsterActionPerformed
        faseDos();
    }//GEN-LAST:event_botonMeetTheMonsterActionPerformed

    private void botonCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCombatActionPerformed
        faseTres(napakalakiModel.developCombat());
    }//GEN-LAST:event_botonCombatActionPerformed

    private void botonNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNextTurnActionPerformed
        playerView.getPBadConsequenceView().setPendingBadConsequence(null);
        boolean success = napakalakiModel.nextTurn();
        if(success){
            labelCombatResult.setText("");
            setNapakalaki(napakalakiModel);
        }
    }//GEN-LAST:event_botonNextTurnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCombat;
    private javax.swing.JButton botonMeetTheMonster;
    private javax.swing.JButton botonNextTurn;
    private javax.swing.JPanel combatPanel;
    private javax.swing.JLabel labelCombatResult;
    private GUI.MonsterView monsterView;
    private GUI.PlayerView playerView;
    // End of variables declaration//GEN-END:variables
}
