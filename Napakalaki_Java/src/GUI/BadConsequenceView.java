/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.Player;

public class BadConsequenceView extends javax.swing.JPanel {
    
    BadConsequence badConsequenceModel;
    
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence bc){
        badConsequenceModel = bc;
        if(bc!=null){
            labelText.setText(bc.getText());

            if(bc.getLevels() == Player.MAXLEVEL && bc.getNVisibleTreasures() == BadConsequence.MAXTREASURES && bc.getNHiddenTreasures() == BadConsequence.MAXTREASURES){
                jLabel1.setText("Muerte");
                jLabel2.setText("");
                jLabel3.setText("");
                jLabel4.setText("");
            } else{
                labelNivel.setText(Integer.toString(bc.getLevels()));
                labelNVisibles.setText(Integer.toString(bc.getNVisibleTreasures()));
                labelNOcultos.setText(Integer.toString(bc.getNHiddenTreasures()));
                if(bc.getSpecificVisibleTreasures()!=null)
                    labelEspVisibles.setText(bc.getSpecificVisibleTreasures().toString());
                if(bc.getSpecificHiddenTreasures()!=null)
                    labelEspOcultos.setText(bc.getSpecificHiddenTreasures().toString());
            }
            repaint();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelText = new javax.swing.JLabel();
        labelLevel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        labelNVisibles = new javax.swing.JLabel();
        labelNOcultos = new javax.swing.JLabel();
        labelEspVisibles = new javax.swing.JLabel();
        labelEspOcultos = new javax.swing.JLabel();

        labelText.setText("Texto");

        labelLevel.setText("Niveles:");

        jLabel1.setText("Num. Visibles: ");

        jLabel2.setText("Num. Ocultos:");

        jLabel3.setText("Esp. Visibles:");

        jLabel4.setText("Esp. Ocultos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelText)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNivel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNVisibles))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNOcultos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEspVisibles))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEspOcultos)))
                .addGap(0, 301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLevel)
                    .addComponent(labelNivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNVisibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelNOcultos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelEspVisibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelEspOcultos))
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelEspOcultos;
    private javax.swing.JLabel labelEspVisibles;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelNOcultos;
    private javax.swing.JLabel labelNVisibles;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelText;
    // End of variables declaration//GEN-END:variables
}
