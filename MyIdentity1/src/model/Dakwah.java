/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author zain
 */
public class Dakwah {
    String nik = null;
    String PeranDak = null;
    String InstitusiDak = null;
    LocalDate TglDak = LocalDate.parse("0000-01-01");
    
    public Dakwah(String _nik, String _perandak, String _instdak, LocalDate _tgldak)
    {
        this.nik = _nik;
        this.PeranDak = _perandak;
        this.InstitusiDak = _instdak;
        this.TglDak = _tgldak;
    }
    
    public String getNIK(){
        return nik;
    }
    public String getPeran()
    {
        return PeranDak;
    }
     public String getInstitusi()
    {
        return InstitusiDak;
    }
      public LocalDate getTglDak()
    {
        return TglDak;
    }
}
