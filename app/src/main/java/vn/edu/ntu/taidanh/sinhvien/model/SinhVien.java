package vn.edu.ntu.taidanh.sinhvien.model;

public class SinhVien {
    int id;
    String maSV, ten, gioiTinh, ngaySinh, diemHkI, diemHkII;

    public SinhVien(String maSV, String ten, String gioiTinh, String ngaySinh, String diemHkI, String diemHkII) {
        this.maSV = maSV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diemHkI = diemHkI;
        this.diemHkII = diemHkII;
    }
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiemHkI() {
        return diemHkI;
    }

    public void setDiemHkI(String diemHkI) {
        this.diemHkI = diemHkI;
    }

    public String getDiemHkII() {
        return diemHkII;
    }

    public void setDiemHkII(String diemHkII) {
        this.diemHkII = diemHkII;
    }
}
