/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package GUI;

import NapakalakiGame.Prize;


public class PrizeView extends javax.swing.JPanel {

    Prize prizeModel;
    
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize p){
        prizeModel = p;
        labelNivel.setText("Nivel: "+Integer.toString(p.getLevel()));
        labelTesoros.setText("Tesoros: "+Integer.toString(p.getTreasure()));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTesoros = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();

        labelTesoros.setText("Tesoros");

        labelNivel.setText("Nivel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTesoros)
                    .addComponent(labelNivel))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelTesoros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNivel))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelTesoros;
    // End of variables declaration//GEN-END:variables
}
