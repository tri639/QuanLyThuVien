import java.util.ArrayList;
import java.util.List;

public class ThuVien implements QuanLySach {
    private int id;
    private String tenThuVien;
    private List<Sach> danhSachSach;

    public ThuVien (int id, String tenThuVien) {
        this.id = id;
        this.tenThuVien = tenThuVien;
        this.danhSachSach = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getTenThuVien() {
        return tenThuVien;
    }
    public List<Sach> getdanhSachSach() {
        return danhSachSach;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTenThuVien(String tenThuVien) {
        this.tenThuVien = tenThuVien;
    }
    public void setDanhSachSach(List<Sach> danhSachSach) {
        this.danhSachSach = danhSachSach;
    }

    // Thêm Sách
    public void themSachMoi(Sach sach) {
        danhSachSach.add(sach);
    }
    // Xóa Sách Theo ID
    public void xoaSach(int id) {
        danhSachSach.removeIf(sach -> sach.getId() == id);
    }
    // Tìm Kiếm Sách Dựa Trên Tiêu Đề Hoặc Tác Giả
    @Override
    public List<Sach> timKiemSach(String tieuDe, String tacGia) {
        List<Sach> ketQua = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if ((tieuDe != null && sach.getTieuDe().toLowerCase().contains(tieuDe.toLowerCase())) ||
               (tacGia != null && sach.getTacGia().toLowerCase().contains(tacGia.toLowerCase()))) {
               ketQua.add(sach);
            }
        }
        return ketQua;
    }
    // Hiển Thị Danh Sách Sách
    @Override
    public List<Sach> hienThiDanhSachSach() {
        return danhSachSach;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append("Tên Thư Viện: ").append(tenThuVien)
                .append("Tổng Số Sách: ").append(danhSachSach.size())
                .append("Danh Sách Sách: ").append(danhSachSach);

        // Thêm Thông Tin Từng Cuốn
        for (Sach sach : danhSachSach) {
            sb.append("\n").append(sach.toString());
        }
        return sb.toString();
    }
}
