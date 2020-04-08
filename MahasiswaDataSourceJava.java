/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm016;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author notebook
 */
public class MahasiswaDataSourceJava {
     private final Connection connection;
    
    //berisi fungsi atau method bisa melakukan operasi database
    public MahasiswaDataSourceJava(){
        connection = ConnectionUtil.getConnection();
    }
    
    public List<Inventory> getALL(){
        List<Inventory> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Inventory mhs;
            while (rs.next()) {                
                mhs = new Inventory();
                mhs.setIdBarang(rs.getString("idBarang"));
                mhs.setNamaBarang(rs.getString("NamaBarang"));
                mhs.setJenisBarang(rs.getString("JenisBarang"));
                mhs.setHarga(rs.getString("harga"));
                mhs.setJumlah(rs.getString("jumlah"));
                
                list.add(mhs);
            }
        } catch (SQLException e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public Inventory getByID(String nim){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM barang WHERE idPart = ?";
        Inventory mhs = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, nim);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
               mhs = new Inventory();
                mhs.setIdBarang(rs.getString("IdBarang"));
                mhs.setNamaBarang(rs.getString("NamaBarang"));
                mhs.setJenisBarang(rs.getString("JenisBarang"));
                mhs.setHarga(rs.getString("Harga"));
                mhs.setJumlah(rs.getString("Jumlah"));
            }
        } catch (SQLException e) {
        }
        return mhs;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(Inventory mhs){
        boolean status = false;
        String sql = "INSERT INTO mahasiswa VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, mhs.getIdBarang());
            statement.setString(2, mhs.getNamaBarang());
            statement.setString(3, mhs.getJenisBarang());
            statement.setString(4, mhs.getHarga());
            statement.setString(5, mhs.getJumlah());
            
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (SQLException e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(Inventory mhs){
        boolean status = false;
        String sql = "UPDATE sparepart SET namaPart=?, merkPart=?, harga=?, jumlah=? " +
                "WHERE idPart=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, mhs.getNamaBarang());
            statement.setString(2, mhs.getJenisBarang());
            statement.setString(3, mhs.getHarga());
            statement.setString(4, mhs.getJumlah());
            statement.setString(5, mhs.getIdBarang());
           
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (SQLException e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(Inventory mhs){
        boolean status = false;
        String sql = "DELETE FROM sparepart WHERE idPart=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(5, mhs.getIdBarang());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (SQLException e) {
        }
        return status;
    }

    private static class ConnectionUtil {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public ConnectionUtil() {
        }
    }
}
