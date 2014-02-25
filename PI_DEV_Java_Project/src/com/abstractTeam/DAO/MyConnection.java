package com.abstractTeam.DAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MyConnection {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/abtractteam";
	private static final String login = "root";
	private static final String pwd = "";
	private static Connection con;

	private MyConnection() {

	}

	public Connection etablirConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, pwd);
			System.out.println("Connexion �tablie");
		} catch (ClassNotFoundException ex) {
			// Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE,
			// null, ex);
			System.out.println("Erreur de chargement de driver"
					+ ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("probleme d'etablissement de connection"
					+ ex.getMessage());
		}

		return con;
	}

	public static Connection getInstance() {
		if (con == null) {
			new MyConnection().etablirConnection();
		}
		return con;
	}

	public void fermerConnection() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
