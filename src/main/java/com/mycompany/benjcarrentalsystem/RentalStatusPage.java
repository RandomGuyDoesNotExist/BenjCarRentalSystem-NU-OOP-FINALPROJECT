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
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author BenjZionGMoedillas
 */
public class RentalStatusPage extends javax.swing.JPanel {

    public RentalStatusPage() {
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
     Object[] row = {document.get("carId"),document.get("carBrand"),document.get
    ("carModel"),document.get("color"),document.get("plateNumber"),document.get("rentedString"),
        document.get("rentedUser"),document.get("duration")};
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.addRow(row);
        model.fireTableDataChanged();
        }   
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

        companyName1 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        smallDoodleBackground = new javax.swing.JLabel();
        DoodleBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        companyName1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        companyName1.setForeground(new java.awt.Color(255, 0, 0));
        companyName1.setText("RENTAL STATUS");
        add(companyName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 40));

        refreshButton.setBackground(new java.awt.Color(255, 0, 0));
        refreshButton.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        refreshButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshButton.setText("REFRESH TABLE");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 190, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 102, 102));

        table.setBackground(new java.awt.Color(255, 102, 102));
        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Car ID ", "Car Brand", "Car Model", "Color", "Plate Number", "Rented Y/N", "Rented By", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 0));
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 690, 330));

        smallDoodleBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doodle2.png"))); // NOI18N
        add(smallDoodleBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 140, 570));

        DoodleBackground.setBackground(new java.awt.Color(51, 51, 51));
        DoodleBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/doodle2.png"))); // NOI18N
        add(DoodleBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 740, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoodleBackground;
    private javax.swing.JLabel companyName1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel smallDoodleBackground;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
