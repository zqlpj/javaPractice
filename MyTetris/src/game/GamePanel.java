/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brook
 */
public class GamePanel extends javax.swing.JPanel implements Runnable{
    Controller ctr = new Controller();
    /**
     * Creates new form GamePanel
     */
    public GamePanel() {
        initComponents();
        new Thread(this).start();
    }
    public void run(){
        try {
            while(ctr.currentY < 20){
            //temp
            ctr.currentY++;
            this.repaint();
            Thread.currentThread().sleep(1000);
            }
         } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBlocks(g);
    }
    public void keyPressed(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode()==37){
            ctr.currentX--;
        }else if(evt.getKeyCode()==39){
            ctr.currentX++;
        }
    }
    public void drawBlocks(Graphics g){
        int[] shape = ctr.getAShape();
        int currentX = ctr.currentX;
        int currentY = ctr.currentY;
        for(int i = 0; i < 16; i++){
            if(shape[i]==1){
                int x = (i%4+currentX)*20;
                int y = (i/4+currentY)*20;
                g.setColor(Color.BLACK);
                g.drawRect(x,y,20,20);
                g.setColor(Color.RED);
                g.fillRect(x,y,19,19);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
