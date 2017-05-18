/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.KeluargaKar;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author zain
 */
public class ListToXmlKelKar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        List <KeluargaKar> daftarKeluarga = new ArrayList ();
        daftarKeluarga.add(new KeluargaKar("1", "Maghfiroh","P","Istri",LocalDate.parse("1972-10-12")));
        daftarKeluarga.add(new KeluargaKar("2", "Rifka Ilma Nafi'a","P", "Anak", LocalDate.parse("1999-04-24")));
        

       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("daftarKeluarga");
       doc.appendChild(rootElement);
       
       for(int i=0; i<daftarKeluarga.size();i++){
           Element elemen_keluarga = doc.createElement("TabelKeluargaKaryawan");
           elemen_keluarga.removeAttribute("");
           rootElement.appendChild(elemen_keluarga);
           
           Element fieldNik = doc.createElement("NIK");
           fieldNik.setTextContent(daftarKeluarga.get(i).getNik());
           elemen_keluarga.appendChild(fieldNik);
           
           Element fieldNamaKel = doc.createElement("NamaKeluarga");
           fieldNamaKel.setTextContent(daftarKeluarga.get(i).getNamaKel());
           elemen_keluarga.appendChild(fieldNamaKel);
           
           Element fieldJKel = doc.createElement("JenisKelamin");
           fieldJKel.setTextContent(daftarKeluarga.get(i).getJKel());
           elemen_keluarga.appendChild(fieldJKel);
           
           Element fieldsttKel = doc.createElement("StatusKeluarga");
           fieldsttKel.setTextContent(daftarKeluarga.get(i).getSttKel());
           elemen_keluarga.appendChild(fieldsttKel);
           
           Element fieldtglLahir = doc.createElement("TanggalLahir");
           fieldtglLahir.setTextContent(daftarKeluarga.get(i).getTglLahir().toString());
           elemen_keluarga.appendChild(fieldtglLahir);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);

       StreamResult result = new StreamResult(new File("keluarga karyawan.xml"));
       transformer.transform(dom, result);
    }
}
