/**
 *  Marco Manuel Fernández Pranno, 2015 (Granada)
 *  Para la asignatura PDOO (Universidad de Granada)
 *  Licencia GPLv3 a partir del 15/02/16, hasta entonces todos los derechos reservados.
 */

package GUI;

import NapakalakiGame.Treasure;
import java.awt.Color;

public class TreasureView extends javax.swing.JPanel {

    Treasure treasureModel;
    boolean selected = false;
    
    public TreasureView() {
        initComponents();
    }
    
    public void setTreasure(Treasure t){
        treasureModel = t;
        labelBonus.setText(Integer.toString(t.getBonus()));
        labelNombre.setText(t.getName());
        labelTipo.setText(t.getType().toString());
        repaint();
    }
    
    public boolean isSelected(){
        return selected;
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelBonus = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        labelNombre.setText("Nombre");

        labelBonus.setText("Bonus");

        labelTipo.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombre)
                    .addComponent(labelBonus)
                    .addComponent(labelTipo))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBonus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTipo))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
        
        if(selected){
            setBackground(new Color(153,153,150));
            setOpaque(true);
        }else{
            setBackground(new Color(240,240,240));
            setOpaque(false);
        }
        repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelBonus;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTipo;
    // End of variables declaration//GEN-END:variables
}
