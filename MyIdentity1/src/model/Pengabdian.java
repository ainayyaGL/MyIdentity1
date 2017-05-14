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
public class Pengabdian {
    String nik = null; 
    String PeranPeng = null;
    String InstPeng = null;
    String TglPeng = null;
    
    public Pengabdian(String _nik, String _peranpeng, String _instpeng, String _tglpeng)
    {
        this.nik = _nik;
        this.PeranPeng = _peranpeng;
        this.InstPeng = _instpeng;
        this.TglPeng = _tglpeng;
    }
    
    public String getNIK(){
        return nik;
    }
    public String getPeranPeng()
    {
        return PeranPeng;
    }
     public String getInstPeng()
    {
        return InstPeng;
    }
      public String getTglPeng()
    {
        return TglPeng;
    }
}
