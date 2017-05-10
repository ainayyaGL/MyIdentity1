/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.KeluargaKar;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
public class XmlToListKelKar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <KeluargaKar> daftarKeluarga = new ArrayList ();
        String Nik, NamaKel, JKel, sttKel, strTglLahir,RootElemen, RowElemen;
        LocalDate tglLahir;
    
        
       File fileXML = new File("keluarga karyawan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("keluarga");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             
             Nik = eElement.getElementsByTagName("Nik").item(0).getTextContent();
             NamaKel = eElement.getElementsByTagName("Nama Keluarga").item(0).getTextContent();
             JKel = eElement.getElementsByTagName("Jenis Kelamin Keluarga").item(0).getTextContent();
             sttKel = eElement.getElementsByTagName("Status Keluarga").item(0).getTextContent();
             strTglLahir = eElement.getElementsByTagName("tglLahir").item(0).getTextContent();
             tglLahir = LocalDate.parse(strTglLahir);
             daftarKeluarga.add(new KeluargaKar(Nik, NamaKel, JKel, sttKel, tglLahir));
          }
       }
    }    
}
