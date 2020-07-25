package vn.edu.ntu.taidanh.sinhvien.controller;


import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.taidanh.sinhvien.model.SinhVien;

public class controller extends Application implements IController{
    List<SinhVien> listSinhVien = new ArrayList<>();

    public controller() {
        listSinhVien.add(new SinhVien("Sv01","Nguyễn Tài danh","Nam","15-7-1999","9","8"));
        listSinhVien.add(new SinhVien("Sv02","Nguyễn Văn Hưng","Nữ","05-04-1999","7","6"));
        listSinhVien.add(new SinhVien("Sv03","Trần Chí Dũng","Nam","17-06-1999","5","4"));
    }

    @Override
    public List<SinhVien> getAllSinhVien() {
        return listSinhVien;
    }
    @Override
    public boolean add(SinhVien sv) {
        if(this.listSinhVien.contains(sv))
            return false;
        this.listSinhVien.add(sv);
        return true;
    }
    public String getName(SinhVien sv){
        return sv.getTen();
    }
    @Override
    public boolean remove(String name) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getTen() == name) {
                listSinhVien.remove(sv);
                return true;
            }
        }
        return false;
    }
}
