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
public class ListToXMLKarIl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <KaryaIlmiah> daftarPenelitian = new ArrayList ();
        daftarPenelitian.add(new KaryaIlmiah("123","1", "Anak Sholeh","Analis", "UII", "Bank", "1.000.000", "2013"));
        daftarPenelitian.add(new KaryaIlmiah("234","2", "Sudah Pasti","Designer", "UII", "Bank", "3.000.000", "2014"));
        daftarPenelitian.add(new KaryaIlmiah("145","3", "Masuk Surga","Tester", "UII", "Bank", "5.000.000", "2015"));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("daftarPenelitian");
       doc.appendChild(rootElement);
       
       for(int i=0; i<daftarPenelitian.size();i++){
           Element elemen_penelitian = doc.createElement("TabelPenelitian");
           elemen_penelitian.setAttribute("NIK",""+daftarPenelitian.get(i).getNIK());
           rootElement.appendChild(elemen_penelitian);
           
           Element fieldNo = doc.createElement("No");
           fieldNo.setTextContent(daftarPenelitian.get(i).getNo());
           elemen_penelitian.appendChild(fieldNo);
           
           Element fieldJudul = doc.createElement("JudulPenelitian");
           fieldJudul.setTextContent(daftarPenelitian.get(i).getJudul());
           elemen_penelitian.appendChild(fieldJudul);
           
           Element fieldPeran = doc.createElement("PeranPenelitian");
           fieldPeran.setTextContent(daftarPenelitian.get(i).getPeran());
           elemen_penelitian.appendChild(fieldPeran);
           
           Element fieldInstitusi = doc.createElement("Institusi");
           fieldInstitusi.setTextContent(daftarPenelitian.get(i).getInstitusi());
           elemen_penelitian.appendChild(fieldInstitusi);
           
           Element fieldSumberDana = doc.createElement("SumberDana");
           fieldSumberDana.setTextContent(daftarPenelitian.get(i).getSumberDana());
           elemen_penelitian.appendChild(fieldSumberDana);
           
           Element fieldNilaiDana = doc.createElement("NilaiDana");
           fieldNilaiDana.setTextContent(daftarPenelitian.get(i).getNilaiDana());
           elemen_penelitian.appendChild(fieldNilaiDana);
           
           Element fieldTahunPen = doc.createElement("TahunPenelitian");
           fieldTahunPen.setTextContent(daftarPenelitian.get(i).getTahunPen());
           elemen_penelitian.appendChild(fieldTahunPen);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);

       StreamResult result = new StreamResult(new File("penelitian.xml"));
       transformer.transform(dom, result);
    }
}
