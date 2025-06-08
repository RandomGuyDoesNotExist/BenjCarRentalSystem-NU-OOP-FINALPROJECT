/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.benjcarrentalsystem;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
/**
 *
 * @author BenjZionGMoedillas
 */
public class RentACarPage extends javax.swing.JPanel {

    String userId, carId, duration ; 
    public RentACarPage() {
        initComponents();
        retrieveData();
    }
    // DISPLAY DATA IN TABLE
    public void retrieveData(){
    MongoClient client = MongoClients.create("mongodb://localhost:27017");
      
    MongoDatabase database = client.getDatabase("CRS");
    MongoCollection<Document> CarsCollection = database.getCollection("Cars");
    
    FindIterable<Document> findIterable = CarsCollection.find();
    Iterator<Document> iterator = findIterable.iterator(); 
    while(iterator.hasNext()){
        Document document = iterator.next();
        Object[] row = {document.get("carId"),document.get("carBrand"),document.get("carModel"),document.get("year"),document.get("color"),document.get("plateNumber"),document.get("rentedString"),document.get("rentedUser"),document.get("duration")};
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(row);
        model.fireTableDataChanged();
        }   
    }  
    
           //UPDATE RENTAL VALUES METHOD  
           // ASSIGN CAR TO A USER
    public void changeRentalValues(){
    
     userId = userIDField1.getText();
     carId = carSearchIDField.getText();
     duration = durationField.getText();
     
    MongoClient client = MongoClients.create("mongodb://localhost:27017");
      
    MongoDatabase database = client.getDatabase("CRS");
    MongoCollection<Document> CarsCollection = database.getCollection("Cars");
    MongoCollection<Document> UserCollection = database.getCollection("Users");
        //SEARCHING FOR ONE DATA ONLY HEHE 
        Document documentForSearchingIndividualData = UserCollection.find(new Document("userId",userId)).first(); // PUT MUNA SA DOCUMENT YUNG DOCUMENT SA DATABASE NA HINAHANAP
        String documentFoundUserName = documentForSearchingIndividualData.getString("name"); //ONCE NA NASA DOCUMENT MO NA DINECLARE YUNG DATA FROM DB, MAY ACCESS NA IKAW SA FIELDS NA MERON YUNG DOCUMENT!
 
          
        
       
    // CHANGE OR UPDATES VALUES OF THE CARS IN CAR COLLECTION
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rented",true));
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rentedString","Yes"));
         CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rentedUser",documentFoundUserName));
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("duration",duration));
    // CHANGE OR UPDATES VALUES OF THE USERS IN USERS COLLECTION            
        UserCollection.updateOne(Filters.eq("userId",userId), Updates.set("rented",true));
        UserCollection.updateOne(Filters.eq("userId",userId), Updates.set("rentedString","Rented A Car"));
        
    }  
    
       // REMOVE A USER FROM CAR FROM RENT
      public void removeRentalValues(){
    
     userId = durationField.getText();
     carId = carSearchIDField.getText();
     duration = durationField.getText();
    MongoClient client = MongoClients.create("mongodb://localhost:27017");
     
      
    MongoDatabase database = client.getDatabase("CRS");
    MongoCollection<Document> CarsCollection = database.getCollection("Cars");
    MongoCollection<Document> UserCollection = database.getCollection("Users");
        
        
    // CHANGE OR UPDATES VALUES OF THE CARS IN CAR COLLECTION
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rented",false));
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rentedString","No"));
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("rentedUser",""));
        CarsCollection.updateOne(Filters.eq("carId",carId), Updates.set("duration",""));
    // CHANGE OR UPDATES VALUES OF THE USERS IN USERS COLLECTION            
        UserCollection.updateOne(Filters.eq("userId",userId), Updates.set("rented",false));
        UserCollection.updateOne(Filters.eq("userId",userId), Updates.set("rentedString","Not Rented"));
        
    }  
    
     public void refreshTable(){
        MongoClient client = MongoClients.create("mongodb://localhost:27017"); 
        MongoDatabase database = client.getDatabase("CRS");
        MongoCollection<Document> CarsCollection = database.getCollection("Cars");
        
        FindIterable<Document> findIterable = CarsCollection.find();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        for (Document document : findIterable) {
            Object[] row = {
                document.get("carId"),
                document.get("carBrand"),
                document.get("carModel"),
                document.get("year"),
                document.get("color"),
                document.get("plateNumber"),
                document.get("rentedString"),
                document.get("rentedUser"),
                document.get("duration")
                    
            };
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        carSearchText = new javax.swing.JLabel();
        companyName1 = new javax.swing.JLabel();
        carSearchText1 = new javax.swing.JLabel();
        carListingText1 = new javax.swing.JLabel();
        carSearchIDField = new javax.swing.JTextField();
        userIDField1 = new javax.swing.JTextField();
        durationField = new javax.swing.JTextField();
        assignCarButton = new javax.swing.JButton();
        removeUserToCar = new javax.swing.JButton();
        refreshButton1 = new javax.swing.JButton();
        smallDoodleBackground = new javax.swing.JLabel();
        DoodleBackground = new javax.swing.JLabel();
        carSearchText2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 102, 102));

        table.setBackground(new java.awt.Color(255, 102, 102));
        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID ", "Car Brand", "Car Model", "Year", "Color", "Plate Number", "Rented Y/N", "Rented By", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 690, 330));

        carSearchText.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        carSearchText.setForeground(new java.awt.Color(255, 0, 0));
        carSearchText.setText("ENTER USER ID NUMBER ");
        add(carSearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 40));

        companyName1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        companyName1.setForeground(new java.awt.Color(255, 0, 0));
        companyName1.setText("RENTING");
        add(companyName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 40));

        carSearchText1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        carSearchText1.setForeground(new java.awt.Color(255, 0, 0));
        carSearchText1.setText("ENTER DURATION");
        add(carSearchText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 140, 40));

        carListingText1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        carListingText1.setForeground(new java.awt.Color(255, 0, 0));
        carListingText1.setText("CAR LISTINGS");
        add(carListingText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 40));

        carSearchIDField.setBackground(new java.awt.Color(255, 102, 102));
        carSearchIDField.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        carSearchIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carSearchIDFieldActionPerformed(evt);
            }
        });
        add(carSearchIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 240, 40));

        userIDField1.setBackground(new java.awt.Color(255, 102, 102));
        userIDField1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        userIDField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDField1ActionPerformed(evt);
            }
        });
        add(userIDField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 240, 40));

        durationField.setBackground(new java.awt.Color(255, 102, 102));
        durationField.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        durationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationFieldActionPerformed(evt);
            }
        });
        add(durationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 240, 40));

        assignCarButton.setBackground(new java.awt.Color(255, 0, 0));
        assignCarButton.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        assignCarButton.setForeground(new java.awt.Color(255, 255, 255));
        assignCarButton.setText("ASSIGN CAR TO USER");
        assignCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignCarButtonActionPerformed(evt);
            }
        });
        add(assignCarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 240, 50));

        removeUserToCar.setBackground(new java.awt.Color(255, 0, 0));
        removeUserToCar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        removeUserToCar.setForeground(new java.awt.Color(255, 255, 255));
        removeUserToCar.setText("REMOVE USER FROM CAR");
        removeUserToCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUserToCarActionPerformed(evt);
            }
        });
        add(removeUserToCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 190, 50));

        refreshButton1.setBackground(new java.awt.Color(255, 0, 0));
        refreshButton1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        refreshButton1.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton1.setText("REFRESH TABLE");
        refreshButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButton1ActionPerformed(evt);
            }
        });
        add(refreshButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 190, 50));

        smallDoodleBackground.setBackground(new java.awt.Color(51, 51, 51));
        smallDoodleBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doodle2.png"))); // NOI18N
        add(smallDoodleBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 140, 570));

        DoodleBackground.setBackground(new java.awt.Color(51, 51, 51));
        DoodleBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doodle2.png"))); // NOI18N
        add(DoodleBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 740, 570));

        carSearchText2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        carSearchText2.setForeground(new java.awt.Color(255, 0, 0));
        carSearchText2.setText("ENTER CAR ID NUMBER ");
        add(carSearchText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void durationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationFieldActionPerformed

    private void assignCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignCarButtonActionPerformed
        // TODO add your handling code here:
        changeRentalValues();
         refreshTable();
        durationField.setText("");
        carSearchIDField.setText("");
        userIDField1.setText("");
    }//GEN-LAST:event_assignCarButtonActionPerformed

    private void carSearchIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carSearchIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carSearchIDFieldActionPerformed

    private void removeUserToCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserToCarActionPerformed
        // TODO add your handling code here:
        removeRentalValues();
        durationField.setText("");
        carSearchIDField.setText("");
        userIDField1.setText("");
        refreshTable();
    }//GEN-LAST:event_removeUserToCarActionPerformed

    private void userIDField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDField1ActionPerformed

    private void refreshButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButton1ActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_refreshButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoodleBackground;
    private javax.swing.JButton assignCarButton;
    private javax.swing.JLabel carListingText1;
    private javax.swing.JTextField carSearchIDField;
    private javax.swing.JLabel carSearchText;
    private javax.swing.JLabel carSearchText1;
    private javax.swing.JLabel carSearchText2;
    private javax.swing.JLabel companyName1;
    private javax.swing.JTextField durationField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton1;
    private javax.swing.JButton removeUserToCar;
    private javax.swing.JLabel smallDoodleBackground;
    private javax.swing.JTable table;
    private javax.swing.JTextField userIDField1;
    // End of variables declaration//GEN-END:variables
}
