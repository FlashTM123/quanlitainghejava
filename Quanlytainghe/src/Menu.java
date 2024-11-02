import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private information information = new information();
    private function function = new function();

    protected void menu() {
        int n;
        do {
            System.out.println("=========Menu=========");
            System.out.println("1. Thông tin chương trình");
            System.out.println("2. Chức năng tai nghe");
            System.out.println("0. Thoát");
            System.out.print("Chọn 1 menu: ");
            n = scanner.nextInt();
            scanner.nextLine();

            while (n < 0 || n > 2) {
                System.out.print("Chọn lại menu: ");
                n = scanner.nextInt();
                scanner.nextLine();
            }

            switch (n) {
                case 1:
                    menuInfo();
                    break;
                case 2:
                    menufunction();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    break;
            }
        } while (n != 0);
    }

    private void menuInfo() {
        int n;
        do {
            System.out.println("=======Menu Thông tin=======");
            System.out.println("1. Thêm mới");
            System.out.println("2. Hiển thị danh sách tai nghe");
            System.out.println("0. Quay lại");
            System.out.print("Chọn 1 menu: ");
            n = scanner.nextInt();
            scanner.nextLine();

            while (n < 0 || n > 2) {
                System.out.print("Chọn lại thông tin: ");
                n = scanner.nextInt();
                scanner.nextLine();
            }

            switch (n) {
                case 1:
                    information.infoTN();
                    break;
                case 2:
                    information.showTN();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    break;
            }
        } while (n != 0);
    }
    private void menufunction() {
        int n;
        do {
            System.out.println("=======Menu Chức năng tai nghe=======");
            System.out.println("1. Cập nhật tai nghe");
            System.out.println("2. Xóa tai nghe");
            System.out.println("0. Quay lại");
            System.out.print("Chọn 1 menu: ");
            n = scanner.nextInt();
            scanner.nextLine();

            while (n < 0 || n > 2) {
                System.out.print("Chọn lại chức năng: ");
                n = scanner.nextInt();
                scanner.nextLine();
            }

            switch (n) {
                case 1:
                    // Gọi phương thức cập nhật tai nghe
                    function.updateTN();
                    break;
                case 2:
                    // Gọi phương thức xóa tai nghe
                    function.deleteTN();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    break;
            }
        } while (n != 0);
    }

}
