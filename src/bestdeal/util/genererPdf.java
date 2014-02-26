/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bestdeal.util;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author youssef
 */
public class genererPdf {
    private static Document mypdf;
    
    public static void main(String[] args)    
          {
           // - Paramètres de connexion à la base de données
           Connection connection;
        try
          {
              String requete="select nom,prenom from client c INNER JOIN voucher v on v.id_client=c.id_client";
              connection=MyConnection.getInstance();
              mypdf= new Document(PageSize.A4,50, 50, 50, 50);
              File di   = new File("C:/Voucher");
              File fl[] = di.listFiles();
               try 
               {
                  OutputStream file = new FileOutputStream(new File("C:/Voucher\\Facture.pdf"));
                  PdfWriter.getInstance(mypdf, file);
                  
                 
                  mypdf.open();
                  Statement stm;
                  
                  mypdf.addAuthor("Best Deal");
                  mypdf.addSubject("Voucher ");
                  mypdf.add(new Paragraph("Sociéte BestDeal"));
                  mypdf.add(new Paragraph("Adresse La Chotrana ESPRIT "));
                  mypdf.add(new Paragraph("TEL : xx xxx xxx"));
                  mypdf.add(new Paragraph("FAX : xx xxx xxx"));
                  mypdf.add(new Paragraph("                                                                                                       "+new Date().toString()));
                  mypdf.add(new Paragraph("  "));
                  mypdf.add(new Paragraph("                                   "+"Facture N'01",FontFactory.getFont(FontFactory.HELVETICA,21, Font.BOLDITALIC)));
                  mypdf.add(new Paragraph("  "));
                  
                  mypdf.add(new Paragraph("CLIENT :",FontFactory.getFont(FontFactory.TIMES_ROMAN,13, Font.BOLDITALIC)));
                  try {
                      stm = connection.createStatement();
                      ResultSet rs = stm.executeQuery(requete);
                      
                         while (rs.next()) {
        	// add a country to the document as a Chunk
            //mypdf.add(new Chunk(rs.getString("quantite")));
                             Phrase p = new Phrase("nom:   ");
                             Phrase p2 = new Phrase(new Chunk(rs.getString("nom")));
                             Paragraph pa = new Paragraph();
                             pa.add(p);
                             pa.add(p2);
                             mypdf.add(pa);
                             p=new  Phrase("prenom:  ");
                             p2 = new Phrase(new Chunk(rs.getString("prenom")));
                             pa.add(p);
                             pa.add(p2);
                             mypdf.add(pa);
                             //mypdf.add(new Phrase("nom"));
                             //mypdf.add(new  Chunk(rs.getString("nom")));
            //mypdf.add( new Paragraph("nom:", new Chunk(rs.getString("nom"))));
            //mypdf.add(new Chunk(" "));
            //Chunk id = new Chunk(rs.getString("id"));
            // with a background color
            //id.setBackground(BaseColor.BLACK, 1f, 0.5f, 1f, 1.5f);
            // and a text rise
            //id.setTextRise(6);
          //  mypdf.add(id);
            mypdf.add(Chunk.NEWLINE);
        }

                  } catch (SQLException ex) {
                      Logger.getLogger(genererPdf.class.getName()).log(Level.SEVERE, null, ex);
                  }
                 // mypdf.add(new Paragraph("Nom "));
                  mypdf.add(new Paragraph("Prenom "));
                  mypdf.add(new Paragraph("Adresse "));
                  mypdf.add(new Paragraph("Téléphone "));
                  mypdf.add(new Paragraph("  "));
                  
                  mypdf.add(new Paragraph("Vendeur :",FontFactory.getFont(FontFactory.TIMES_ROMAN,13, Font.BOLDITALIC)));
                  mypdf.add(new Paragraph("Nom "));
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
              Logger.getLogger(genererPdf.class.getName()).log(Level.SEVERE, null, ex);
              }
               

           mypdf.add(new Paragraph(" "));
           mypdf.add(new Paragraph(" "));
           mypdf.add(new Paragraph("Pour toute question concernant cette facture,veuillez contacter Nom,numéro de téléphone,adresse de messagerie ",FontFactory.getFont(null, 9, Font.NORMAL)));
           mypdf.add(new Paragraph("Merci pour votre confiance", FontFactory.getFont(FontFactory.TIMES_ROMAN,13, Font.BOLDITALIC))); 
           mypdf.add(new Paragraph("      ")); 
           mypdf.close();
       
        }
      catch (DocumentException ex)
        {
           Logger.getLogger(genererPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
