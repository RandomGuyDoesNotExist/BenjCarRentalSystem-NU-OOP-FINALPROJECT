/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.benjcarrentalsystem;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author ADMIN
 */
    
public class SignUp extends javax.swing.JFrame {
    String username,password,name,contactNo;
    public SignUp() {
        initComponents();
        setTitle("SUNSET DRIVE CAR RENTAL SYSTEM");
    }


    
    
    public void signUpUser() {

     username = userNameField.getText();
     password = passwordField.getText();
     name = nameField1.getText();
     contactNo = contactNumberField.getText();

    if (username.isEmpty() || password.isEmpty() || name.isEmpty() || contactNo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fill all fields.");
    }

    try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {
        MongoDatabase database = client.getDatabase("CRS");
        MongoCollection<Document> userCollection = database.getCollection("LogInCollection");

        Document existingUser = userCollection.find(new Document("username", username)).first();
        if (existingUser != null) {
            JOptionPane.showMessageDialog(null, "Username already exists.");
            return;
        }
        Document newUser = new Document("username", username)
                .append("password", password)
                .append("name", name)
                .append("contactNo",contactNo); 
        
        userCollection.insertOne(newUser);
        JOptionPane.showMessageDialog(null, "Sign-up successful!");
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    } catch (Exception ex) {
        ex.printStackTrace();
        
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aboutUs = new javax.swing.JLabel();
        aboutUs2 = new javax.swing.JLabel();
        aboutUs3 = new javax.swing.JLabel();
        aboutUs4 = new javax.swing.JLabel();
        aboutUs5 = new javax.swing.JLabel();
        aboutUs6 = new javax.swing.JLabel();
        UpperPanel = new javax.swing.JPanel();
        companyName1 = new javax.swing.JLabel();
        CarIcon = new javax.swing.JLabel();
        upShadow2 = new javax.swing.JLabel();
        upShadow1 = new javax.swing.JLabel();
        upShadow = new javax.swing.JLabel();
        companyLogo = new javax.swing.JLabel();
        companyName = new javax.swing.JLabel();
        SidePanel = new javax.swing.JPanel();
        signUpText = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        contactNumberField = new javax.swing.JTextField();
        usernameText = new javax.swing.JLabel();
        passwordText = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        nameText1 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        nameField1 = new javax.swing.JTextField();
        contactNumberText = new javax.swing.JLabel();
        doodle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        aboutUs.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        aboutUs.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs.setText("exceptional customer service, we prioritize convenience and satisfaction for all");
        getContentPane().add(aboutUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 490, 30));

        aboutUs2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        aboutUs2.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs2.setText("About Us");
        getContentPane().add(aboutUs2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 440, 30));

        aboutUs3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        aboutUs3.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs3.setText("experience with quality vehicles and seamless rental services.");
        getContentPane().add(aboutUs3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 500, 30));

        aboutUs4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        aboutUs4.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs4.setText("all our clients. Choose Sunset Drive for your next journey and elevate your travel ");
        getContentPane().add(aboutUs4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 500, 30));

        aboutUs5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        aboutUs5.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs5.setText("ensuring a comfortable and stylish travel experience. With competitive rates and");
        getContentPane().add(aboutUs5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 500, 30));

        aboutUs6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        aboutUs6.setForeground(new java.awt.Color(255, 255, 255));
        aboutUs6.setText("Sunset Drive Car Rental offers a premium selection of well-maintained vehicles, ");
        getContentPane().add(aboutUs6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 500, 30));

        UpperPanel.setBackground(new java.awt.Color(255, 0, 0));

        companyName1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        companyName1.setText("SUNSET DRIVE");

        CarIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carCompanyLogo (2).png"))); // NOI18N

        javax.swing.GroupLayout UpperPanelLayout = new javax.swing.GroupLayout(UpperPanel);
        UpperPanel.setLayout(UpperPanelLayout);
        UpperPanelLayout.setHorizontalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(companyName1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 756, Short.MAX_VALUE)
                .addComponent(CarIcon)
                .addGap(18, 18, 18))
        );
        UpperPanelLayout.setVerticalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companyName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(UpperPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 1010, 40));

        upShadow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dropShadow3.png"))); // NOI18N
        getContentPane().add(upShadow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 370, 190));

        upShadow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dropShadow3.png"))); // NOI18N
        getContentPane().add(upShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 370, 190));

        upShadow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dropShadow3.png"))); // NOI18N
        getContentPane().add(upShadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 350, 190));

        companyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carCompanyLogo (1).png"))); // NOI18N
        getContentPane().add(companyLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 190, 230));

        companyName.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        companyName.setForeground(new java.awt.Color(255, 0, 0));
        companyName.setText("SUNSET DRIVE");
        getContentPane().add(companyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 140, 40));

        SidePanel.setBackground(new java.awt.Color(239, 239, 239,175));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signUpText.setBackground(new java.awt.Color(49, 46, 57));
        signUpText.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        signUpText.setForeground(new java.awt.Color(49, 46, 57));
        signUpText.setText("Sign-Up");
        SidePanel.add(signUpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jPanel3.setBackground(new java.awt.Color(49, 46, 57,190));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contactNumberField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        contactNumberField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contactNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberFieldActionPerformed(evt);
            }
        });
        jPanel3.add(contactNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 234, 36));

        usernameText.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        usernameText.setForeground(new java.awt.Color(204, 51, 0));
        usernameText.setText("Enter Username");
        jPanel3.add(usernameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 93, -1));

        passwordText.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        passwordText.setForeground(new java.awt.Color(204, 51, 0));
        passwordText.setText("Enter Password");
        jPanel3.add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 93, -1));

        passwordField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        jPanel3.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 234, 36));

        signUpButton.setBackground(new java.awt.Color(255, 0, 0));
        signUpButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Create Account");
        signUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel3.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 179, 40));

        nameText1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        nameText1.setForeground(new java.awt.Color(204, 51, 0));
        nameText1.setText("Enter name");
        jPanel3.add(nameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 93, -1));

        userNameField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        userNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        jPanel3.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 234, 36));

        nameField1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        nameField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField1ActionPerformed(evt);
            }
        });
        jPanel3.add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 234, 36));

        contactNumberText.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        contactNumberText.setForeground(new java.awt.Color(204, 51, 0));
        contactNumberText.setText("Enter contact number");
        jPanel3.add(contactNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        SidePanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 270, 360));

        doodle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background doodle.png"))); // NOI18N
        SidePanel.add(doodle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 340, 630));

        getContentPane().add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 340, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resizedbg.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 1040, 660));

        jPanel2.setBackground(new java.awt.Color(247, 249, 226));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 650));

        setSize(new java.awt.Dimension(983, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contactNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberFieldActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        signUpUser();

    }//GEN-LAST:event_signUpButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void nameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarIcon;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JLabel aboutUs;
    private javax.swing.JLabel aboutUs2;
    private javax.swing.JLabel aboutUs3;
    private javax.swing.JLabel aboutUs4;
    private javax.swing.JLabel aboutUs5;
    private javax.swing.JLabel aboutUs6;
    private javax.swing.JLabel companyLogo;
    private javax.swing.JLabel companyName;
    private javax.swing.JLabel companyName1;
    private javax.swing.JTextField contactNumberField;
    private javax.swing.JLabel contactNumberText;
    private javax.swing.JLabel doodle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameField1;
    private javax.swing.JLabel nameText1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordText;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUpText;
    private javax.swing.JLabel upShadow;
    private javax.swing.JLabel upShadow1;
    private javax.swing.JLabel upShadow2;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel usernameText;
    // End of variables declaration//GEN-END:variables
}
