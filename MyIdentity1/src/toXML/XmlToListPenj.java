/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Penunjang;

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
public class XmlToListPenj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Penunjang> penunjang = new ArrayList ();
        String nik, KegPen, PeranPen, InstPen, TglPen, RootElemen, RowElemen;
    
        
        
       File fileXML = new File("penunjang.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(fileXML);
       doc.getDocumentElement().normalize();
       
       RootElemen = doc.getDocumentElement().getNodeName();
       NodeList nList = doc.getElementsByTagName("Penunjang");

       for (int i = 0; i < nList.getLength(); i++) {
          Node nNode = nList.item(i);
          RowElemen = nNode.getNodeName();
          System.out.println("\nCurrent Element :" + nNode.getNodeName());
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             nik = eElement.getAttribute("NIM");
             KegPen = eElement.getElementsByTagName("Kegiatan").item(0).getTextContent();
             PeranPen = eElement.getElementsByTagName("Peran").item(0).getTextContent();
             InstPen = eElement.getElementsByTagName("Institusi").item(0).getTextContent();
             TglPen = eElement.getElementsByTagName("Tanggal").item(0).getTextContent();
             penunjang.add(new Penunjang(nik,KegPen, PeranPen, InstPen, TglPen));
          }
       }
    }
}
