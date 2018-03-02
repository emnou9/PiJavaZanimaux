/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.mysql.jdbc.Blob;

/**
 *
 * @author Sofiene Laouini
 */
public class produit {
    
    private int id;
    private String nomProduit;
    private String type;
    private int quantite;
    private int prix;
    private String description;
    private String image;
    private Double stat;

    public produit(String type, Double stat) {
        this.type = type;
        this.stat = stat;
    }
    

    public Double getStat() {
        return stat;
    }

    public void setStat(Double stat) {
        this.stat = stat;
    }
    
    public produit(int id, String nomProduit, String type, int quantite, int prix, String description) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        //this.image = image;
    }

    
    public produit(int id,String nomProduit, String type, int quantite, int prix, String description,String image) {
                this.id = id;

        this.nomProduit = nomProduit;
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.image = image;

    }

    public produit(String nomProduit, String type, int quantite, int prix, String description, String image) {
        this.nomProduit = nomProduit;
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.image = image;
    }

   

   

    public int getId() {
        return id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "produit{" + "id=" + id + ", nomProduit=" + nomProduit + ", type=" + type + ", quantite=" + quantite + ", prix=" + prix + ", description=" + description + '}';
    }
    
    
    public produit(String nomProduit, String type, int quantite, int prix, String description) {
        this.nomProduit = nomProduit;
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
    }
    
    
    
    
}
