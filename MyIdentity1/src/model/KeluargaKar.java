/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author user
 */
public class KeluargaKar { String Nik = null;
    String NamaKel = null;
    String JKel = null;
    String sttKel = null;
    LocalDate tglLahir = LocalDate.parse ("0000-01-01");
    
    public KeluargaKar(String _Nik, String _NamaKel, String _JKel, String _sttKel, LocalDate _tglLahir )
    {
        this.Nik = _Nik;
        this.NamaKel = _NamaKel;
        this.JKel = _JKel;
        this.sttKel = _sttKel;
        this.tglLahir = _tglLahir;
    }
    
    public String getNik()
    {
        return Nik;
    }

    public String getNamaKel() {
        return NamaKel;
    }

    public String getJKel() {
        return JKel;
    }

    public String getSttKel() {
        return sttKel;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }
     
}
