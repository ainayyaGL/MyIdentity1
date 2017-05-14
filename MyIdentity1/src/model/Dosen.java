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
public class Dosen {
    String nama = null;
    String nik = null;
    String tmpLahir = null;
    String JKel = null;
    String agama = null;
    String statusP = null;
    String pendT = null;
    String gol = null;
    String tmt = null;
    String telp = null;
    String noHp = null;
    String email = null;
    String alamat = null;

    public Dosen(String _nama, String _nik, String _tmpL, String _Jkel, String _agama, String _statusP, String _pendT, String _gol, String _tmt, String _telp, String _noHP, String _email, String _alamat ) {
    this.nama = _nama;
    this.nik = _nik;
    this.tmpLahir = _tmpL;
    this.JKel=_Jkel;
    this.agama =  _agama;
    this.statusP = _statusP;
    this.pendT = _pendT;
    this.gol = _gol;
    this.tmt =  _tmt; 
    this.telp = _telp;
    this.noHp = _noHP;
    this.email = _email;
    this.alamat = _alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getTmpLahir() {
        return tmpLahir;
    }

    public String getJKel() {
        return JKel;
    }

    public String getAgama() {
        return agama;
    }

    public String getStatusP() {
        return statusP;
    }

    public String getPendT() {
        return pendT;
    }

    public String getGol() {
        return gol;
    }

    public String getTmt() {
        return tmt;
    }


    public String getTelp() {
        return telp;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }
    
    
    
    
    
    
    
    
   
}
