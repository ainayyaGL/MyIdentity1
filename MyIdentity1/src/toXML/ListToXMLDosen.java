/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Dosen;

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
public class ListToXMLDosen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <Dosen> dos = new ArrayList ();
        dos.add(new Dosen("Hendrik, S.T.,M.Eng.","055230503", "Palembang","Pria", "Islam", "Menikah", "S2", "IId/PenataTK.I", "1 April 2016","0274-898444", "08122742953", "hendrik@fti.uii.ac.id", "Pondok Arjuna, Jl. Kaliurang km 5 Gg. Anggur Blok V/10 C Yogyakarta"));

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("dosen");
       doc.appendChild(rootElement);
       
       for(int i=0; i<dos.size();i++){
           Element elemen_dosen = doc.createElement("Dosen");
           elemen_dosen.setAttribute("NIK", ""+dos.get(i).getNik());
           rootElement.appendChild(elemen_dosen);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(dos.get(i).getNama());
           elemen_dosen.appendChild(fieldNama);
           
           Element fieldtmpLahir = doc.createElement("TempatLahir");
           fieldtmpLahir.setTextContent(dos.get(i).getTmpLahir().toString());
           elemen_dosen.appendChild(fieldtmpLahir);
           
           Element fieldJKel = doc.createElement("JenisKelamin");
           fieldJKel.setTextContent(dos.get(i).getJKel().toString());
           elemen_dosen.appendChild(fieldJKel);
           
            Element fieldAgama = doc.createElement("Agama");
           fieldAgama.setTextContent(dos.get(i).getAgama().toString());
           elemen_dosen.appendChild(fieldAgama);
           
           Element fieldstatusP = doc.createElement("StatusPernikahan");
           fieldstatusP.setTextContent(dos.get(i).getStatusP().toString());
           elemen_dosen.appendChild(fieldstatusP);
          
           Element fieldPendT = doc.createElement("Pendidikan");
           fieldPendT.setTextContent(dos.get(i).getPendT().toString());
           elemen_dosen.appendChild(fieldPendT);
           
           Element fieldgol = doc.createElement("GolonganPangkat");
           fieldgol.setTextContent(dos.get(i).getGol().toString());
           elemen_dosen.appendChild(fieldgol);
           
           Element fieldtmt = doc.createElement("tmt");
           fieldtmt.setTextContent(dos.get(i).getTmt().toString());
           elemen_dosen.appendChild(fieldtmt);
           
           Element fieldtelp = doc.createElement("Telepon");
           fieldtelp.setTextContent(dos.get(i).getTelp().toString());
           elemen_dosen.appendChild(fieldtelp);
           
           Element fieldnoHp = doc.createElement("noHP");
           fieldnoHp.setTextContent(dos.get(i).getNoHp().toString());
           elemen_dosen.appendChild(fieldnoHp);
           
           Element fieldemail = doc.createElement("Email");
           fieldemail.setTextContent(dos.get(i).getEmail().toString());
           elemen_dosen.appendChild(fieldemail);

           Element fieldalamat = doc.createElement("Alamat");
           fieldalamat.setTextContent(dos.get(i).getAlamat().toString());
           elemen_dosen.appendChild(fieldalamat);
           
           
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("Dosen.xml"));
       transformer.transform(dom, result);
    }
}
