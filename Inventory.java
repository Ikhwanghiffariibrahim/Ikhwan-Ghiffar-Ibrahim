/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.app.uts.npm016;

/**
 *
 * @author notebook
 */
public class Inventory {
    private String IdBarang;
    private String NamaBarang;
    private String JenisBarang;
    private String Harga;
    private String Jumlah;
    

    public Inventory() {
    }

    //pembuatan constructor

    public Inventory(String IdBarang, String NamaBarang, String JenisBarang, String Harga , String Jumlah) {
        this.IdBarang = IdBarang;
        this.NamaBarang = NamaBarang;
        this.JenisBarang = JenisBarang;
        this.Harga = Harga;
        this.Jumlah = Jumlah;
    }
    public String getIdBarang() {   
        return IdBarang;
    }

    public void getIdBarang(String IdBarang) {
        this.IdBarang = IdBarang;
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String NamaBarang) {
        this.NamaBarang = NamaBarang;
    }

    public String getJenisBarang() {
        return JenisBarang;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getHarga() {
        return Harga;
    }

    public void setJumlah(String Jumlah) {
        this.Jumlah = Jumlah;
    }

    public String getJumlah() {
        return Jumlah;
    }

    //pembuatan getter dan setter untuk variable yang sudah dibuat
    public void setJumlah(String Jumlah) {
        this.Jumlah = Jumlah;
    }

    //pembuatan object untuk tampil data
    public Object getValue(int index) {
        switch (index) {
            case 0:
                return IdBarang;
            case 1:
                return NamaBarang;
            case 2:
                return JenisBarang;
            case 3:
                return Harga;
            case 4:
                return Jumlah;
            
            default:
                return null;
        }
    }

    void setIdBarang(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setJenisBarang(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setIdBarang(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    




