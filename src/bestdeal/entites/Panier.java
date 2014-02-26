/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bestdeal.entites;

/**
 *
 * @author youssef
 */
public class Panier 
{
 private int id_panier;
 private int quantite;
 private float prix_unitaire;
 private int id_deal;
 private int id_client;

    public Panier() {
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getId_deal() {
        return id_deal;
    }

    public void setId_deal(int id_deal) {
        this.id_deal = id_deal;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
 
}
