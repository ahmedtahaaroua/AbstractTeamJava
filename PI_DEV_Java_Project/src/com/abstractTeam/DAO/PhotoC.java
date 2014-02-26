package com.abstractTeam.DAO;

import java.awt.Component;
import java.awt.image.DataBufferByte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class PhotoC {
	
	 private void btnSaveActionPerformed(java.awt.event.ActionEvent evt,DataBufferByte data,Component rootPane) {                                        
	        ResultSet rs = null;
	 
	        // Declare statement.
	        PreparedStatement psmnt = null;
	 
	        try {
	 
	            psmnt = MyConnection.getInstance().prepareStatement("insert into photos(url, city, image, Phone) "
	                    + "values(?,?,?,?)");
	            psmnt.setString(1, "Abir");
	            psmnt.setString(2, "Dhaka");
	            psmnt.setString(4, "123456");
	            byte[] extractBytes = data.getData();
	            psmnt.setBytes(3, extractBytes);
	            // executeUpdate() method execute specified sql query. Here this query 
	            //insert data and image from specified address. 
	            int s = psmnt.executeUpdate();
	            if (s > 0) {
	                System.out.println("Uploaded successfully !");
	 
	             
					JOptionPane.showMessageDialog(rootPane, "Uploaded successfully !");
	            } else {
	                System.out.println("unsucessfull to upload image.");
	            }
	            MyConnection.getInstance().close();
	            psmnt.close();
	        } // catch if found any exception during rum time.
	        catch (Exception ex) {
	            System.out.println("Found some error : " + ex);
	        }
	    }              

}
