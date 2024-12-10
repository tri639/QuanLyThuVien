import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThuVien thuVien = null;

        while (true) {
            System.out.println("\n--- Quản Lý Thư Viện ---");
            System.out.println("1. Tạo thư viện mới");
            System.out.println("2. Thêm sách vào thư viện");
            System.out.println("3. Xóa sách khỏi thư viện");
            System.out.println("4. Tìm kiếm sách theo tiêu đề hoặc tác giả");
            System.out.println("5. Hiển thị danh sách sách trong thư viện");
            System.out.println("6. Xuất thông tin thư viện");
            System.out.println("7. Sắp xếp danh sách sách theo tên hoặc năm xuất bản");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID thư viện: ");
                    int idThuVien = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên thư viện: ");
                    String tenThuVien = scanner.nextLine();
                    thuVien = new ThuVien(idThuVien, tenThuVien);
                    System.out.println("Thư viện \"" + tenThuVien + "\" đã được tạo.");
                    break;

                case 2:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Thêm sách
                    System.out.print("Nhập ID sách: ");
                    int idSach = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tiêu đề sách: ");
                    String tieuDe = scanner.nextLine();
                    System.out.print("Nhập tác giả sách: ");
                    String tacGia = scanner.nextLine();
                    System.out.print("Nhập thể loại sách: ");
                    String theLoai = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int namXuatBan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập trạng thái sách (D:Đã mượn, C: Chưa mượn): ");
                    char trangThai = scanner.nextLine().charAt(0);

                    Sach sachMoi = new Sach(idSach, tieuDe, tacGia, theLoai, namXuatBan, trangThai);
                    thuVien.themSachMoi(sachMoi);
                    System.out.println("Sách \"" + tieuDe + "\" đã được thêm vào thư viện.");
                    break;

                case 3:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Xóa sách khỏi thư viện
                    System.out.print("Nhập ID sách cần xóa: ");
                    int idXoa = scanner.nextInt();
                    thuVien.xoaSach(idXoa);
                    System.out.println("Sách với ID " + idXoa + " đã được xóa.");
                    break;

                case 4:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Tìm kiếm sách theo tiêu đề hoặc tác giả
                    System.out.print("Nhập tiêu đề sách (hoặc để trống để tìm theo tác giả): ");
                    String tieuDeTim = scanner.nextLine();
                    System.out.print("Nhập tác giả sách (hoặc để trống để tìm theo tiêu đề): ");
                    String tacGiaTim = scanner.nextLine();

                    List<Sach> ketQuaTimKiem = thuVien.timKiemSach(tieuDeTim, tacGiaTim);
                    if (ketQuaTimKiem.isEmpty()) {
                        System.out.println("Không tìm thấy sách.");
                    } else {
                        System.out.println("Kết quả tìm kiếm:");
                        for (Sach sach : ketQuaTimKiem) {
                            System.out.println(sach);
                        }
                    }
                    break;

                case 5:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Hiển thị danh sách sách trong thư viện
                    System.out.println("Danh sách sách trong thư viện:");
                    for (Sach sach : thuVien.hienThiDanhSachSach()) {
                        System.out.println(sach);
                    }
                    break;

                case 6:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Xuất thông tin thư viện
                    System.out.println(thuVien);
                    break;

                case 7:
                    if (thuVien == null) {
                        System.out.println("Vui lòng tạo thư viện trước.");
                        break;
                    }
                    // Sắp xếp danh sách sách
                    System.out.println("Chọn cách sắp xếp:");
                    System.out.println("1. Theo năm xuất bản");
                    System.out.println("2. Theo tên sách");
                    System.out.print("Lựa chọn: ");
                    int sapXepChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (sapXepChoice == 1) {
                        thuVien.hienThiDanhSachSach().sort((s1, s2) -> Integer.compare(s1.getNamXuatBan(), s2.getNamXuatBan()));
                    } else if (sapXepChoice == 2) {
                        thuVien.hienThiDanhSachSach().sort((s1, s2) -> s1.getTieuDe().compareToIgnoreCase(s2.getTieuDe()));
                    }
                    System.out.println("Danh sách sách đã được sắp xếp.");
                    break;

                case 8:
                    // Thoát
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
