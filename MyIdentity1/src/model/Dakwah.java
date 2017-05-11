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
public class Dakwah {
    String PeranDak = null;
    String InstitusiDak = null;
    String TglDak = null;
    
    public Dakwah(String _perandak, String _instdak, String _tgldak)
    {
        this.PeranDak = _perandak;
        this.InstitusiDak = _instdak;
        this.TglDak = _tgldak;
    }
    
    public String getPeran()
    {
        return PeranDak;
    }
     public String getInstitusi()
    {
        return InstitusiDak;
    }
      public String getTglDak()
    {
        return TglDak;
    }
}
