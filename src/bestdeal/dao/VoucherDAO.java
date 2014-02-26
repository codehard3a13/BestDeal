/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bestdeal.dao;

import bestdeal.entites.Voucher;
import bestdeal.util.MyConnection;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.FileDataSource;

/**
 *
 * @author youssef
 */
public class VoucherDAO {
    private Document mypdf;
    private PdfWriter mywriter;
    private PdfContentByte cb;
    public VoucherDAO() {
    }
    
    public void ajouterVoucher(Voucher v)
    {
        String requete="insert into voucher(id_client,id_deal,prix_unitaire,date,quantite) values(?,?,?,?,?)";
      
        try
        {
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,v.getId_client());
            ps.setInt(2,v.getId_deal());
            ps.setFloat(3, v.getPrix_unitaire());
            ps.setDate(4, v.getDate());
            ps.setInt(5, v.getQuantite());
            //ps.setString(3, r.getId_client());
            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void envoyerVoucher(Voucher v) 
    {
        String req= "select email from client c inner join panier p on c.clientid=p.client_id";
    }
   public void creerPdf()
    {
      PreparedStatement ps;  
      String requete="nom_client, i";
      
      try
        {
          try
          {
              mypdf= new Document(PageSize.A4,50, 50, 50, 50);
              File di   = new File("D:/Voucher");
              File fl[] = di.listFiles();
               try 
               {
                  OutputStream file = new FileOutputStream(new File("D:/Voucher\\Facture.pdf"));
                  PdfWriter.getInstance(mypdf, file);
                  
                  mypdf.addAuthor("Best Deal");
                  mypdf.addSubject("Voucher ");
                  mypdf.open();
                  
                  mypdf.add(new Paragraph("Sociéte BestDeal"));
                  mypdf.add(new Paragraph("Adresse La Chotrana ESPRIT "));
                  mypdf.add(new Paragraph("TEL : xx xxx xxx"));
                  mypdf.add(new Paragraph("FAX : xx xxx xxx"));
                  mypdf.add(new Paragraph("                                                                                                       "+new Date().toString()));
                  mypdf.add(new Paragraph("  "));
                  mypdf.add(new Paragraph("                                   "+"Facture N'01",FontFactory.getFont(FontFactory.HELVETICA,21, Font.BOLDITALIC)));
                  mypdf.add(new Paragraph("  "));
                  
                  mypdf.add(new Paragraph("CLIENT :",FontFactory.getFont(FontFactory.TIMES_ROMAN,13, Font.BOLDITALIC)));
                  mypdf.add(new Paragraph("Nom "));
                  mypdf.add(new Paragraph("Prenom "));
                  mypdf.add(new Paragraph("Nom de la société "));
                  mypdf.add(new Paragraph("Adresse "));
                  mypdf.add(new Paragraph("Téléphone "));
                  mypdf.add(new Paragraph("  "));
                  String [] headers = new String[]{"  Id_deal","   Nom Deal","   Quantité","    Prix unitaire","   Prix total"}; 
                  String[][] data = new String[][]{ {" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},
        		   {" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},
        		   {" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},{" ", " ", " ", " "},
        		    
           };
                  PdfPTable table= new PdfPTable(headers.length);
                  for (int i = 0; i < headers.length; i++) 
                        {
                            String header = headers[i];
                            PdfPCell cell = new PdfPCell();
                            cell.setGrayFill(0.9f);
                            cell.setPhrase(new Phrase(header.toUpperCase()));
                            table.addCell(cell);
                        }
                  table.completeRow();
                   for (int i = 0; i < data.length; i++) 
                        {
                        for (int j = 0; j < data[i].length; j++)
                            {
                              String datum = data[i][j];
                              PdfPCell cell = new PdfPCell();
                              cell.setPhrase(new Phrase(datum.toUpperCase()));
                              table.addCell(cell);
                            }
                  table.completeRow();
                        }
               
                 mypdf.add(table); 
              } 
                catch (FileNotFoundException ex)
              {
              Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
            ps = MyConnection.getInstance().prepareStatement(requete);

       // mywriter=PdfWriter.getInstance(mypdf, new o);
            ResultSet resultat = ps.executeQuery();
           
            /* while (resultat.next())
            {
                data[0]= resultat.getString(1);
                data[1]=resultat.getString(2);
                data[3]= resultat.getString(1);
                data[4]=resultat.getString(2);
                mypdf.addTitle("voucher du deal");
   //             mypdf.add(resultat.getString("nom"));
                //depot.setId_dep(resultat.getInt(1));
               // depot.setAdresse_depot(resultat.getString(2));
            }*/
           /* for(int i=0;i<data.length;i++)
            {
              try {
                  mypdf.add(new Paragraph(data[i]));
                  } 
              catch (DocumentException ex)
              {
                  Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
              } 
            } */
       // }
      
   /*   catch (SQLException ex)
        {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } */
           
           mypdf.add(new Paragraph(" "));
           mypdf.add(new Paragraph(" "));
           mypdf.add(new Paragraph("Pour toute question concernant cette facture,veuillez contacter Nom,numéro de téléphone,adresse de messagerie ",FontFactory.getFont(null, 9, Font.NORMAL)));
           mypdf.add(new Paragraph("      ")); 
           mypdf.add(new Paragraph("      ")); 
           mypdf.close();
        } 
           catch (SQLException ex)
            {
            Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
           
        }
      catch (DocumentException ex)
        {
           Logger.getLogger(VoucherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
