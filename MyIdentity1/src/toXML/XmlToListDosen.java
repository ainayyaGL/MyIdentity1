/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Dosen;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// transform untuk save
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


/**
 *
 * @author zain
 */
public class XmlToListDosen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Dosen> dos = new ArrayList ();
        String nama, nik, tmpLahir, JKel, agama, statusP, pendT, gol, tmt, telp, noHP, email, alamat, RootElemen, RowElemen;
      
        
        
       File fileXML = new File("Dosen.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Dosen");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIK");
             nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             nik = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             tmpLahir = eElement.getElementsByTagName("TempatLahir").item(0).getTextContent();
             JKel = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             agama = eElement.getElementsByTagName("Agama").item(0).getTextContent();
             statusP = eElement.getElementsByTagName("StatusPernikahan").item(0).getTextContent();
             pendT = eElement.getElementsByTagName("PendidikanTerakhir").item(0).getTextContent();
             gol = eElement.getElementsByTagName("Golongan").item(0).getTextContent();
             tmt = eElement.getElementsByTagName("tmt").item(0).getTextContent();
             telp = eElement.getElementsByTagName("Telepon").item(0).getTextContent();
             noHP = eElement.getElementsByTagName("noHP").item(0).getTextContent();
             email = eElement.getElementsByTagName("Email").item(0).getTextContent();
             alamat = eElement.getElementsByTagName("Alamat").item(0).getTextContent();
            dos.add(new Dosen(nama, nik, tmpLahir, JKel, agama, statusP, pendT, gol, tmt, telp, noHP, email, alamat));
          }
       }
    }
}
