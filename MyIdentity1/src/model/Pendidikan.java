/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Pendidikan { String No = null;
    String Pendidikan = null;
    String Institusi = null;
    String thnLulus = null;
    
    public Pendidikan(String _No, String _Pendidikan, String _Institusi, String _thnLulus )
    {
        this.No = _No;
        this.Pendidikan = _Pendidikan;
        this.Institusi = _Institusi;
        this.thnLulus = _thnLulus;
    }
    
    public String getNo()
    {
        return No;
    }
     public String getPendidikan()
    {
        return Pendidikan;
    }
      public String getInstitusi()
    {
        return Institusi;
    }
      public String getthnLulus()
    {
        return thnLulus;
    }
}
