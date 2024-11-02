import java.sql.*;
import java.util.Scanner;

public class information {
    //   Tạo thành phần kết nối đến CSDL
    protected String host = "jdbc:mysql://localhost:3306/quanlytainghe";
    protected String username = "root";
    protected String password = "";

    protected Connection connection;
    protected Scanner scanner = new Scanner(System.in);

    //    Tạo truy vấn kết nối
    public information() {
        try {
            connection = DriverManager.getConnection(host, username, password);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // Truy vấn thêm bản ghi vào CSDL
    protected void insert(int maTN, String tenTN, double price, String mau_sac, String nhaSX) {
        String sqlcheck = "SELECT * FROM tainghe WHERE maTN =?";
        try {
            PreparedStatement checkStatement = connection.prepareStatement(sqlcheck);
            checkStatement.setInt(1, maTN);
            ResultSet resultSet = checkStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Mã tai nghe đã tồn CMN tại! Vui lòng nhập số khác. ");
                return;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO tainghe VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, maTN);
            statement.setString(2, tenTN);
            statement.setDouble(3, price);
            statement.setString(4, mau_sac);
            statement.setString(5, nhaSX);
            int check = statement.executeUpdate();
            if (check == 1) {
                System.out.println("Thêm tai nghe thành công");
            } else {
                System.out.println("Thêm tai nghe thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy dữ liệu từ bàn phím
    public void infoTN() {
        System.out.println("Nhập mã tai nghe: ");
        int maTN = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên tai nghe: ");
        String tenTN = scanner.nextLine();
        System.out.println("Nhập giá bán: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập màu sắc: ");
        String mau_sac = scanner.nextLine();
        System.out.println("Nhập nhà sản xuất: ");
        String nhaSX = scanner.nextLine();
        insert(maTN, tenTN, price, mau_sac, nhaSX);
    }

    // Hiển thị danh sách tai nghe
    protected void showTN() {
        String sql = "SELECT * FROM tainghe";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("=========Danh sách tai nghe======");
            System.out.println("Mã TN \t Tên TN \t Giá bán \t Màu sắc \t Nhà SX");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("maTN") + "\t" + "  |  " +
                        resultSet.getString("tenTN") + "\t" + "  |  " +
                        resultSet.getDouble("price") + "\t" + "  |  " +
                        resultSet.getString("mau_sac") + "\t" + " |  " +
                        resultSet.getString("nhaSX"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cập nhật thông tin tai nghe


    // Menu thông tin tai nghe
//    public void menuInfo() {
//        int n = 0;
//        do {
//            System.out.println("========Information========");
//            System.out.println("1. Thêm mới");
//            System.out.println("2. Hiển thị danh sách");
//            System.out.println("3. Sửa tai nghe");
//            System.out.println("4. Xoá tai nghe");
//            System.out.println("0. Quay lại");
//            System.out.println("Chọn 1 menu: ");
//            n = scanner.nextInt();
//            scanner.nextLine();
//            while (n < 0 || n > 4) {
//                System.out.println("Chọn lại menu: ");
//                n = scanner.nextInt();
//                scanner.nextLine();
//            }
//            switch (n) {
//                case 1:
//                    infoTN();
//                    break;
//                case 2:
//                    showTN();
//                    break;
//                case 3:
//                    updateTN();
//                    break;
//                case 4:
//                    deleteTN();
//                    break;
//            }
//        } while (n != 0);
//    }

//    public void menu() {
//        int n = 0;
//        do {
//            System.out.println("========Menu========");
//            System.out.println("1. Thông tin tai nghe");
//            System.out.println("0. Thoát chương trình");
//            System.out.println("Chọn 1 menu: ");
//            n = scanner.nextInt();
//            scanner.nextLine();
//            while (n < 0 || n > 1) {
//                System.out.println("Chọn lại menu: ");
//                n = scanner.nextInt();
//                scanner.nextLine();
//            }
//            switch (n) {
//                case 1:
//                    menuInfo();
//                    break;
//                case 0:
//                    System.out.println("Thoát chương trình.");
//                    break;
//            }
//        } while (n != 0);
//    }
}