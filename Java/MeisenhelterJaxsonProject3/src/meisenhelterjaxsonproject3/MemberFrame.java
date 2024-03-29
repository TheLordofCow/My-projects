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
public class MemberFrame extends javax.swing.JFrame {
    private Store Johns;
    private float total;
    /**
     * Creates new form NewJFrame
     */
    public MemberFrame(Store Johns, double total) {
        this.Johns = Johns;
        this.total = (float) Math.round((total) * 100) / 100;
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

        costLabel = new javax.swing.JLabel();
        memberLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        nameText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        noButton2 = new javax.swing.JButton();
        yesButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        costLabel.setText("The total cost of your purchace is $" + total + ".");

        memberLabel.setText("Are you a member?");

        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        nameText.setEnabled(false);
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Would you like to make another purchace?");

        noButton2.setText("No");
        noButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButton2ActionPerformed(evt);
            }
        });

        yesButton2.setText("Yes");
        yesButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(noButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yesButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(costLabel)
                .addGap(18, 18, 18)
                .addComponent(memberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yesButton)
                .addGap(18, 18, 18)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noButton2)
                    .addComponent(yesButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        nameText.setEnabled(true);
        okButton.setEnabled(true);
    }//GEN-LAST:event_yesButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        int memNum = Johns.findName(nameText.getText());                   
        if(memNum >= 0){
            if(Johns.isPremium(nameText.getText()) == true){
                memberLabel.setText("Alright, I can see you are in the system as well as a premium member!");
                Johns.addSpent(memNum, total);
            }
            else if(Johns.isPremium(nameText.getText()) == false){
                memberLabel.setText("Alright, I can see you are in the system!");
                Johns.addSpent(memNum, total);
            }
        }
        else{
            memberLabel.setText("It appears that name in not in our system.");              
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void noButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_noButton2ActionPerformed

    private void yesButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButton2ActionPerformed
        PurchaceFrame startGUI = new PurchaceFrame(Johns);
        startGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_yesButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel memberLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton noButton2;
    private javax.swing.JButton okButton;
    private javax.swing.JButton yesButton;
    private javax.swing.JButton yesButton2;
    // End of variables declaration//GEN-END:variables
}
