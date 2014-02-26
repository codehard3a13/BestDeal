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
public class Reclamation {
    private String titre;
    private String contenu;
    private int id_client;
    
    public Reclamation()
    {
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    
    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
}
