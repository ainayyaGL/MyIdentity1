/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Pengabdian;

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
public class ListToXMLPeng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Pengabdian> pengabdian = new ArrayList ();
        pengabdian.add(new Pengabdian("17529001","A","A", LocalDate.parse("2010-01-01")));
        pengabdian.add(new Pengabdian("17529002","B","B", LocalDate.parse("2011-01-01")));
        pengabdian.add(new Pengabdian("17529003","C","C",LocalDate.parse("2012-01-01")));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("Pengabdian");
       doc.appendChild(rootElement);
       
       for(int i=0; i<pengabdian.size();i++){
           Element elemen_pengabdian = doc.createElement("pengabdian");
           elemen_pengabdian.setAttribute("NIK", ""+pengabdian.get(i).getNIK());
           rootElement.appendChild(elemen_pengabdian);
           
           Element fieldPeran = doc.createElement("Peran");
           fieldPeran.setTextContent(pengabdian.get(i).getPeranPeng());
           elemen_pengabdian.appendChild(fieldPeran);
           
           Element fieldInst = doc.createElement("Institusi");
           fieldInst.setTextContent(pengabdian.get(i).getInstPeng());
           elemen_pengabdian.appendChild(fieldInst);
           
           Element fieldTgl = doc.createElement("Tanggal");
           fieldTgl.setTextContent(pengabdian.get(i).getTglPeng().toString());
           elemen_pengabdian.appendChild(fieldTgl);
       }
       
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("pengabdian.xml"));
       transformer.transform(dom, result);
    }
}
