import java.util.List;

public interface QuanLySach {
    void themSachMoi(Sach Sach);
    void xoaSach(int id);
    List<Sach> timKiemSach(String tieuDe, String tacGia);
    List<Sach> hienThiDanhSachSach();
}
