public class Sach {
    private int id;
    private String tieuDe;
    private String tacGia;
    private String theLoai;
    private int namXuatBan;
    private char trangThai;

    public Sach(int id, String tieuDe, String tacGia, String theLoai, int namXuatBan, char trangThai) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.namXuatBan = namXuatBan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }
    public String getTieuDe() {
        return tieuDe;
    }
    public String  getTacGia() {
        return tacGia;
    }
    public String getTheLoai() {
        return theLoai;
    }
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public char getTrangThai() {
        return trangThai;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    public void setTrangThai(char trangThai) {
        this.trangThai = trangThai;
    }

    public String toString() {
        return "Thông tin sách: ID: " + id + ", Tiêu Đề: " + tieuDe + ", Tác Giả: " + tacGia + ", Thể Loại: " + theLoai + ", Năm Xuất Bản: " + namXuatBan + ", Trạng Thái: " + trangThai;
    }
}
