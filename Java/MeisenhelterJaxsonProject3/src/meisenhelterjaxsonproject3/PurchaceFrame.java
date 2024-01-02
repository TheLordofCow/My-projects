/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;


/**
 *
 * @author jcwm2
 */
public class PurchaceFrame extends javax.swing.JFrame {
    private Store Johns;
    private double total = 0.0;
    /**
     * Creates new form project3GUI
     */
    public PurchaceFrame(Store Johns) {
        this.Johns = Johns;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        productDropBox = new javax.swing.JComboBox<>();
        buyButton = new javax.swing.JButton();
        finishedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setText("What would you like to purchace?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(welcomeLabel)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        productDropBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fahrenheit 451                           ray bradbury                           book                $9.99", "1984                                              george orwell                         book              $15.99", "To kill a mockingbird                 harper lee                                book                  $12.99", "beloved                                       toni  morrison                          book               $13.50", "The little prince\t                         antoine de saint exupÃry      book                    $7.00", "Brave new world                       aldous huxley\t                          book               $19.00", "Charlotte's web\t                         e.b. white                                 book                $8.99", "Hitchhiker's guide to the galaxy\t   douglas adams                  book                     $9.99", "Catch-22                                      joseph heller                           book               $11.99", "Flowers for algernon                daniel keyes                            book                    $6.99", "A night at the opera                  queen                                       CD                   $6.99", "Cuz I love you                            lizzo                                          CD                  $7.99", "A hard day's night                     The beatles                              CD                    $3.99", "The dark knight                                                                           DVD               $12.99", "Jurassic park                                                                               DVD                $7.99" }));
        productDropBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDropBoxActionPerformed(evt);
            }
        });

        buyButton.setText("Buy");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        finishedButton.setText("Finished");
        finishedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productDropBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 479, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(finishedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(productDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(finishedButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productDropBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDropBoxActionPerformed
        
    }//GEN-LAST:event_productDropBoxActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        int selected = productDropBox.getSelectedIndex();
        total += Johns.buyItem(selected);
        
        welcomeLabel.setText("Would you like anything else?");
    }//GEN-LAST:event_buyButtonActionPerformed

    private void finishedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedButtonActionPerformed
        MemberFrame secondFrame = new MemberFrame(Johns, total);
        setDefaultCloseOperation(secondFrame.DISPOSE_ON_CLOSE);
        secondFrame.setVisible(true);       
        this.dispose();
    }//GEN-LAST:event_finishedButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyButton;
    private javax.swing.JButton finishedButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> productDropBox;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}