/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Karyawannn;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;

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
public class XmlToListKar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Karyawannn> karyawan = new ArrayList ();
        String NamaKar,JKel,NIK,TmpLahir,Agama,PendTing,PangGol,
                Jab,MasaKerja,umur,StatKer,UnitKer,tlpn,
                noHP,email,alamat,JabStruk,RootElemen,RowElemen, strTglLahir, strTMT,strpensiun, strToday, strMPP, strskPer;
        LocalDate TglLahir,TMT,Today,MPP,skPer,pensiun;
        
        
       File fileXML = new File("karyawan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Karyawan");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          //System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK = eElement.getAttribute("NIK");
             NamaKar = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             JKel = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             TmpLahir = eElement.getElementsByTagName("TempatLahir").item(0).getTextContent();
             strTglLahir = eElement.getElementsByTagName("TanggalLahir").item(0).getTextContent();
             TglLahir = LocalDate.parse(strTglLahir);
             Agama = eElement.getElementsByTagName("Agama").item(0).getTextContent();
             PendTing = eElement.getElementsByTagName("PendidikanTertinggi").item(0).getTextContent();
             strTMT = eElement.getElementsByTagName("TMT").item(0).getTextContent();
             TMT = LocalDate.parse(strTMT);
             PangGol = eElement.getElementsByTagName("PangkatGolongan").item(0).getTextContent();
             Jab = eElement.getElementsByTagName("Jabatan").item(0).getTextContent();
             strToday = eElement.getElementsByTagName("Today").item(0).getTextContent();
             Today = LocalDate.parse(strToday);
             MasaKerja = eElement.getElementsByTagName("MasaKerja").item(0).getTextContent();
             strMPP = eElement.getElementsByTagName("MPP").item(0).getTextContent();
             MPP = LocalDate.parse(strMPP);
             umur = eElement.getElementsByTagName("Umur").item(0).getTextContent();
             StatKer = eElement.getElementsByTagName("StatusKerja").item(0).getTextContent();
             strpensiun = eElement.getElementsByTagName("Pensiun").item(0).getTextContent();
             pensiun = LocalDate.parse(strpensiun);
             UnitKer = eElement.getElementsByTagName("UnitKerja").item(0).getTextContent();
             tlpn = eElement.getElementsByTagName("Telepon").item(0).getTextContent();
             noHP = eElement.getElementsByTagName("NoHP").item(0).getTextContent();
             email = eElement.getElementsByTagName("Email").item(0).getTextContent();
             alamat = eElement.getElementsByTagName("Alamat").item(0).getTextContent();
             strskPer = eElement.getElementsByTagName("SKPertama").item(0).getTextContent();
             skPer = LocalDate.parse(strskPer);
             JabStruk = eElement.getElementsByTagName("JabatanStruktural").item(0).getTextContent();
             karyawan.add(new Karyawannn (NamaKar, JKel, NIK, TmpLahir,TglLahir,Agama, PendTing,TMT, PangGol, Jab, Today, MasaKerja, MPP, umur, StatKer, pensiun,UnitKer,tlpn,noHP,email,alamat,skPer,JabStruk));
                
          }
       }
    }
}
