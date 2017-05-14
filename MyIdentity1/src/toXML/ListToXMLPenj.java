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
public class ListToXMLPenj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Penunjang> penunjang = new ArrayList ();
        penunjang.add(new Penunjang("123","Ngajar","Dosen", "UII", "2010"));
        penunjang.add(new Penunjang("145","Mengisi kajian","Ustadz", "Masjid Ulil Albab", "2010"));
        penunjang.add(new Penunjang("146","Baksos","Relawan", "Desa Sukamaju", "2015"));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("Penunjang");
       doc.appendChild(rootElement);
       
       for(int i=0; i<penunjang.size();i++){
           Element elemen_penunjang = doc.createElement("DaftarPenunjang");
           elemen_penunjang.setAttribute("NIK",""+penunjang.get(i).getNIK());
           rootElement.appendChild(elemen_penunjang);
           
           Element fieldKeg = doc.createElement("Kegiatan");
           fieldKeg.setTextContent(penunjang.get(i).getKegPen());
           elemen_penunjang.appendChild(fieldKeg);
           
           Element fieldPeran = doc.createElement("Peran");
           fieldPeran.setTextContent(penunjang.get(i).getPeranPen());
           elemen_penunjang.appendChild(fieldPeran);
           
           Element fieldInst = doc.createElement("Institusi");
           fieldInst.setTextContent(penunjang.get(i).getInstPen());
           elemen_penunjang.appendChild(fieldInst);
           
           Element fieldTgl = doc.createElement("Tanggal");
           fieldTgl.setTextContent(penunjang.get(i).getTglPen());
           elemen_penunjang.appendChild(fieldTgl);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("penunjang.xml"));
       transformer.transform(dom, result);
    }
}
