package com.abstractTeam.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abstractTeam.Model.Plat;
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

	 
	 
	 
	 
	 
	 
	

	public List<Restaurant> DisplayAllResto() {
		
	      List<Restaurant> listedepots = new ArrayList<Restaurant>();

	        String requete = "select * from restaurants";
	        try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	         
	            while(resultat.next()){
	            	Restaurant stock =new Restaurant();
	                stock.setNom(resultat.getString(2));
	                stock.setNote(resultat.getDouble(8));
	                stock.setId(resultat.getInt(1));
	                listedepots.add(stock);
	            }
	            return listedepots;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
	
		
	}

	public Restaurant getRestoById(int id){
		Restaurant resto=new Restaurant();
		String requete="select * from restaurants where id="+id;
		   try {
	           Statement statement = MyConnection.getInstance()
	                   .createStatement();
	            ResultSet resultat = statement.executeQuery(requete);
	            Restaurant stock =new Restaurant();
	            while(resultat.next()){
	              
	                stock.setId(id);
	                stock.setNom(resultat.getString(2));
	                stock.setAdresse(resultat.getString(3));
	                stock.setNbrTable(resultat.getInt(4));
	                

	             
	            }
	            return stock;
	        } catch (SQLException ex) {
	           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("erreur lors du chargement des stocks "+ex.getMessage());
	            return null;
	        }
		
		
	
	
	
	}
}
