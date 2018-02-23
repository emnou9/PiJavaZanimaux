/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DataSource;

/**
 *
 * @author Sofiene Laouini
 */
public class produitservice {
    
    static DataSource ds =DataSource.getInstance(); 
    
    
    public static void insererProduit (produit p)
    {
    String req="INSERT INTO produit (nom_produit,type,quantite,prix,description,image_produit) VALUES(?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setString(1,p.getNomProduit()); 
            ste.setString(2,p.getType());
            ste.setInt(3,p.getQuantite());
            ste.setInt(4,p.getPrix());
            ste.setString(5,p.getDescription());
            ste.setString(6,p.getImage());
            
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     
    public static void updateProduit (produit p )
    {
    String req="UPDATE produit SET nom_produit=?,type=?,quantite=?,prix=?,description=? WHERE id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,p.getNomProduit()); 
            ste.setString(2,p.getType());
            ste.setInt(3,p.getQuantite());
            ste.setInt(4,p.getPrix());
            ste.setString(5,p.getDescription());
            
            
            
            ste.setInt(6,p.getId()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }   
    
    }
    
     public static void DeletProduit (produit p)
    {
    String req="DELETE  from produit where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,p.getId()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
     public static void DeletProduitByID (int p)
    {
    String req="DELETE  from produit where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,p) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
    public static List<produit> selectProduit ()
    {
        List<produit> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM produit ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new produit(
                                    result.getInt("id"),
                                    result.getString("nom_produit"),
                                    result.getString("type"),
                                    result.getInt("quantite"),
                                    result.getInt("prix"),
                                    result.getString("description"),
                         
                   result.getString("image_produit")
                                    
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
     public static List<produit> selectProduit1 ()
    {
        List<produit> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT id, nom_produit, type, quantite, prix, description FROM produit";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new produit(
                                    result.getInt("id"),
                                    result.getString("nom_produit"),
                                    result.getString("type"),
                                    result.getInt("quantite"),
                                    result.getInt("prix"),
                                    result.getString("description")
                         
                   
                                    
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
    
    
    
    
    
}
