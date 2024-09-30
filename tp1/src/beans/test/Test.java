/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.test;

import beans.site.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {
    public static void save(Site s) {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/db";
    Connection cn = null;
    Statement st = null;
    
    try {
        // Étape 1 : Chargement du driver
        Class.forName("com.mysql.jdbc.Driver");
        
        // Étape 2 : Récupération de la connexion
        cn = DriverManager.getConnection(url, user, password);
        
        // Étape 3 : Création d'un statement
        st = cn.createStatement();
        
        // Étape 4 : Exécution de la requête
        String req = "insert into site values(null,'" + s.getNom() + "')";
        st.executeUpdate(req);
    } catch (SQLException ex) {
        System.out.println("Erreur SQL");
    } catch (ClassNotFoundException ex) {
        System.out.println("Impossible de charger le driver");
    } finally {
        try {
            // Étape 5 : Libérer les ressources de la mémoire
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException ex) {
            System.out.println("Impossible de libérer les ressources");
        }
    }
}
   
public static void load() {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/db";
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;
    
    try {
        // Étape 1 : Chargement du driver
        Class.forName("com.mysql.jdbc.Driver");
        
        // Étape 2 : Récupération de la connexion
        cn = DriverManager.getConnection(url, user, password);
        
        // Étape 3 : Création d'un statement
        st = cn.createStatement();
        
        // Étape 4 : Exécution de la requête
        String req = "select * from site";
        rs = st.executeQuery(req);
        
        // Étape 5 : Parcours du ResultSet
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " : " + rs.getString(2));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println("Impossible de charger le driver");
    } finally {
        try {
            // Étape 6 : Libérer les ressources de la mémoire
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (cn != null) cn.close();
        } catch (SQLException ex) {
            System.out.println("Impossible de libérer les ressources");
        }
    }
}

public static void main(String[] args) {
    // insertion des données
    save(new Site("SAFI"));
    save(new Site("MARRAKECH"));
    save(new Site("EL JADIDA"));
    load();
}

}
