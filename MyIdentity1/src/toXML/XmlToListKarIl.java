/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.KaryaIlmiah;

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
public class XmlToListKarIl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <KaryaIlmiah> daftarPenelitian = new ArrayList ();
        String No, Judul, Peran, Institusi, sumberDana, nilaiDana, 
                tahunPen, RootElemen, RowElemen;
    
        
       File fileXML = new File("penelitian.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("penelitian");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             
             No = eElement.getElementsByTagName("No").item(0).getTextContent();
             Judul = eElement.getElementsByTagName("JudulPenelitian").item(0).getTextContent();
             Peran = eElement.getElementsByTagName("PeranPenelitian").item(0).getTextContent();
             Institusi = eElement.getElementsByTagName("Intitusi").item(0).getTextContent();
             sumberDana = eElement.getElementsByTagName("SumberDana").item(0).getTextContent();
             nilaiDana = eElement.getElementsByTagName("NilaiDana").item(0).getTextContent();
             tahunPen = eElement.getElementsByTagName("TahunPenelitian").item(0).getTextContent();
             daftarPenelitian.add(new KaryaIlmiah(No, Judul, Peran, Institusi, sumberDana,
                     nilaiDana, tahunPen));
          }
       }
    }    
}
