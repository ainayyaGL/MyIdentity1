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
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author zain
 */
public class ListToXMLDak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Dakwah> dakwahDosen = new ArrayList ();
        dakwahDosen.add(new Dakwah("A","A", "2010"));
        dakwahDosen.add(new Dakwah("B","B", "2011"));
        dakwahDosen.add(new Dakwah("C","C", "2012"));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("Dakwah");
       doc.appendChild(rootElement);
       
       for(int i=0; i<dakwahDosen.size();i++){
           Element elemen_dakwah = doc.createElement("DakwahDosen");
           elemen_dakwah.setAttribute("PeranDakwah", ""+dakwahDosen.get(i).getPeran());
           rootElement.appendChild(elemen_dakwah);
           
           Element fieldDakwah = doc.createElement("InstitusiDakwah");
           fieldDakwah.setTextContent(dakwahDosen.get(i).getInstitusi());
           elemen_dakwah.appendChild(fieldDakwah);
           
           Element fieldDwh = doc.createElement("Tanggal");
           fieldDwh.setTextContent(dakwahDosen.get(i).getTglDak());
           elemen_dakwah.appendChild(fieldDwh);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("dakwah.xml"));
       transformer.transform(dom, result);
    }
}
