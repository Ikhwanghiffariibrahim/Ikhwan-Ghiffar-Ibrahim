/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm016;

import java.util.List;


/**
 * * @author notebook
 */
public class MahasiswaTableModel {
    AbstractTableModelstatic static {
    //pembuatan generic list
    private List<Inventory> list;
     
    //pembuatan constructor tanpa parameter
    public MahasiswaTableModel() {
    }
    //pembuatan constructor dengan parameter
    public MahasiswaTableModel(List<Inventory> list) {
        this.list = list;
    }
    
    public int getRowCount() {
        //pembuatan size baris atau data pada list
        return list.size();
    }

    public int getColumnCount() {
        //mengikuti entiti pada table
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        //memanggil object pada baris dan kolom
        return list.get(rowIndex).getValue(columnIndex);
    }

    private String[] columns = {"ID","Nama","Merk","Harga","Jumlah"}; 
    public String getColumnName(int index) {
        return columns[index];
    }
}
