/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Amalia Citra
 */
public class Penunjang {
    String nik = null;
    String KegPen = null;
    String PeranPen = null;
    String InstPen = null;
    String TglPen = null;
    
     public Penunjang(String _nik, String _KegPen, String _PeranPen, String _InstPen, String _TglPen )
     {
        this.nik = _nik;
        this.KegPen = _KegPen;
        this.PeranPen = _PeranPen;
        this.InstPen = _InstPen;
        this.TglPen = _TglPen;
    }

     public String getNIK(){
         return nik;
     }
    public String getKegPen() {
        return KegPen;
    }

    public String getPeranPen() {
        return PeranPen;
    }

    public String getInstPen() {
        return InstPen;
    }

    public String getTglPen() {
        return TglPen;
    }
}
