/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Pendidikan;

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
public class XmlToListPend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Pendidikan> daftarPendidikan = new ArrayList ();
        String nik, No, Pendidikan, Intitusi, thnLulus, RootElemen, RowElemen;
    
        
       File fileXML = new File("pendidikan.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("pendidikan");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             
             No = eElement.getElementsByTagName("No").item(0).getTextContent();
             nik = eElement.getAttribute("NIK");
             Pendidikan = eElement.getElementsByTagName("Pendidikan").item(0).getTextContent();
             Intitusi = eElement.getElementsByTagName("Intitusi").item(0).getTextContent();
             thnLulus = eElement.getElementsByTagName("Tahun Lulus").item(0).getTextContent();
             daftarPendidikan.add(new Pendidikan(No,nik, Pendidikan, Intitusi, thnLulus));
          }
       }
    }    
}
