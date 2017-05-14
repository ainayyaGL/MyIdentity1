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
public class ListToXMLPend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Pendidikan> daftarPendidikan = new ArrayList ();
        daftarPendidikan.add(new Pendidikan("123","1", "S1","UII", "2009"));
        daftarPendidikan.add(new Pendidikan("134","2", "S2","UGM", "1998"));
        daftarPendidikan.add(new Pendidikan("145","3", "S1","ITB", "2005"));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("daftarPendidikan");
       doc.appendChild(rootElement);
       
       for(int i=0; i<daftarPendidikan.size();i++){
           Element elemen_pendidikan = doc.createElement("TabelPendidikan");
           elemen_pendidikan.setAttribute("NIK",""+daftarPendidikan.get(i).getNik());
           rootElement.appendChild(elemen_pendidikan);
           
           Element fieldNo = doc.createElement("No");
           fieldNo.setTextContent(daftarPendidikan.get(i).getNo());
           elemen_pendidikan.appendChild(fieldNo);
           
           Element fieldPendidikan = doc.createElement("Pendidikan");
           fieldPendidikan.setTextContent(daftarPendidikan.get(i).getPendidikan());
           elemen_pendidikan.appendChild(fieldPendidikan);
           
           Element fieldInstitusi = doc.createElement("Institusi");
           fieldInstitusi.setTextContent(daftarPendidikan.get(i).getInstitusi());
           elemen_pendidikan.appendChild(fieldInstitusi);
           
           Element fieldthnLulus = doc.createElement("TahunLulus");
           fieldthnLulus.setTextContent(daftarPendidikan.get(i).getthnLulus());
           elemen_pendidikan.appendChild(fieldthnLulus);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);

       StreamResult result = new StreamResult(new File("pendidikan.xml"));
       transformer.transform(dom, result);
    }
}
