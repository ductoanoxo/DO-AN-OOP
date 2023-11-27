import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProductList implements method {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> ProductList = new ArrayList<>(); // khởi tạo list với arraylist chứa các đối tượng kiểu Product
    Clothing cl = new Clothing();
    Accessories ac = new Accessories();
    int quantity;

    public void input() {
        System.out.print("How many products do you want to import?");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Select product type (1: Clothing, 2: Accessories)");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ProductList.add( new Clothing());      // khởi tạo đối tượng rồi thêm vào danh sách
                    break;
                case 2:
                    ProductList.add( new Accessories());
                    break;
                default:
                    System.out.println("Error, try againt !.");
                    i--; // Quay lại nhập lựa chọn
                    continue;
            }
            ProductList.get(i).input();  // truy cập đến phương thức input của các đối tượng trong mảng
        }

    }

    public void display() {
        System.out.println("------------------------------------------------------------------CLOTHING LIST------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Product ID", "Name", "Price", "Material", "Size", "Color", "Style","Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        if (ProductList.isEmpty()) {
            System.out.println("No clothing products to display.");
        } else {
            for (Product product : ProductList) {
                if (product instanceof Clothing) {
                    Clothing clothing = (Clothing) product;   // ép kiểu product từ lớp cha trong productlist thành kiểu con
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                            clothing.getProductId(), clothing.getProductName(),
                            clothing.getPrice(), clothing.getMaterial(), clothing.getSize(), clothing.getColor(),clothing.getStyle(),clothing.getQuantity(), "");
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------ACCESSORIES LIST-----------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-20s | %-15s |\n",
                "Product ID", "Name", "Price", "Material", "Size", "Type","Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        if (ProductList.isEmpty()) {
            System.out.println("No accessories products to display.");
        } else {
            for (Product product : ProductList) {
                if (product instanceof Accessories) {
                    Accessories accessories = (Accessories) product; // ép kiểu product từ lớp cha trong productlist thành kiểu con
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-20s | %-15s |\n",
                            accessories.getProductId(), accessories.getProductName(),
                            accessories.getPrice(), accessories.getMaterial(), accessories.getSize(), accessories.getType(),accessories.getQuantity());
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
    }




    public void editbyid() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to find?");
            System.out.println("1. Clothing\n2. Accessories");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Product product :ProductList) {
                if (isMatchingProduct(product, choice, id)) {
                    product.input();
                    idFound = true;
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }

    public void add()
    {
        System.out.print("How many products do you want to add?");
        quantity = sc.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("1. Clothing\n2. Accessories");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ProductList.add( new Clothing());
                    break;
                case 2:
                    ProductList.add( new Accessories());
                    break;
                default:
                    System.out.println("Error, try againt !.");
                    i--; // Quay lại nhập lựa chọn
                    continue;
            }
            ProductList.get(ProductList.size() - 1).input(); // Gọi phương thức input() của sản phẩm cuối cùng
            writeToFile("Clothing.txt","Accessories.txt");
        }


    }
    public void delete() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to find?");
            System.out.println("1. Clothing\n2. Accessories");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Product product :ProductList) {
                if (isMatchingProduct(product, choice, id)) {
                    ProductList.remove(product);
                    idFound = true;
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }

    public void find() {
        int choice;

        do {
            System.out.println("What kind of employee do you want to find?");
            System.out.println("1. Clothing\n2. Accessories");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 1 && choice != 2);

        boolean idFound;

        do {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            idFound = false;

            for (Product product :ProductList) {
                if (isMatchingProduct(product, choice, id)) {
                    product.display();
                    idFound = true;
                    break; // Thoát khỏi vòng lặp khi tìm thấy ID
                }
            }

            if (!idFound) {
                System.out.println("Employee with ID " + id + " not found. Please try again.");
            }

        } while (!idFound);
    }
    private boolean isMatchingProduct(Product product, int choice, String id) {
        return (choice == 1 && product instanceof Clothing && product.getProductId().equals(id)) ||
                (choice == 2 && product instanceof Accessories && product.getProductId().equals(id));
    } // hàm này để tìm thấy sản phẩm khi có lựa chọn 1 và 2 trong các hàm tìm id


    public void writeToFile(String clothingFileName, String accessoriesFileName) {
        try {
            // Xóa toàn bộ nội dung của tệp cũ
            Files.write(Paths.get(clothingFileName), new byte[0]);
            Files.write(Paths.get(accessoriesFileName), new byte[0]);

            // Ghi dữ liệu mới vào tệp
            try (FileOutputStream clothingFos = new FileOutputStream(clothingFileName, true); // mở fos để ghi vào file name
                 FileOutputStream accessoriesFos = new FileOutputStream(accessoriesFileName, true)) {

                for (Product product : ProductList) {              // duyệt qua danh sách sản phẩm
                    String line = product.getFileLine() + "\n"; // Gọi phương thức getFileLine của mỗi product
                    byte[] b = line.getBytes(StandardCharsets.UTF_8); // chuyển đổi dòng thành mảng byte

                    if (product instanceof Clothing) { // kiểm tra xem product đó có phải clothing không
                        clothingFos.write(b);
                    } else if (product instanceof Accessories) {
                        accessoriesFos.write(b);
                    }
                }

                System.out.println("Data has been written to the files successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the files.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file content.");
            e.printStackTrace();
        }
    }

    public void readFromFile(String ClothingFileName, String AccessoriesFileName) {
        try (BufferedReader clReader = new BufferedReader(new FileReader(ClothingFileName));
             BufferedReader clkeeperReader = new BufferedReader(new FileReader(AccessoriesFileName))) {

            // Read clothing file
            String clline;
            while ((clline = clReader.readLine()) != null) {   // đọc từ dòng từ tệp
                if (!clline.isEmpty()) { // Kiểm tra xem dòng đọc được có rỗng hay không trước khi xử lý.
                    Clothing cl = new Clothing(); // khởi tạo biến cl từ kiểu dữ liệu clothing
                    cl.Parse(clline); // lầy từng phần tử từ hàm parse qua
                    ProductList.add(cl); // thêm vào mảng
                }
            }

            // Read accessories file
            String acline;
            while ((acline = clReader.readLine()) != null) {
                if (!acline.isEmpty()) {
                    Accessories ac = new Accessories();
                    ac.Parse(acline);
                    ProductList.add(ac);
                }
            }

        } catch (IOException ex) { // ngoại lệ thường được sử dụng với các lỡi liên quan tới output và input
            throw new RuntimeException(ex);
        }
    }


}
