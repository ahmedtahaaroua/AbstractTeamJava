package com.abstractTeam.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abstractTeam.Model.Restaurant;

public class RestaurantC {
	
	
	 public void insertRestaurant(Restaurant d){

	        String requete = "insert into restaurants (nom,adresse,nbrTable,specialite,id_geo,id_restaurateur) values (?,?,?,?,?,?)";
	        try {
	            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
	           PositiongeoC c=new PositiongeoC();
	            ps.setString(1, d.getNom());
	            ps.setString(2, d.getAdresse());
	            ps.setInt(3, d.getNbrTable());
	            ps.setString(4, d.getSpecialite());
	            ps.setInt(5, c.insertPositiongeo(d.getPositiongeo()));
	            ps.setInt(6, d.getRestaurateur().getId());
//	            ps.setDouble(7, d.getNote());
	            ps.executeUpdate();
	            System.out.println("Ajout effectuée avec succès");
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors de l'insertion "+ex.getMessage());
	        }
	    }


}
