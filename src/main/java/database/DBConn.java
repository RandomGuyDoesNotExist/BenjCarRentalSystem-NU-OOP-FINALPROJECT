/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BenjZionGMoedillas
 */
public class DBConn {
    private static Connection connect;
    public static Connection connect(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            URL resource = DBConn.class.getResource("/BenjCarRentalDatabase.accdb");
            File file = new File(resource.toURI());
            String path = file.getAbsolutePath();
            connect = DriverManager.getConnection("jdbc:ucanaccess://" + path);
            System.out.println("successfully connected to database");
            return connect;
        }catch(Exception e){
            e.printStackTrace();
             return null;
        }
       
    }
}
