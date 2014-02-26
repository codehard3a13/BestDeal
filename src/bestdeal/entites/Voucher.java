/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bestdeal.entites;

import java.sql.Date;

/**
 *
 * @author youssef
 */
public class Voucher
{
    private int id_voucher;
    private int id_client;
    private int id_deal;
    private float prix_unitaire;
    private Date date;
    private int quantite;

    public Voucher() {
    }

    public Voucher(int id_client, int id_deal, float prix_unitaire, Date date, int quantite) {
        this.id_client = id_client;
        this.id_deal = id_deal;
        this.prix_unitaire = prix_unitaire;
        this.date = date;
        this.quantite = quantite;
    }

    public int getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(int id_voucher) {
        this.id_voucher = id_voucher;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_deal() {
        return id_deal;
    }

    public void setId_deal(int id_deal) {
        this.id_deal = id_deal;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
}
