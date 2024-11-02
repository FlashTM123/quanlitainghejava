import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class function {

        protected String host = "jdbc:mysql://localhost:3306/quanlytainghe";
        protected String username = "root";
        protected String password = "";

        protected Connection connection;
        protected Scanner scanner = new Scanner(System.in);

        // Khởi tạo kết nối
        public function() {
            try {
                connection = DriverManager.getConnection(host, username, password);
                if (connection != null) {
                    System.out.println("Kết nối cơ sở dữ liệu thành công!");
                }
            } catch (Exception e) {
                System.out.println("Kết nối cơ sở dữ liệu thất bại!");
                e.printStackTrace();
            }
        }

        // Phương thức cập nhật tai nghe
        protected void updateTN() {
            System.out.print("Nhập mã tai nghe cần sửa: ");
            int maTN = scanner.nextInt();
            scanner.nextLine();

            String sqlCheck = "SELECT * FROM tainghe WHERE maTN = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sqlCheck);
                statement.setInt(1, maTN);
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Không tồn tại mã tai nghe này!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi trong khi kiểm tra mã tai nghe.");
                e.printStackTrace();
            }

            System.out.print("Nhập tên tai nghe mới: ");
            String tenTNU = scanner.nextLine();
            System.out.print("Nhập giá bán mới: ");
            double priceU = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Nhập màu sắc mới: ");
            String mau_sacU = scanner.nextLine();
            System.out.print("Nhập nhà sản xuất mới: ");
            String nhaSXU = scanner.nextLine();

            String sqlUpdate = "UPDATE tainghe SET tenTN = ?, price = ?, mau_sac = ?, nhaSX = ? WHERE maTN = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                statement.setString(1, tenTNU);
                statement.setDouble(2, priceU);
                statement.setString(3, mau_sacU);
                statement.setString(4, nhaSXU);
                statement.setInt(5, maTN);

                int check = statement.executeUpdate();
                if (check == 1) {
                    System.out.println("Cập nhật tai nghe thành công");
                } else {
                    System.out.println("Cập nhật thất bại!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi trong khi cập nhật thông tin tai nghe.");
                e.printStackTrace();
            }
        }

        // Phương thức xóa tai nghe
        public void deleteTN() {
            System.out.print("Nhập mã tai nghe cần xóa: ");
            int maTN = scanner.nextInt();
            scanner.nextLine();

            String sqlCheck = "SELECT * FROM tainghe WHERE maTN = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sqlCheck);
                statement.setInt(1, maTN);
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Không tồn tại mã tai nghe này!");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi trong khi kiểm tra mã tai nghe.");
                e.printStackTrace();
            }

            System.out.print("Bạn chắc chắn muốn xóa? (Y/N): ");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("Y")) {
                String sql = "DELETE FROM tainghe WHERE maTN = ?";
                try {
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, maTN);

                    int checkResult = statement.executeUpdate();
                    if (checkResult == 1) {
                        System.out.println("Xóa tai nghe thành công");
                    } else {
                        System.out.println("Xóa thất bại!");
                    }
                } catch (Exception e) {
                    System.out.println("Lỗi trong khi xóa tai nghe.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Hủy thao tác xóa.");
            }
        }
    }

