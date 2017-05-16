/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Dakwah;

import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;

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
        dakwahDosen.add(new Dakwah("123","A","A", LocalDate.parse("2010-10-02")));
        dakwahDosen.add(new Dakwah("145","B","B", LocalDate.parse("2011-09-12")));
        dakwahDosen.add(new Dakwah("234","C","C", LocalDate.parse("2012-08-13")));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("Dakwah");
       doc.appendChild(rootElement);
       
       for(int i=0; i<dakwahDosen.size();i++){
           Element elemen_dakwah = doc.createElement("DakwahDosen");
           elemen_dakwah.setAttribute("NIK", ""+dakwahDosen.get(i).getNIK());
           rootElement.appendChild(elemen_dakwah);
           
           Element fieldPeran = doc.createElement("PeranDakwah");
           fieldPeran.setTextContent(dakwahDosen.get(i).getPeran());
           elemen_dakwah.appendChild(fieldPeran);
           
           Element fieldDakwah = doc.createElement("InstitusiDakwah");
           fieldDakwah.setTextContent(dakwahDosen.get(i).getInstitusi());
           elemen_dakwah.appendChild(fieldDakwah);
           
           Element fieldDwh = doc.createElement("Tanggal");
           fieldDwh.setTextContent(dakwahDosen.get(i).getTglDak().toString());
           elemen_dakwah.appendChild(fieldDwh);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("dakwah.xml"));
       transformer.transform(dom, result);
    }
}
