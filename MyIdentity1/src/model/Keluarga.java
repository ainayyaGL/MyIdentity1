/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zain
 */
public class Keluarga {
    String nik = null;
    String nama = null;
    String jKel = null;
    String pend = null;

    public Keluarga( String Nik, String Nama, String Kela, String pendi) {
        this.nik = Nik;
        this.nama = Nama;
        this.jKel = Kela;
        this.pend = pendi;
    }
    
    public Keluarga(){
        
    }

    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public String getjKel() {
        return jKel;
    }

    public String getPend() {
        return pend;
    }
    
   
}
