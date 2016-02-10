/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package GUI;

import NapakalakiGame.BadConsequence;

public class PendingBadConsequenceView extends javax.swing.JPanel {
    
    BadConsequence pendingBadConsequenceModel;

    public PendingBadConsequenceView() {
        initComponents();
    }
    
    public BadConsequence getModel(){
        return pendingBadConsequenceModel;
    }

    public void setPendingBadConsequence(BadConsequence pbc){
        if( pbc != null){
            pendingBadConsequenceModel = pbc;
            labelNVisibles.setText(Integer.toString(pbc.getNVisibleTreasures()));
            labelNOcultos.setText(Integer.toString(pbc.getNHiddenTreasures()));
            if(pbc.getSpecificVisibleTreasures()!=null)
                labelEspVisibles.setText(pbc.getSpecificVisibleTreasures().toString());
            if(pbc.getSpecificHiddenTreasures()!=null)
                labelEspOcultos.setText(pbc.getSpecificHiddenTreasures().toString());
        } else {
            labelNOcultos.setText("");
            labelNVisibles.setText("");
            labelEspOcultos.setText("");
            labelEspVisibles.setText("");
        }
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNVisibles = new javax.swing.JLabel();
        labelNOcultos = new javax.swing.JLabel();
        labelEspVisibles = new javax.swing.JLabel();
        labelEspOcultos = new javax.swing.JLabel();

        jLabel1.setText("Num. visibles:");

        jLabel2.setText("Num. ocultos:");

        jLabel3.setText("Esp. visibles:");

        jLabel4.setText("Esp. ocultos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(0, 250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                    .addComponent(labelEspOcultos)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelEspOcultos;
    private javax.swing.JLabel labelEspVisibles;
    private javax.swing.JLabel labelNOcultos;
    private javax.swing.JLabel labelNVisibles;
    // End of variables declaration//GEN-END:variables

}
