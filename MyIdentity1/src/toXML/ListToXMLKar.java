/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toXML;

import model.Karyawannn;

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
public class ListToXMLKar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
        List <Karyawannn> karyawan = new ArrayList ();
        karyawan.add(new Karyawannn("Sugiyo","Laki-laki","16523990","Gunung Kidul", LocalDate.parse("1974-04-25"),
                "Islam","S1",LocalDate.parse("2012-04-01"),
                "PengaturMuda/IIa","Admin",LocalDate.parse("2017-05-15"),"19.1",LocalDate.parse("2008-04-25"),
                "30","Tetap",LocalDate.parse("2011-04-25"),"DivisiAdministrasiAkademik","0271885010","086726445033","ulep@exsample.com","JlnABCDEno.123",LocalDate.parse("1998-04-01"),"Staf"));
        
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.newDocument();
       doc.setXmlStandalone(true);
       Element rootElement = doc.createElement("karyawan");
       doc.appendChild(rootElement);
       
       for(int i=0; i<karyawan.size();i++){
           Element elemen_karyawan = doc.createElement("Karyawan");
           elemen_karyawan.setAttribute("NIK", ""+karyawan.get(i).getNIK());
           rootElement.appendChild(elemen_karyawan);
           
           Element fieldNama = doc.createElement("Nama");
           fieldNama.setTextContent(karyawan.get(i).getNamaKar());
           elemen_karyawan.appendChild(fieldNama);
           
           Element fieldJKel = doc.createElement("JenisKelamin");
           fieldJKel.setTextContent(karyawan.get(i).getJKel());
           elemen_karyawan.appendChild(fieldJKel);
           
           Element fieldTmpLahir = doc.createElement("TempatLahir");
           fieldTmpLahir.setTextContent(karyawan.get(i).getTmpLahir());
           elemen_karyawan.appendChild(fieldTmpLahir);
           
           Element fieldTglLahir = doc.createElement("TanggalLahir");
           fieldTglLahir.setTextContent(karyawan.get(i).getTglLahir().toString());
           elemen_karyawan.appendChild(fieldTglLahir);
           
           Element fieldAgama = doc.createElement("Agama");
           fieldAgama.setTextContent(karyawan.get(i).getAgama());
           elemen_karyawan.appendChild(fieldAgama);
           
           Element fieldPendTing = doc.createElement("PendidikanTertinggi");
           fieldPendTing.setTextContent(karyawan.get(i).getPendTing());
           elemen_karyawan.appendChild(fieldPendTing);
           
           Element fieldTMT = doc.createElement("TMT");
           fieldTMT.setTextContent(karyawan.get(i).getTMT().toString());
           elemen_karyawan.appendChild(fieldTMT);
           
           Element fieldPangGol = doc.createElement("PangkatGolongan");
           fieldPangGol.setTextContent(karyawan.get(i).getPangGol());
           elemen_karyawan.appendChild(fieldPangGol);
           
           Element fieldJab = doc.createElement("Jabatan");
           fieldJab.setTextContent(karyawan.get(i).getJab());
           elemen_karyawan.appendChild(fieldJab);
           
           Element fieldToday = doc.createElement("Today");
           fieldToday.setTextContent(karyawan.get(i).getToday().toString());
           elemen_karyawan.appendChild(fieldToday);
           
           Element fieldMasKer = doc.createElement("MasaKerja");
           fieldMasKer.setTextContent(karyawan.get(i).getMasaKerja());
           elemen_karyawan.appendChild(fieldMasKer);
           
           Element fieldMPP = doc.createElement("MPP");
           fieldMPP.setTextContent(karyawan.get(i).getMPP().toString());
           elemen_karyawan.appendChild(fieldMPP);
           
           Element fieldUmur = doc.createElement("Umur");
           fieldUmur.setTextContent(karyawan.get(i).getUmur());
           elemen_karyawan.appendChild(fieldUmur);
           
           Element fieldStatKer = doc.createElement("StatusKerja");
           fieldStatKer.setTextContent(karyawan.get(i).getStatKer());
           elemen_karyawan.appendChild(fieldStatKer);
           
           Element fieldPens = doc.createElement("Pensiun");
           fieldPens.setTextContent(karyawan.get(i).getPensiun().toString());
           elemen_karyawan.appendChild(fieldPens);
           
           Element fieldUnitKer = doc.createElement("UnitKerja");
           fieldUnitKer.setTextContent(karyawan.get(i).getUnitKer());
           elemen_karyawan.appendChild(fieldUnitKer);
           
           Element fieldTelp = doc.createElement("Telepon");
           fieldTelp.setTextContent(karyawan.get(i).getTlpn());
           elemen_karyawan.appendChild(fieldTelp);
           
           Element fieldNoHp = doc.createElement("NoHp");
           fieldNoHp.setTextContent(karyawan.get(i).getNoHP());
           elemen_karyawan.appendChild(fieldNoHp);
           
           Element fieldEmail = doc.createElement("Email");
           fieldEmail.setTextContent(karyawan.get(i).getEmail());
           elemen_karyawan.appendChild(fieldEmail);
           
           Element fieldAlamat = doc.createElement("Alamat");
           fieldAlamat.setTextContent(karyawan.get(i).getAlamat());
           elemen_karyawan.appendChild(fieldAlamat);
           
           Element fieldSKper = doc.createElement("SKPertama");
           fieldSKper.setTextContent(karyawan.get(i).getSkPer().toString());
           elemen_karyawan.appendChild(fieldSKper);
           
           Element fieldJabStruk = doc.createElement("JabatanStruktural");
           fieldJabStruk.setTextContent(karyawan.get(i).getJabStruk());
           elemen_karyawan.appendChild(fieldJabStruk);
       }
       
       TransformerFactory transformerFactory = TransformerFactory.newInstance();
       Transformer transformer = transformerFactory.newTransformer();
       DOMSource dom = new DOMSource(doc);
       StreamResult result = new StreamResult(new File("karyawan.xml"));
       transformer.transform(dom, result);
    }
}
