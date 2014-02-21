/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bestdeal.dao;

import bestdeal.entites.Vendeur;
import bestdeal.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Modhaffer
 */
public class VendeurDAO {

    public static int etatInscription;
    String requete = "insert into Vendeur(login, pwd, nom, prenom, Telephone, adresse, email, etat_compte)"
            + " values (?,?,?,?,?,?,?,?)";
    public void insertVendeur(Vendeur v){
        try{
            PreparedStatement ps  = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, v.getLogin());
            ps.setString(2, v.getPwd());
            ps.setString(3, v.getNom());
            ps.setString(4, v.getPrenom());
            ps.setLong(5, v.getTelephone());
            ps.setString(6, v.getAdresse());
            ps.setString(7, v.getEmail());
            ps.setInt(8, v.getEtatCompte());
            
            ps.executeUpdate();
            etatInscription = 0;
        }catch (SQLException e){
            etatInscription = 1;
        }
    }
}
