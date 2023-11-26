import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ProductList {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> ProductList = new ArrayList<>();
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
                    ProductList.add(i, new Clothing());
                    break;
                case 2:
                    ProductList.add(i, new Accessories());
                    break;
                default:
                    System.out.println("Error, try againt !.");
                    i--; // Quay lại nhập lựa chọn
                    continue;
            }
            ProductList.get(i).input();
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
                    Clothing clothing = (Clothing) product;
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
                    Accessories accessories = (Accessories) product;
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-20s | %-15s |\n",
                            accessories.getProductId(), accessories.getProductName(),
                            accessories.getPrice(), accessories.getMaterial(), accessories.getSize(), accessories.getType(),accessories.getQuantity());
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
    }




    public void editProductbyid() {
        System.out.println("What kind of product do you want to Edit?");
        System.out.println("1. Clothing\n2. Accessories");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        for (Product product : ProductList)
        {
            if ( isMatchingProduct(product,choice,id))
            {
                product.input();
            }
        }
        System.out.println("Product with ID " + id + " not found.");
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
        System.out.println("What kind of products do you want to delete?");
        System.out.println("1. Clothing\n2. Accessories");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        for (Product product : ProductList) {
            if (isMatchingProduct(product, choice, id)) {
                ProductList.remove(product);
                System.out.println("Product has been deleted.");
                writeToFile("Clothing.txt","Accessories.txt");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }
    public void find()
    {
        System.out.println("What kind of products do you want to find?");
        System.out.println("1 .Clothing\n2 .Accessories");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        for (Product product : ProductList) {
            if (isMatchingProduct(product, choice, id)) {
                product.display();
            }

        }

        System.out.println("Product with ID " + id + " not found.");

    }
    private boolean isMatchingProduct(Product product, int choice, String id) {
        return (choice == 1 && product instanceof Clothing && product.getProductId().equals(id)) ||
                (choice == 2 && product instanceof Accessories && product.getProductId().equals(id));
    }


    public void writeToFile(String clothingFileName, String accessoriesFileName) {
        try {
            // Xóa toàn bộ nội dung của tệp cũ
            Files.write(Paths.get(clothingFileName), new byte[0]);
            Files.write(Paths.get(accessoriesFileName), new byte[0]);

            // Ghi dữ liệu mới vào tệp
            try (FileOutputStream clothingFos = new FileOutputStream(clothingFileName, true);
                 FileOutputStream accessoriesFos = new FileOutputStream(accessoriesFileName, true)) {

                for (Product product : ProductList) {
                    String line = product.getFileLine() + "\n"; // Thêm ký tự xuống dòng
                    byte[] b = line.getBytes(StandardCharsets.UTF_8);

                    if (product instanceof Clothing) {
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
        try (BufferedReader salegentReader = new BufferedReader(new FileReader(ClothingFileName));
             BufferedReader storekeeperReader = new BufferedReader(new FileReader(AccessoriesFileName))) {

            // Read clothing file
            String clline;
            while ((clline = salegentReader.readLine()) != null) {
                if (!clline.isEmpty()) {
                    Clothing cl = new Clothing();
                    cl.Parse(clline);
                    ProductList.add(cl);
                }
            }

            // Read accessories file
            String acline;
            while ((acline = storekeeperReader.readLine()) != null) {
                if (!acline.isEmpty()) {
                    Accessories ac = new Accessories();
                    ac.Parse(acline);
                    ProductList.add(ac);
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}
