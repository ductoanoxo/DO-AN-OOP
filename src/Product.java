import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Product {


    private String productId;
    private String productName;
    private int price;
    private int quantity;
    private String size;
    String comba =",";

    Scanner sc = new Scanner(System.in);

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public String getProductId() {
        return productId;
    }

    public Product() {
        productName = "";
        productId = "";
        price = 0;
        quantity = 0;
    }

    public Product(String productName, String productId, int price, int quantity) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
    public void input() {
        System.out.print("Product ID: ");
        productId = sc.nextLine();
        System.out.print("Product Name: ");
        productName = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextInt();
        System.out.print("Quantity: ");
        quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Size");
        size = sc.nextLine();
    }

    public void display() {
        System.out.print(this);
    }
    @Override
    public String toString()
    {
        return "Id :" + productId +comba+"Name :" + productName+comba+"Price :" + price +comba+"Quantity :" +quantity +comba+"Size :"+size+comba; // trả về chuỗi để in thông tin riêng
    }
    public String getFileLine()
    {
        return  productId +comba+ productName+comba+ price +comba+quantity +comba+size+comba; // trả về chuỗi để ghi file
    }
    public void Parse(String line)
    {

            String[] params = line.split(","); // chia chuỗi thành mảng các phần tử
            productId = params[0];                    // gán cho các phần tử
            productName = params[1];
            price = parseInt(params[2]);
            quantity = parseInt(params[3]);
            size = params[4];


    }


}
