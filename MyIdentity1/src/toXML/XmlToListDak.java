/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Dakwah;

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
public class XmlToListDak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Dakwah> dakwah = new ArrayList ();
        String PeranDak, InstitusiDak, TglDak, RootElemen, RowElemen;
      
        
        
       File fileXML = new File("dakwah.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Dakwah");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             PeranDak = eElement.getAttribute("PeranDakwah");
             InstitusiDak = eElement.getElementsByTagName("InstitusiDakwah").item(0).getTextContent();
             TglDak = eElement.getElementsByTagName("PeranDakwah").item(0).getTextContent();
             dakwah.add(new Dakwah(PeranDak, InstitusiDak, TglDak));
          }
       }
    }
}
