
    import java.io.*;
    import java.nio.charset.StandardCharsets;
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
            System.out.println("---------------PRODUCTS LIST---------------");

            if (ProductList.isEmpty()) {
                System.out.println("No products to display.");
            } else {
                for ( Product product : ProductList)
                {
                    product.display();
                    System.out.println();
                }
            }
        }

        public void editProductbyid() {
            System.out.print("Enter id :");
            String id = sc.nextLine();
            for (Product product : ProductList) {
                if (Objects.equals(product.getProductId(), id)) {
                    product.input();
                    break;
                }
            }
        }
        public void add(String fileName)
        {
            input();
            writeToFile(fileName);
        }

        public void writeToFile(String fileName) {
            try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
                for (Product product : ProductList) {
                    String line = product.getFileLine() + "\n"; // Thêm ký tự xuống dòng
                    byte[] b = line.getBytes(StandardCharsets.UTF_8);
                    fos.write(b);
                }
                System.out.println("Data has been written to the file successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        }
        public void readFromFile(String fileName) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.isEmpty()) {
                        int elementCount = count(line);
                        if (elementCount == 8) {
                            Clothing cl = new Clothing();
                            cl.Parse(line);
                            ProductList.add(cl);
                        } else {
                            Accessories ac = new Accessories();
                            ac.Parse(line);
                            ProductList.add(ac);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public int count(String line) {
            // chia chuỗi thành các chuỗi con phân cách bởi dấu phẩy
            String[] arr = line.split(",");
            int count = 0;
            for (String s : arr) {
                if (!s.isEmpty()) {
                    count++;
                }
            }
            return count;
        }
    }
