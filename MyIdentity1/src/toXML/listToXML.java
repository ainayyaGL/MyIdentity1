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
public class listToXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Keluarga> kel = new ArrayList ();
        kel.add(new Keluarga("17529001","A", "P","S1"));
        kel.add(new Keluarga("17529001","B", "P","S1"));
        kel.add(new Keluarga("17529001","C", "P","S1"));
        kel.add(new Keluarga("17529001","D", "P","S1"));
        kel.add(new Keluarga("17529001","E", "L", "S1"));

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("keluarga");
       doc.appendChild(rootElement);
       
       for(int i=0; i<kel.size();i++){
           Element elemen_keluarga = doc.createElement("Keluarga");
           elemen_keluarga.setAttribute("NIK", ""+kel.get(i).getNik());
           rootElement.appendChild(elemen_keluarga);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(kel.get(i).getNama());
           elemen_keluarga.appendChild(fieldNama);
           
           Element fieldJkel = doc.createElement("JenisKelamin");
           fieldJkel.setTextContent(kel.get(i).getjKel().toString());
           elemen_keluarga.appendChild(fieldJkel);
           
           Element fieldPend = doc.createElement("Pendidikan");
           fieldPend.setTextContent(kel.get(i).getPend().toString());
           elemen_keluarga.appendChild(fieldPend);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("keluarga.xml"));
       transformer.transform(dom, result);
    }
}
