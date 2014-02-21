/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bestdeal.entites;

/**
 *
 * @author Modhaffer
 */
public class Administrateur extends User{
    
    protected int idAdmin;
    private String adresse;
    private long telephone;
    private int typeAdmin;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String addresse) {
        this.adresse = addresse;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public int getTypeAdmin() {
        return typeAdmin;
    }

    public void setTypeAdmin(int typeAdmin) {
        this.typeAdmin = typeAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }
    
    
}
