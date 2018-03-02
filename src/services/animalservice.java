/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.animal;
import entities.produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static services.produitservice.ds;
import util.DataSource;

/**
 *
 * @author Firas Ammar
 */
public class animalservice {
    
    static DataSource ds =DataSource.getInstance(); 
    
    
    public static void insererAnimal (animal a)
    {
    String req="INSERT INTO animal (espece,race,age,prix,sexe,image) VALUES(?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setString(1,a.getEspece()); 
            ste.setString(2,a.getRace());
            ste.setInt(3,a.getAge());
            ste.setFloat(4,a.getPrix());
            ste.setString(5,a.getSexe());
            ste.setString(6,a.getImage());
            
            
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
    }
    
     
    public static void updateAnimal (animal a )
    {
    String req="UPDATE animal SET espece=?,race=?,age=?,prix=?,sexe=? WHERE id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,a.getEspece()); 
            ste.setString(2,a.getRace());
            ste.setInt(3,a.getAge());
            ste.setFloat(4,a.getPrix());
            ste.setString(5,a.getSexe());
            
            
            
            ste.setInt(6,a.getId()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }   
    
    }
    
     public static void DeletProduit (animal a)
    {
    String req="DELETE  from animal where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,a.getId()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }
     public static void DeletAnimalByID (int a)
    {
    String req="DELETE  from animal where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,a) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
        }
    
      }    public static List<animal> selectAnimal ()
    {
        List<animal> list =new ArrayList<>() ; 
    String req ; 
        req = "SELECT *  FROM animal ";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new animal(
                                    result.getInt("id"),
                                    result.getString("espece"),
                                    result.getString("race"),
                                    result.getInt("age"),
                                    result.getFloat("prix"),
                                    result.getString("sexe")
                         
                  
                                    
            )); 
            }
            
        } catch (SQLException ex) {
            
        }
    return list ; 
      }
    public List<animal> getAll() {
             String req = "select * from animal ";
        List<animal> animals = new ArrayList<>();
        try {
      PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet rs =ste.executeQuery() ;
            while (rs.next()) {
               animal r= new animal (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7));
                animals.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }

   public void modifier_animal(animal e,int id) {
  
      try {
          String req="update animal set  espece= '"+e.getEspece()+"' , race= '"+e.getRace()+"' ,sexe= '"+e.getRace()+"',image= '"+e.getImage()+"' where id="+id+"";
          Statement st=ds.getConnection().createStatement();
            st.executeUpdate(req);
      } catch (SQLException ex) {
          Logger.getLogger(animalservice.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
   
    
    
    
    
    
}
