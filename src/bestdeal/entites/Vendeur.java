/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bestdeal.entites;

/**
 *
 * @author Modhaffer
 */
public class Vendeur extends User{
    private int idVendeur;
    private String adresse;
    private int etatCompte;
    private long telephone;
    private float note;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(int etatCompte) {
        this.etatCompte = etatCompte;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getIdVendeur() {
        return idVendeur;
    }
    
    
}
