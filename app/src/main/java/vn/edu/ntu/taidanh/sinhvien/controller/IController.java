package vn.edu.ntu.taidanh.sinhvien.controller;

import java.util.List;

import vn.edu.ntu.taidanh.sinhvien.model.SinhVien;

public interface IController {
    public List<SinhVien> getAllSinhVien();
    public boolean add(SinhVien sv);
    public boolean remove(String name);
}
