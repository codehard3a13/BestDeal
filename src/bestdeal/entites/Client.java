/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bestdeal.entites;

/**
 *
 * @author Modhaffer
 */
public class Client extends User{
    private int idClient;
    private int etatCompte;

    public int getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(int etatCompte) {
        this.etatCompte = etatCompte;
    }

    public int getIdClient() {
        return idClient;
    }
    
    
}
