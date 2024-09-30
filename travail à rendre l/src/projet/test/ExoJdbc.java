/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projet.devdata.DevData;

/**
 *
 * @author Pc
 */
public class ExoJdbc {
    
    public static void Insert(DevData s) {
        // Information d'accès à la base de données
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/devdata";
        Connection cn = null;
        Statement st = null;

        try {
            // Étape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Étape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);

            // Étape 3 : Création d'un statement
            st = cn.createStatement();

            // Étape 4 : Construction de la requête SQL
            String req = "INSERT INTO devdata (Developpeurs, Jour, Nbscripts) VALUES ('" + 
                          s.getDeveloppeur() + "', '" + s.getJour() + "', " + s.getNbscript() + ")";

            // Étape 5 : Exécution de la requête
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver");
        } finally {
            try {
                // Étape 6 : Libérer les ressources de la mémoire
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources");
            }
        }
    }
    public static void Max() {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/devdata";
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
        String req = "SELECT Developpeurs, jour, max(NBScripts)from devdata group by jour";
        rs = st.executeQuery(req);
        
        // Étape 5 : Parcours du ResultSet
        while (rs.next()) {
            System.out.println("le nombre maximal de sripts pour :"+rs.getString(2) + " est : " +rs.getInt(3) + " Réalisé par : " + rs.getString(1));
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
    public static void Trie() {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/devdata";
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
        String req = "SELECT Developpeurs, sum(NBScripts) as c from devdata Group by Developpeurs "
                + "order by c desc";
        rs = st.executeQuery(req);
        
        // Étape 5 : Parcours du ResultSet
        while (rs.next()) {
            System.out.println(rs.getString(1) +  " : " + rs.getInt(2));
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
     public static void ScriptsParSemaine(String date) {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/devdata";
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
       String req = "SELECT SUM(NBScripts) AS total_scripts FROM devdata "
               + "WHERE WEEK(Jour) = WEEK('" + date + "');";
;
        rs = st.executeQuery(req);
        
        // Étape 5 : Parcours du ResultSet
        while (rs.next()) {
            System.out.println("Le nombre total de scripts réalisés "
                    + "en une semaine est : "+rs.getInt("total_scripts"));
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
    
    public static void TotalScripts(String developpeur) {
    // Information d'accès à la base de données
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/devdata";
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
       String req = "SELECT Developpeurs,SUM(NBScripts) AS TotalScripts FROM devdata WHERE Developpeurs = '" + developpeur+ "'";
;
        rs = st.executeQuery(req);
        
        // Étape 5 : Parcours du ResultSet
        while (rs.next()) {
            System.out.println("Développeur: " + rs.getString(1) +
                                ", Total des scripts: " + rs.getInt("TotalScripts"));
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
        // Insertion des données
//        Insert(new DevData("Alami", "lundi", 1));
//        Insert(new DevData("Wafi", "lundi", 2));
//        Insert(new DevData("Salami", "Mardi", 9));
//        Insert(new DevData("Safi", "Mardi", 2));
          Insert(new DevData("Alami", "Mardi", 2));
//        Insert(new DevData("Sebihi", "Mercredi", 2));
//        Insert(new DevData("Wafi", "Jeudi", 3));
//        Insert(new DevData("Alaoui", "Vendredi", 9));
//        Insert(new DevData("Wafi", "Vendredi", 3));
//        Insert(new DevData("Sebihi", "Vendredi", 4));
//        Max();
//        Trie();
        TotalScripts("Alami");
         TotalScripts("Wafi");
          TotalScripts("Alaoui");
           TotalScripts("Wafi");
//        ScriptsParSemaine("2024-09-30");
    }  
}
