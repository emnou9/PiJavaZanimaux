/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Firas Ammar
 */
public class animal {
    private int id;
    private String espece;
    private String race;
    private int age ;
    private float prix;
    private String sexe;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public animal(int id, String espece, String race, int age, float prix, String sexe, String image) {
        this.id = id;
        this.espece = espece;
        this.race = race;
        this.age = age;
        this.prix = prix;
        this.sexe = sexe;
        this.image = image;
    }


    public animal(String espece, String race, String sexe, String image) {
        this.espece = espece;
        this.race = race;
        this.sexe = sexe;
        this.image = image;
    }
           
    public animal(String espece, String race, int age, float prix, String sexe, String image) {
        this.espece = espece;
        this.race = race;
        this.age = age;
        this.prix = prix;
        this.sexe = sexe;
        this.image = image;
    }

    public animal() {
    }

    public animal(int id, String espece, String race, int age, float prix, String sexe) {
        this.id = id;
        this.espece = espece;
        this.race = race;
        this.age = age;
        this.prix = prix;
        this.sexe = sexe;
    }

    public animal(String espece, String race, int age, float prix, String sexe) {
        this.espece = espece;
        this.race = race;
        this.age = age;
        this.prix = prix;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    
    
}
