/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Windows
 */
public class NewMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       try{
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream("D:\\Maharishi\\build\\web\\pdffile\\student_Details.pdf"));
        document.open();
        Paragraph p=new Paragraph();
        p.add("Student details");
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        PdfPTable table=new PdfPTable(3);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("Scholar_no");
        table.addCell("Student Name");
        table.addCell("Enrollment No");
        table.setHeaderRows(1);
        PdfPCell[] cell=table.getRow(0).getCells();
        for(int j=0;j<=0;j++){
            cell[j].setBackgroundColor(BaseColor.DARK_GRAY);
            Connection con=Mysql.MySqlConnection.getconnection();
            PreparedStatement ps=con.prepareStatement("select * from register");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                table.addCell(String.valueOf(rs.getInt(1)));
                table.addCell(rs.getString(2));
                table.addCell(rs.getString(3));
            }
        }
        document.add(table);
        document.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
