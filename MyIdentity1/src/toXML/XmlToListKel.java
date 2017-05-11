/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Keluarga;

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
public class XmlToListKel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Keluarga> keluarga = new ArrayList ();
        String NIK, Nama, jKel, pend, RootElemen, RowElemen;
      
        
        
       File fileXML = new File("keluarga.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Keluarga");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NIK = eElement.getAttribute("NIK");
             Nama = eElement.getElementsByTagName("Nama").item(0).getTextContent();
             jKel = eElement.getElementsByTagName("JenisKelamin").item(0).getTextContent();
             pend = eElement.getElementsByTagName("Pendidikan").item(0).getTextContent();            
            keluarga.add(new Keluarga(NIK, Nama, jKel, pend));
          }
       }
    }
}
